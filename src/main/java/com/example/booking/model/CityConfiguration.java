package com.example.booking.model;

public class CityConfiguration {
	private String source;
	private String destination;
	private Integer days;
	private Integer cost;
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	
	public Integer getDays() {
		return days;
	}
	public void setDays(Integer days) {
		this.days = days;
	}

	
	public Integer getCost() {
		return cost;
	}
	public void setCost(Integer cost) {
		this.cost = cost;
	}
	
	

}
