package com.howieLuk.spring_exec.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
	
	@RequestMapping("/hello")
	public String index() {
		System.out.println("Hello, World!");
		return "index";
	}
	
	/*
	 * @RequestMapping参数：
	 * 		value：url
	 * 		method：RequestMethod枚举类 请求方式（如：GET/POST），默认全接受
	 * 		params:{"paramName1",...} 规定请求参数:
	 * 			{"paramName"}必须带上paramName才能访问成功
	 * 			{"!paramName"}必须没有paramName才能访问成功
	 * 			{"paramName=123"}必须paramName=123才能访问成功
	 * 			{"paramName!=123"}必须paramName!=123或者没有paramName才能访问成功
	 * 		headers:{"condition1",...} 规定请求头，与params类似
	 *  
	 *  ant风格：
	 *  	模糊匹配：
	 *  		URL可以写模糊通配符：如：?：替代任意一个字符 *：替代任意多个字符和一层路径 **：能代替多层路径
	 *  
	 *  
	 *  
	 */
	@RequestMapping(value = "/test1",
					method = RequestMethod.GET,
					params = {"id"})
	@ResponseBody
	public String test1(int id) {
		return String.valueOf(id);
	}
	
	/*
	 * REST风格：
	 * 		万物皆资源：每次请求规定为四种操作：GET、POST、PUT、DELETE
	 * 		例：
	 * 			添加图书：/book    methodType=POST
	 * 			查询图书：/book/1  methodType=GET
	 * 			更新图书：/book/1  methodType=PUT
	 * 			删除图书：/book/1  methodType=DELETE
	 * 		通过HiddenHttpMethodFilter可以解决将POST请求转换为PUT、DELETE（注意该过滤器需要位于CharacterEncodingFilter之后）
	 * 		如果高版本的tomcat不支持PUT、DELETE请求的话，可以通过在jsp头<%@ page language="java" ..%>中设置isErrorPage="true"即可
	 * 
	 * 优点：风格统一
	 * 以非常简洁的方式提交请求
	 * */
	/*
	 * springmvc支持rest风格
	 * 
	 * @PathVariable("xxx")可以将url中占位符参数绑定到控制器处理方法的参数中，如url=get/{xxx},可以通过@PathVariable("xxx")绑定到参数xxx中
	 */
	@RequestMapping("/test2/{test}")
	@ResponseBody
	public String test2(@PathVariable("test")String test) {
		return test;
	}
	
	/*
	 * SpringMVC获取参数方式：
	 * 		1. 提交参数里，paramName名字相同的绑定，如果没有该参数会给参数赋予null值
	 * 		2. @RequestParam("xxx")，明确指定某个参数的值，该参数默认必须带，如果不必须在属性设置@RequestParam(value="xxx", required=false)
	 * 			@RequestParam与@PathVariable的区别：
	 * 				@PathVariable是获取url路径中，占位符的值，不能获取到请求参数
	 * 				@RequestParam可以获取到请求参数，但不能获取url路径中占位符的值
	 * 		3. @RequestHeader("xxx")可以获取请求头中xxx的值，与@RequestParam类似，且还可以在注解里指定默认值@RequestHeader(value="xxx",defaultValue=)
	 * 		4. @CookieValue("xxx")可以从cookie中获取xxx的值，与2、3类似
	 * 	
	 * 	如果请求参数是一个pojo类，mvc会为pojo类的属性自动封装（名字相同），且可以实现级联封装
	 * 	
	 * 	原生API：
	 * 	JavaWeb中：HttpSession、HttpServletRequest、HttpServletResponse也可以通过在方法中添加对应参数即可获取如func(HttpSession session, ...)
	 * 		除了上面3个api外，还可以传入的API有：
	 * 			java.security.Principal
	 * 			Locals:国际化有关的区域对象
	 * 			InputStream: 输入字节流
	 * 			OutputStream: 输出字节流
	 * 			Reader: 输入字符流
	 * 			Writer: 输出字符流
	 */
	@RequestMapping("getParam")
	@ResponseBody
	public String getParam(
			@RequestParam(value="key", required=false)String key,
			@RequestHeader("Content-Type")String type) {
		System.out.println(key);
		System.out.println(type);
		return "";
	}
	
	/*
	 * 添加cookie
	 */
	@RequestMapping("/setCookie")
	@ResponseBody
	public String setCookie(HttpServletResponse res) {
		String name, val;
		name = "key";
		val = "value";
		res.addCookie(new Cookie(name, val));
		return "success";
	}
	
	/*
	 * 提交数据乱码解决：
	 * 		请求乱码：
	 * 			GET请求：改server.xml在<connector>标签的属性设置URIEncoding="UTF-8"
	 * 			POST请求：使用CharacterEncodingFilter或request.setCharacterEncoding("UTF-8")
	 * 		相应乱码：
	 * 			使用CharacterEncodingFilter或response.setContentType("text/html; charset'UTF-8'")
	 * 	
	 * 	CharacterEncodingFilter需要设置在其他Filter之前
	 */
	
	/*
	 * 如何将数据带到页面：
	 * 除了原生API外，还有以下方式：
	 * 		1. 可以传入Map<String, Object>、ModelMap、Model将数据带到页面，他们都会放在请求域中
	 * 		2. 将方法的返回值设为ModelAndView，一样是放在请求域中
	 * 给Session域中带数据（推荐使用原生api）：
	 * 		（推荐不用）1.使用@SessionAttribute(value={keys}或者types={classes..})，该注解只能标在类上，当keys被保存在请求域中（通过上述方式）时，keys的值会被保存到session域中
	 * 
	 */
	
	/*
	 * 视图解析：
	 * 		forward:/xx 转发到项目下的xx，xx不会被viewReslover拼串，或者转发到另一个请求
	 * 		redirect:/xx spring会为我们自动拼上项目名
	 * 
	 * 无论如何，mvc总是返回modelAndView
	 * 
	 */
	
	/*
	 * 视图解析器：
	 * 		URL视资源图：InternalResourceView、JstlView(具有国际化功能，他是InternalResourceView的子类)
	 * 		文档视图：AbstractExcelView、AbstractPdfView
	 * 		报表视图：ConfigurableJsperReportsView、JasperReportsCsvView、JasperReportsMultiFormatView、JasperReportsHtmlView、JasperReportsPdfView、JasperReportXlsView
	 * 		Json视图：MappingJacksonJsonView
	 * 
	 *  自定义视图解析器：
	 *  	实现ViewResolver和Ordered接口
	 *  自定义视图：
	 *  	实现View接口
	 */
	
	
	/*
	 * 方法可以接受的返回值：
	 * 		string，Model，ModelAndView，View，ResponseEntity
	 */
	
}
