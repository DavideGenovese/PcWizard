package com.generation.pwd.repository;

import com.generation.library.Database;
import com.generation.pwd.model.PC;

public class PCRepository 
{
	private Database database;
	
	public PCRepository(Database database) 
	{
		this.database = database;
	}

	public void insert(PC pc)
	{
		int cpuid = pc.cpu != null ? pc.cpu.id : pc.cpuid;
		int mmaid = pc.mma != null ? pc.mma.id : pc.mmaid;	
		int ramid = pc.ram != null ? pc.ram.id : pc.ramid;	
		
		// sul database io posso salvare la chiave esterna
		// non l'intera CPU. Sul database io salvo il COLLEGAMENTO
		String insertSQL = 
			"insert into PC (name,price,cpuid,mmaid,ramid) values('[1]','[2]','[3]','[4]','[5]')"
			.replace("[1]", pc.name)
			.replace("[2]",pc.price+"")
			.replace("[3]", cpuid+"")
			.replace("[4]", mmaid+"")
			.replace("[5]", ramid+"");
		database.executeDml(insertSQL);
	}
	
	
	
}
