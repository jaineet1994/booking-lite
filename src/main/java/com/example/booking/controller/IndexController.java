package com.example.booking.controller;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.booking.config.CityList;
import com.example.booking.model.ServiceRequest;
import com.example.booking.services.AddService;
import com.example.booking.services.impl.AddServiceImpl;

@RestController
public class IndexController {
	
	@Autowired
	AddService service;
	
	@Resource
	CityList city;
	
	@RequestMapping(value="/test",method=RequestMethod.POST)
	public String addService(@RequestBody ServiceRequest body) {
		
		return service.addService(body, city.getConfigList());
	}

}
