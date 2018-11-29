package com.bank.controller;

import java.io.IOException;
import java.rmi.ServerException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bank.dao.AdminDao;
import com.bank.model.AdminModel;

@Controller
public class AdminController {
	@Autowired
	AdminDao adao;
	
	@RequestMapping("/index")
	public ModelAndView saveData(HttpServletRequest request,HttpServletResponse response,ModelAndView model, @ModelAttribute AdminModel am) throws ServerException,IOException
	{
		int i = adao.saveData(am);
		if(i>0) {
		model.setViewName("Success");
		}
		else
		{
			model.setViewName("index");
		}
		return model;
	}
	
	@RequestMapping("/display")
	public ModelAndView DisplayAll(HttpServletRequest request, HttpServletResponse response,ModelAndView model, @ModelAttribute AdminModel am) throws ServerException,IOException, ServletException{
		List<AdminModel> list = new ArrayList<AdminModel>();
		list = adao.getAllInfo(am);
		request.setAttribute("InfoList",list);
		
		HttpSession ses = request.getSession();
		ses.setAttribute("InfoList", list);	
		System.out.println(list);
		  return new ModelAndView("display","InfoList",list);
	}
	
	/*@RequestMapping("/save")
	public ModelAndView saveData1(HttpServletRequest request,HttpServletResponse response, @ModelAttribute AdminModel am) throws ServerException,IOException
	{
		return new  ModelAndView("save");
	}*/
	
	@RequestMapping(value="/delete/{id}",method = RequestMethod.GET)
	public ModelAndView deleteData(@PathVariable String id)
	{
	int i = adao.deleteData(id);
		return new ModelAndView("redirect:/display");
	}
    
}
