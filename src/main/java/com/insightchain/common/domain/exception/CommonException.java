package com.insightchain.common.domain.exception;


import com.insightchain.common.domain.resp.ResponseCode;

/**
 * This is the common service exception.
 * 
 * @author jianxunji
 */
public class CommonException extends BaseException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3725074519277377880L;

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
	public CommonException(String errorMessage) {
		super(errorMessage);
	}

	/**
	 * Constructor.
	 * 
	 * @param responseCode
	 * @param responseCodeParameters
	 */
	public CommonException(ResponseCode responseCode, String[] responseCodeParameters) {
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
	public CommonException(ResponseCode responseCode, String[] responseCodeParameters, Exception causeException) {
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

	/**
	 * Get message code.
	 */
	public ResponseCode getMessageCode() {
		return this.responseCode;
	}

	public ResponseCode getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(ResponseCode responseCode) {
		this.responseCode = responseCode;
	}

	public String[] getResponseCodeParameters() {
		return responseCodeParameters;
	}

	public void setResponseCodeParameters(String[] responseCodeParameters) {
		this.responseCodeParameters = responseCodeParameters;
	}
}
