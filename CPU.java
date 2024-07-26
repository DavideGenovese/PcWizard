package com.generation.pwd.model;

public class CPU extends com.generation.library.Record
{
	public String model;
	public int benchmark;
	public double price;
	
	
	public CPU() {}
	
	
	
	public CPU(String id, String model, String benchmark, String price) 
	{
		this.id = Integer.parseInt(id);
		this.model = model;
		this.benchmark = Integer.parseInt(benchmark);
		this.price = Double.parseDouble(price);
	}



	@Override
	public boolean isValid() 
	{
		return has(model) && benchmark>0 && price>0;
	}
	
	@Override
	public String toString()
	{
		return id+" "+model+" "+benchmark+" for "+price+" euro ("+getBTP()+")";
	}

	private double getBTP() 
	{
		return benchmark / price;
	}

}
