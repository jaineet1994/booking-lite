package com.example.booking.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.booking.model.CityConfiguration;

@Configuration
public class CityList {

	@Bean
	public List<CityConfiguration> getConfigList(){
		
		List<CityConfiguration> list=new ArrayList<CityConfiguration>();
		CityConfiguration obj1=new CityConfiguration();
		CityConfiguration obj2=new CityConfiguration();
		CityConfiguration obj3=new CityConfiguration();
		CityConfiguration obj4=new CityConfiguration();
		CityConfiguration obj5=new CityConfiguration();
		CityConfiguration obj6=new CityConfiguration();
		CityConfiguration obj7=new CityConfiguration();
		CityConfiguration obj8=new CityConfiguration();
		CityConfiguration obj9=new CityConfiguration();
		CityConfiguration obj10=new CityConfiguration();
		CityConfiguration obj11=new CityConfiguration();
		CityConfiguration obj12=new CityConfiguration();
		obj1.setDestination("Mumbai");
		obj1.setSource("Delhi");
		obj1.setDays(3);
		obj1.setCost(50);
		
		obj2.setDestination("Chennai");
		obj2.setSource("Delhi");
		obj2.setDays(4);
		obj2.setCost(60);
		
		obj3.setDestination("Kolkata");
		obj3.setSource("Delhi");
		obj3.setDays(3);
		obj3.setCost(70);
		
		obj4.setDestination("Mumbai");
		obj4.setSource("Kolkata");
		obj4.setDays(5);
		obj4.setCost(10);
		
		obj5.setDestination("Delhi");
		obj5.setSource("Kolkata");
		obj5.setDays(6);
		obj5.setCost(20);
		
		obj6.setDestination("Chennai");
		obj6.setSource("Kolkata");
		obj6.setDays(3);
		obj6.setCost(80);
		
		obj7.setDestination("Mumbai");
		obj7.setSource("Chennai");
		obj7.setDays(3);
		obj7.setCost(30);
		
		obj8.setDestination("Kolkata");
		obj8.setSource("Chennai");
		obj8.setDays(4);
		obj8.setCost(50);
		
		obj9.setDestination("Delhi");
		obj9.setSource("Chennai");
		obj9.setDays(2);
		obj9.setCost(40);
		
		obj10.setDestination("Delhi");
		obj10.setSource("Mumbai");
		obj10.setDays(1);
		obj10.setCost(50);
		
		obj11.setDestination("Chennai");
		obj11.setSource("Mumbai");
		obj11.setDays(6);
		obj11.setCost(90);
		
		obj12.setDestination("Kolkata");
		obj12.setSource("Mumbai");
		obj12.setDays(3);
		obj12.setCost(55);
		
		list.add(obj1);
		list.add(obj2);
		list.add(obj3);
		list.add(obj4);
		list.add(obj5);
		list.add(obj6);
		list.add(obj7);
		list.add(obj8);
		list.add(obj9);
		list.add(obj10);
		list.add(obj11);
		list.add(obj12);
		
		return list;
	}
}
