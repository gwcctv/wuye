package com.woniuxy.wuye.common.utils;

//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * code:200成功；500失败；400不合法；
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
//@JsonIgnoreProperties("handler")
public class ResponseEntity<T> {

	private String code;//状态码code:200成功；500失败；400不合法；401无权限
	private String msg;//说明
	private T data;

}
