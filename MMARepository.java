package com.generation.pwd.repository;
import com.generation.library.Database;
import com.generation.library.List;
import com.generation.library.Row;
import com.generation.pwd.model.MMA;
public class MMARepository 
{
	private Database database;
	
	public MMARepository(Database database)
	{
		this.database=database;
	}
	
	public void insert(MMA mma)
	{
		database.executeDml
		(
			(
				"insert into MMA (size,type,price,speed)" +
				"values('[1]','[2]','[3]','[4]')"
			)
			.replace("[1]", mma.size)
			.replace("[2]",mma.type)
			.replace("[3]", mma.price+"")
			.replace("[4]", mma.speed+"")
		);
	}
	public void update(MMA mma)
	{
		database.executeDml
		(
			"update MMA set size='[1]', type='[2]',price='[3]',speed='[4]' where id=[5]" 
			.replace("[1]", mma.size)
			.replace("[2]",mma.type)
			.replace("[3]", mma.price+"")
			.replace("[4]", mma.speed+"")
			.replace("[5]",mma.id+"")
		);
	}
	
	public void delete(int id)
	{
		database.executeDml("delete from MMA where id="+id);
	}

	public void delete(MMA mma)
	{
		database.executeDml("delete from MMA where id="+mma.id);
	}
	
	public MMA findById(int id)
	{
		List<Row> rows = database.executeQuery("select * from MMA where id="+id);
		
		if(rows.size()!=1)
			return null;
		
		return rowToMMA(rows.get(0));
		
	}

	public List<MMA> findByCriteria(String cond)
	{
		List<Row> rows = database.executeQuery("select * from MMA where "+cond);
		List<MMA> res = new List<MMA>();
		for(Row row:rows)
			res.add(rowToMMA(row));
		
		return res;		
	}
	
	public List<MMA> findAll()
	{
		return findByCriteria("id>0");
	}
	
	

	

	private MMA rowToMMA(Row row)
	{
		return new MMA
				(
					row.getColumnValue("id"), 
					row.getColumnValue("size"),
					row.getColumnValue("type"),
					row.getColumnValue("price"),
					row.getColumnValue("speed")
				);
	}
}
