package com.insightchain.common.domain.exception;


import com.insightchain.common.domain.resp.ResponseCode;
import lombok.Data;

/**
* 
* @description 此类exception需要发送邮件
* @time 2019/5/8 14:54
* @author tianxiang@insightchain.io
*
*/
@Data
public class EmailException extends BaseException {



	/** response code */
	private ResponseCode responseCode;

	/** response parameters */
	private String[] responseCodeParameters;

	/**
	 * Constructor.
	 *
	 * @param errorMessage
	 *            err message
	 *
	 * @since
	 */
	public EmailException(String errorMessage) {
		super(errorMessage);
	}

	/**
	 * Constructor.
	 *
	 * @param responseCode
	 * @param responseCodeParameters
	 */
	public EmailException(ResponseCode responseCode, String[] responseCodeParameters) {
		super(responseCode == null ? "" : responseCode.getMessage((Object[])responseCodeParameters));
		this.responseCode = responseCode;
		this.responseCodeParameters = responseCodeParameters;
	}

	/**
	 * Constructor.
	 *
	 * @param responseCode
	 * @param responseCodeParameters
	 * @param causeException
	 */
	public EmailException(ResponseCode responseCode, String[] responseCodeParameters, Exception causeException) {
		super(causeException);
		this.responseCode = responseCode;
		this.responseCodeParameters = responseCodeParameters;
	}

	@Override
	public int getErrorCode() {
		return this.responseCode.getCode();
	}

	@Override
	public String getErrorText() {
		return getMessage();
	}

}
