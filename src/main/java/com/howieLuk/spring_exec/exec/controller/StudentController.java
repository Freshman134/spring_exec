package com.howieLuk.spring_exec.exec.controller;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.howieLuk.spring_exec.exec.pojo.Student;
import com.howieLuk.spring_exec.exec.service.StudentService;

@Controller
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	StudentService service;
	
	/*
	 * mvc流程：
	 * 1. dispatcherServlet接受请求
	 * 2. 向RequestMapping请求handler
	 * 3. 请求HandlerAdapter执行handler，handler执行对应controller的方法，并返回ModelAndView
	 * 4. 根据mav请求视图解析器解析视图，返回View
	 * 5. 返回渲染好的视图
	 * 
	 * 数据绑定原理：（通过webDataBinder操作）
	 * 数据绑定牵扯到以下操作：
	 * 		1. 数据类型转换
	 * 		2. 数据格式化
	 * 		3. 数据校验
	 * 
	 * 数据校验：
	 * 		被校验对象后面需要紧跟（BindingResult bindingResult）
	 */
	@RequestMapping(method = RequestMethod.POST)
	public String addStu(/*@Valid*/ Student student
			//,BindingResult bindingResult  //校验结果
			) {
		System.out.println(student);
		service.save(student);
		return "student";
	}
	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public String getStu(@RequestParam(required = false)Map<String, Object> map) {
		return JSON.toJSONString(service.getByCondition(map));
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public String getStuById(@PathVariable("id")long id) {
		return JSON.toJSONString(service.get(id));
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public String putStu(@RequestParam(required = false)Map<String, Object> map) {
		System.out.println(map);
		service.update(map);
		return "student";
	}
	
	@RequestMapping(method = RequestMethod.DELETE)
	public String delStu(@RequestParam("id")String studentId) {
		System.out.println("studentId" + studentId);
		return "student";
	}
	
}
