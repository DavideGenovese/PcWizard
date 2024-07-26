package com.generation.pwd.model;
import com.generation.library.Record;
public class MMA extends Record
{
	public int speed;
	public String type,size;
	public double price;
	
	@Override
	public boolean isValid()
	{
		return has(size) && has(type) && speed>0 && price>0;
	}
	public MMA() {}
	public MMA(String id,String size,String type,String price,String speed)
	{
		this.id=Integer.parseInt(id);
		this.size=size;
		this.type=type;
		this.price=Double.parseDouble(price);
		this.speed=Integer.parseInt(speed);
	}
	@Override
	public String toString()
	{
		return id+" "+size+" "+ type+" " + price+" " + speed;
	}
}
