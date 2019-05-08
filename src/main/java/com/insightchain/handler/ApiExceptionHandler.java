package com.insightchain.handler;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.exc.UnrecognizedPropertyException;
import com.insightchain.common.constants.PropertiesConstant;
import com.insightchain.common.domain.exception.CommonException;
import com.insightchain.common.domain.resp.ResponseCode;
import com.insightchain.common.domain.resp.ResponseObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.nio.file.AccessDeniedException;

/**
*
* @description global exception handler
* @time 2019/1/21 3:56
* @author tianxiang@insightchain.io
*
*/
@Slf4j
@RestControllerAdvice
public class ApiExceptionHandler {

    public final String SEPARATOR = "\"";

    /**
     * 全局异常捕捉处理
     * @param ex
     * @return
     */
    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public ResponseObject errorHandler(HttpServletRequest request,
                                       HttpServletResponse response, Object handler, Exception ex) {
        ResponseObject fault = null;
        try {
            log.error("Exception Handle the exception, detail:", ex);
            if(PropertiesConstant.IS_DEBUG){
                if (ex instanceof MissingServletRequestParameterException) {
                    MissingServletRequestParameterException msrpe = (MissingServletRequestParameterException) ex;
                    fault = ResponseObject.getFailedResponseObject(request, ResponseCode.MISSING_PARAMETER, msrpe.getParameterName(), msrpe.getParameterType());
                }else if(ex instanceof TypeMismatchException) {
                    TypeMismatchException tme = (TypeMismatchException) ex;
                    fault = ResponseObject.getFailedResponseObject(request,
                            ResponseCode.TYPE_MISMATCH_EXCEPTION,
                            tme.getValue().toString(),
                            tme.getRequiredType().getName());
                }else if (ex instanceof HttpRequestMethodNotSupportedException) {
                    HttpRequestMethodNotSupportedException tme = (HttpRequestMethodNotSupportedException) ex;
                    fault = ResponseObject.getFailedResponseObject(request,
                            ResponseCode.HTTP_METHOD_NOT_SUPPORTED_EXCEPTION,
                            tme.getMethod());
                }else if (ex instanceof HttpMediaTypeNotSupportedException) {
                    HttpMediaTypeNotSupportedException tme = (HttpMediaTypeNotSupportedException) ex;
                    if(tme.getContentType() == null){
                        fault = ResponseObject.getFailedResponseObject(request,
                                ResponseCode.WRONG_JSON_FORMAT);
                    }else{
                        fault = ResponseObject.getFailedResponseObject(request,
                                ResponseCode.CONTENT_TYPE_NOTE_SUPPORTED,
                                tme.getContentType().toString());
                    }
                }else if (ex instanceof AccessDeniedException) {
                    fault = ResponseObject.getFailedResponseObject(request,
                            ResponseCode.ACCESS_DENIED, request.getServletPath().substring(1));
                }else if(ex instanceof HttpMessageNotReadableException){
                    fault = ResponseObject.getFailedResponseObject(request,
                            ResponseCode.WRONG_JSON_FORMAT);
                }else if(ex instanceof UnrecognizedPropertyException || ex instanceof JsonMappingException){
                    String msg = ex.getMessage().substring(0, ex.getMessage().lastIndexOf(SEPARATOR));
                    String field = ex.getMessage().substring(msg.lastIndexOf(SEPARATOR) + 1, ex.getMessage().lastIndexOf(SEPARATOR));
                    fault = ResponseObject.getFailedResponseObject(request,
                            ResponseCode.DATA_VALIDATION_ERROR,
                            field);
                }
            }
            if(fault == null){
                if (ex instanceof CommonException) {
                    CommonException exx = (CommonException)ex;
                    fault = ResponseObject.getFailedResponseObject(request,
                            exx.getResponseCode(),
                            exx.getResponseCodeParameters());
                }else{
                    // todo发送错误 邮件
                }
            }
        } catch(Exception e){

            log.error("unknown error in parse exception", e);
            fault = ResponseObject.getFailedResponseObject(request,
                    ResponseCode.UNKNOWN_EXCEPTION);

        }
        return fault;
    }

    /**
     * 拦截捕捉自定义异常 MyException.class
     * @param ex
     * @return
     */
    @ResponseBody
    @ExceptionHandler(value = CommonException.class)
    public ResponseObject myErrorHandler(CommonException ex,HttpServletRequest request,
                                         HttpServletResponse response, Object handler) {
        ResponseObject fault = null;
        if (ex instanceof CommonException) {
            CommonException exx = (CommonException)ex;
            fault = ResponseObject.getFailedResponseObject(request,
                    exx.getResponseCode(),
                    exx.getResponseCodeParameters());
        }
        return fault;
    }

   /* @ExceptionHandler({RuntimeException.class})
    @ResponseStatus(HttpStatus.OK)
    public ModelAndView processException(RuntimeException exception) {
        log.info("自定义异常处理-RuntimeException");
        ModelAndView mv = new ModelAndView();
        mv.addObject("exception",exception.getMessage());
        mv.setViewName("error/500");
        return mv;
    }

    *//**
     * 统一异常处理
     *
     * @param exception
     *            exception
     * @return
     *//*
    @ExceptionHandler({ Exception.class })
    @ResponseStatus(HttpStatus.OK)
    public ModelAndView processException(Exception exception) {
        log.info("自定义异常处理-Exception");
        ModelAndView m = new ModelAndView();
        m.addObject("exception", exception.getMessage());
        m.setViewName("error/500");
        return m;
    }*/
}
