package com.insightchain.common.domain.resp;

import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;
import java.sql.Timestamp;
import java.text.MessageFormat;

/**
*
* @description
* @time 2019/5/8 14:16
* @author tianxiang@insightchain.io
*
*/
@Data
public class ResponseObject implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7471183864145390638L;

	public static final String SUCCESS = "success";
	public static final String FAILED = "failed";
	private String result;
	private Integer code;
	private String message;
	private Object data;
	private Timestamp serverTime = new Timestamp(System.currentTimeMillis());
	private String clientIP;

	/**
	 * 无参构造器
	 */
	public ResponseObject() {

	}

	/**
	 * Constructor.
	 */
	public ResponseObject(String result, Integer code, String message, Object data) {
		super();
		this.result = result;
		this.code = code;
		this.message = message;
		this.data = data;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

    public static ResponseObject getSuccessfulResponseObject(Object data) {
        return new ResponseObject(SUCCESS, ResponseCode.OPERATION_SUCCESS.getCode(), null, data);
    }

	/**
	 * @param request
	 * @param responseCode
	 * @param args
	 * @return
	 */
	public static ResponseObject getFailedResponseObject(HttpServletRequest request, ResponseCode responseCode, String... args) {
		return new ResponseObject(FAILED, responseCode.getCode(), MessageFormat.format(responseCode.getMessage(), args), null);
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public Timestamp getServerTime() {
		return serverTime;
	}

	public Boolean getIsSuccessful(){
		return this.code != null && this.code.intValue() == ResponseCode.OPERATION_SUCCESS.getCode();
	}
	
	public static void main(String[] args) {
		String test = MessageFormat.format("{2}-{0}", 0, 1, 2);
		System.out.println(test);
	}

}
