package com.generation.pwd.model;
import com.generation.library.Record;
public class RAM extends Record
{
	public String size,type;
	public double price;
	@Override
	public boolean isValid()
	{
		return has(type) && has(size) && price>0;
	}
	public RAM() {}
	public RAM(String id,String type,String size,String price)
	{
		this.id=Integer.parseInt(id);
		this.type=type;
		this.size=size;
		this.price=Double.parseDouble(price);
	}
	@Override
	public String toString()
	{
		return id+" "+type+" "+ size+" "+ price;
	}
}
