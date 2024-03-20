package com.airline.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import com.airline.model.Customer;
import com.airline.model.Flight;

import com.airline.service.CustomerService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class ClientController 
{

	
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/")
	public String main()
	{
		return "index";
	}
	
	@GetMapping("login")
	public ModelAndView login()
	{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("login");
		return mv;
	}
	
	
	@PostMapping("insertcustomer")
	public ModelAndView insertcustomer(HttpServletRequest request)
	{
		ModelAndView mv = new ModelAndView();
		String msg = null;
		
		try
		{
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			String contact = request.getParameter("contact");
			
			Customer c = new Customer();
			c.setName(name);
			c.setEmail(email);
			c.setPassword(password);
			c.setContact(contact);
			
		    msg = customerService.addcustomer(c);
		    
		    mv.setViewName("displaymsg");
		    mv.addObject("message", msg);
		}
		catch(Exception e)
		{
			mv.setViewName("diaplayerror");
			msg = e.getMessage();
			mv.addObject("message", msg);
		}
		return mv;
	}
	

	
	@PostMapping("checkcustomerlogin")
	public ModelAndView checkcustomerlogin(HttpServletRequest request)
	{
		ModelAndView mv = new ModelAndView();
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		Customer c = customerService.checkcustomerlogin(email, password);
		
		if(c!=null)
		{
			HttpSession session = request.getSession();
			session.setAttribute("cid", c.getId());
			session.setAttribute("cname", c.getName());
			
			
			mv.setViewName("customerhome");
		}
		else {
			mv.setViewName("login");
			mv.addObject("Message", "Login Failed");
		}
		return mv;
	}
	
	@GetMapping("customerhome")
	public ModelAndView customerhome(HttpServletRequest request)
	{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("customerhome");
		
		HttpSession session = request.getSession();
		int cid = (int)session.getAttribute("cid");
		String cname = (String)session.getAttribute("cname");
		
		mv.addObject("cname", cname);
		mv.addObject("cid", cid);
		
		return mv;
	}
	

	
	@GetMapping("viewallflights")
	public ModelAndView viewallflights()
	{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("viewallflights");
		
		List<Flight> flightlist = customerService.viewallflights();
		mv.addObject("flightlist", flightlist);
		return mv;
	}
	
	
}
