package com.insightchain.common.domain.resp;

import static java.text.MessageFormat.format;

/**
 * This is the response code.
 *
 * @author jianxunji
 */
public enum ResponseCode {
	OPERATION_SUCCESS(2000, "{0}操作成功"),

	UNKNOWN_EXCEPTION(4000, "亲，出错啦，请稍后重试~"),
	//common exceptions
	MISSING_PARAMETER(4001, "缺少参数: {0}: {1}"),
	TYPE_MISMATCH_EXCEPTION(4002, "TYPE_MISMATCH_EXCEPTION=不能将值 {0} 转化为类型： {1}"),
	
	HTTP_METHOD_NOT_SUPPORTED_EXCEPTION(4003, "方法: {0} 不支持"),
	ACCESS_DENIED(4004, "拒绝访问: {0}"),
	WRONG_JSON_FORMAT(4006, "错误的JSON格式"),
	DATA_VALIDATION_ERROR(4007, "{0}类型的数据验证错误"),
	CONTENT_TYPE_NOTE_SUPPORTED(4008, "Content type {0}不支持"),


	;

	/**
	 * The unique numeric code to associate to the response.
	 */
	private int code;

	/**
	 * The response description.
	 */
	private String message;

	/**
	 * Constructor.
	 *
	 * @param code The unique numeric code to associate to the response.
	 * @param message The response description.
	 */
	private ResponseCode(int code, String message) {
		this.code = code;
		this.message = message;
	}

	/**
	 * Gets the unique numeric code which associates to the response.
	 *
	 * @return The unique numeric code which associates to the response.
	 */
	public int getCode() {
		return this.code;
	}

	/**
	 * Gets the response description.
	 *
	 * @param replacementParameters The parameters which replace the value of placeholder in response message.
	 * @return The response description.
	 */
	public String getMessage(Object... replacementParameters) {
		return format(this.message, replacementParameters);
	}
}
