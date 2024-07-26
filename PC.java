package com.generation.pwd.model;

public class PC extends com.generation.library.Record
{

	public String name;
	public double price;
	// uno e/o l'altro
	public int cpuid;
	public CPU cpu;
	public int mmaid;
	public MMA mma;
	public int ramid;
	public RAM ram;
	
		
	@Override
	public boolean isValid() 
	{
		return has(name) && price>0 && (cpu!=null || cpuid>0);
	}
	
	@Override
	public String toString()
	{
		return id+" "+name+" "+price+" euro \n CPU "+cpu + " MMA" + mma+" RAM" + ram ;
	}
	
	
}
