package com.generation.pwd.repository;
import com.generation.library.Database;
import com.generation.library.List;
import com.generation.library.Row;
import com.generation.pwd.model.RAM;
public class RAMRepository 
{
	private Database database;
	public RAMRepository(Database database)
	{
		this.database=database;
	}
	public RAMRepository() {}
	
	public void insert(RAM ram)
	{
		database.executeDml
		(
			(
				"insert into RAM (size,type,price)" +
				"values('[1]','[2]','[3]')"
			)
			.replace("[1]", ram.size)
			.replace("[2]",ram.type)
			.replace("[3]", ram.price+"")
		);
	}
	public void update(RAM ram)
	{
		String updateDML="update RAM set size='[1]',type='[1]',price='[1]'";
		updateDML=updateDML.replace("[1]", ram.size);
		updateDML=updateDML.replace("[2]", ram.type);
		updateDML=updateDML.replace("[3]", ram.price+"");
		database.executeDml(updateDML);
	}
	public void delete(int id)
	{
		database.executeDml("delete from ram where id="+id);
	}
	public void delete(RAM ram)
	{
		database.executeDml("delete from ram where id"+ram.id);
	}
	public RAM findByID(int id)
	{
		List<Row> rows= database.executeQuery("select * from ram where id="+id);
		if(rows.size()!=1)
			return null;
		return rowToRAM(rows.get(0));
	}
	public List<RAM> findByCriteria(String cond)
	{
		List<Row> rows = database.executeQuery("select * from RAM where "+cond);
		List<RAM> res = new List<RAM>();
		for(Row row:rows)
			res.add(rowToRAM(row));
		
		return res;		
	}
	public List<RAM> findAll()
	{
		return findByCriteria("id>0");
	}
	
	

	

	private RAM rowToRAM(Row row)
	{
		return new RAM
				(
					row.getColumnValue("id"), 
					row.getColumnValue("size"),
					row.getColumnValue("type"),
					row.getColumnValue("price")
				);
	}
}
