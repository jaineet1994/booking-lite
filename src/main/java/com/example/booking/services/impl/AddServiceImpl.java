package com.example.booking.services.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Predicate;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.booking.model.CityConfiguration;
import com.example.booking.model.ServiceRequest;
import com.example.booking.services.AddService;

@Component("service")
public class AddServiceImpl implements AddService{
	
	private TreeMap<Date,Integer> delhiMap=new TreeMap<Date,Integer>();
	private TreeMap<Date,Integer> mumbaiMap=new TreeMap<Date,Integer>();
	private TreeMap<Date,Integer> chennaiMap=new TreeMap<Date,Integer>();
	private TreeMap<Date,Integer> kolkataMap=new TreeMap<Date,Integer>();
	Random rn=new Random();
	
	
	
	public String addService(ServiceRequest request,List<CityConfiguration> list) {
		
		String source=request.getSource();
		String destination=request.getDestination();
		Date date=request.getDate();
		String response="";
		if(source.equals("Delhi")) {
			response=getJson(delhiMap,date,destination,source,list);
				
			}
		else if(source.equals("Mumbai")) {
			response=getJson(mumbaiMap,date,destination,source,list);
				
			}
		else if(source.equals("Chennai")) {
			response=getJson(chennaiMap,date,destination,source,list);
				
			}
		else if(source.equals("Kolkata")) {
			response=getJson(kolkataMap,date,destination,source,list);
				
			}
		return response;
		}
	
	public String getJson(TreeMap<Date,Integer> map,Date date,String destination,String source,List<CityConfiguration> list) {
		
		Integer previousValue;
		Integer nextValue;
		try {
			previousValue = map.get(map.headMap(date,true).lastKey());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			previousValue=null;
		}
		try {
			nextValue = map.ceilingEntry(date).getValue();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			nextValue=null;
		}
		if(previousValue!=null&&previousValue==0)
			return "vehicle not available" ;
	    else if(map.isEmpty())
			map.put(date, 9999);
		else if(previousValue!=null||nextValue!=null) {
			Integer value=0;
			for (Map.Entry<Date, Integer> pair : map.entrySet()) {
				value=pair.getValue();
			map.put(pair.getKey(),pair.getValue()-1);
			}
			map.put(date, value-1);
			}
		/*
		 * else if(map.get(map.headMap(date,true).lastKey())==null) map.put(date,
		 * map.get(map.ceilingEntry(date))-1);
		 */
		if(destination.equals("Mumbai"))
		 return cost(mumbaiMap,date,source,destination,list);
		else if(destination.equals("Delhi"))
			 return cost(delhiMap,date,source,destination,list);
		else if(destination.equals("Kolkata"))
			 return cost(kolkataMap,date,source,destination,list);
		else if(destination.equals("Chennai"))
			 return cost(chennaiMap,date,source,destination,list);
		else
			return "vehicle not available" ;
		
		
	}
	
	public String cost(TreeMap<Date,Integer> map,Date date,String destination,String source,List<CityConfiguration> list) {
		
		Predicate<CityConfiguration> conf=e->e.getSource().equals(source);
		Predicate<CityConfiguration> conf2=e->e.getDestination().equals(destination);
		
		CityConfiguration result = list.stream()
	                .filter(conf.and(conf2)).findAny().orElse(null);
		
		Date newDate=new Date(date.getTime()+result.getDays()*24*60*60*1000);
		Integer previuosValue;
		try {
			 previuosValue=map.get(map.headMap(newDate,true).lastKey());
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			previuosValue=null;
		}
		if(map.isEmpty())
			map.put(newDate,10001);
		else {
			
			for (Map.Entry<Date, Integer> pair : map.entrySet()) {
				
			if(pair.getKey().compareTo(newDate)>=0)	
			map.put(pair.getKey(),pair.getValue()+1);
			}
		 if(previuosValue!=null)
		map.put(newDate, previuosValue+1);
		 else
			 map.put(newDate, 10001); 
		}
		
			
		Integer vehicleNo=rn.nextInt((100000-0)-1);
		return "Vehicle no :"+vehicleNo+", Cost:"+result.getCost();
		
	}
		
	}


