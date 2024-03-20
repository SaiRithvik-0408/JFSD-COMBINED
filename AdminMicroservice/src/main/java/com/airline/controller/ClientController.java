package com.airline.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.airline.model.Admin;
import com.airline.model.Customer;
import com.airline.model.Flight;
import com.airline.service.AdminService;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("admin")
public class ClientController 
{
	@Autowired
	private AdminService adminService;
	
//	@GetMapping("")
//	@ResponseBody
//	public String admin()
//	{
//		return "Admin MicroSerices";
//	}
	
	@GetMapping("admin")
	public ModelAndView admin()
	{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("admin");
		return mv;
	}
	
	@GetMapping("count-flights")
	@ResponseBody
	  public Map<String, Integer> countMaleCustomers() {
	      Map<String, Integer> result = new HashMap<>();
	      int fcount = (int)adminService.countFligths();
	      int seats=adminService.sumSeats();
	      result.put("fcount", fcount);
	      result.put("seats", seats);
	      return result;
	  }
	
	
	@PostMapping("checkadminlogin")
	public ModelAndView checkadminlogin(HttpServletRequest request)
	{
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		Admin a = adminService.checkadminlogin(username, password);
		ModelAndView mv = new ModelAndView();
		if(a!=null) 
		{
			mv.setViewName("adminhome");
		}
		else {
			mv.setViewName("admin");
			mv.addObject("message", "LoginFailed");
		}
		return mv;
		
	}
	

	

	
	@PostMapping("addflights")
	public ModelAndView addights(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		String msg = null;
		try
		{
			String source = request.getParameter("source");
			String destination = request.getParameter("destination");
			String date = request.getParameter("date");
		    String sea = request.getParameter("seats");
		    int seat = Integer.parseInt(sea);
			
			Flight f = new Flight();
			
			f.setSource(source);
			f.setDestination(destination);
			f.setDate(date);
			f.setSeats(seat);
			
			
			msg = adminService.addflights(f);
			mv.setViewName("addflights");
			mv.addObject("message",msg);
			
			
		}
		catch(Exception e)
		{
			mv.setViewName("adminhome");
			msg = e.getMessage();
			mv.addObject("message",msg);
			
		}
		return mv;
		
	}
	@GetMapping("about")
	public ModelAndView about()
	{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("about");
		return mv;
	}
	
	@GetMapping("addflightss")
	public ModelAndView addflightspage()
	{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("addflights");
		return mv;
	}
	@GetMapping("adminhome")
	public ModelAndView adminhome()
	{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("adminhome");
		return mv;
	}
	@GetMapping("contact")
	public ModelAndView contact()
	{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("contact");
		return mv;
	}

	

	
}
