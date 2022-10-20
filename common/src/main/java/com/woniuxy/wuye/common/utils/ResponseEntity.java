package com.woniuxy.wuye.common.utils;

//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.net.httpserver.Authenticator;
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
	/**
	 * 成功
	 * */
public static final ResponseEntity SUCCESS=new ResponseEntity("200","OK",null);
/**
 * 数据库操作异常
 * */
public static final ResponseEntity SQLFAILURE=new ResponseEntity("400","no","sql参数异常");

	private String code;//状态码code:200成功；500失败；400不合法；401无权限
	private String msg;//说明
	private T data;

}
