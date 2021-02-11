package com.example.booking.services;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.booking.model.CityConfiguration;
import com.example.booking.model.ServiceRequest;


public interface AddService {

	public String addService(ServiceRequest request,List<CityConfiguration> list) ;
}
