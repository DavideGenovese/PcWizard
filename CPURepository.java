package com.generation.pwd.repository;

import com.generation.library.Database;
import com.generation.library.List;
import com.generation.library.Row;
import com.generation.pwd.model.CPU;

public class CPURepository 
{
	private Database database;
	
	/**
	 * Non posso creare una repository senza database.
	 * @param database
	 */
	public CPURepository(Database database)
	{
		this.database = database;
	}
	
	
	public void insert(CPU cpu)
	{
		database.executeDml
		(
			(
				"insert into CPU (model,benchmark,price)" +
				"values('[1]','[2]','[3]')"
			)
			.replace("[1]", cpu.model)
			.replace("[2]",cpu.benchmark+"")
			.replace("[3]", cpu.price+"")
		);
	}
	
	public void update(CPU cpu)
	{
		database.executeDml
		(
			"update CPU set model='[1]', benchmark='[2]',price='[3]' where id=[4]" 
			.replace("[1]", cpu.model)
			.replace("[2]",cpu.benchmark+"")
			.replace("[3]", cpu.price+"")
			.replace("[4]",cpu.id+"")
		);
	}
	
	public void delete(int id)
	{
		database.executeDml("delete from CPU where id="+id);
	}

	public void delete(CPU cpu)
	{
		database.executeDml("delete from CPU where id="+cpu.id);
	}

	
	public CPU findById(int id)
	{
		List<Row> rows = database.executeQuery("select * from CPU where id="+id);
		
		if(rows.size()!=1)
			return null;
		
		return rowToCPU(rows.get(0));
		
	}

	public List<CPU> findByCriteria(String cond)
	{
		List<Row> rows = database.executeQuery("select * from CPU where "+cond);
		List<CPU> res = new List<CPU>();
		for(Row row:rows)
			res.add(rowToCPU(row));
		
		return res;		
	}
	
	public List<CPU> findAll()
	{
		return findByCriteria("id>0");
	}
	
	

	

	private CPU rowToCPU(Row row)
	{
		return new CPU
				(
					row.getColumnValue("id"), 
					row.getColumnValue("model"),
					row.getColumnValue("benchmark"),
					row.getColumnValue("price")
				);
	}
	
	
}
