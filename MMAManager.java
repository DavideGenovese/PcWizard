package com.generation.pwd.main;

import com.generation.library.Console;
import com.generation.library.DatabaseSQLite;
import com.generation.library.List;
import com.generation.pwd.model.MMA;
import com.generation.pwd.repository.MMARepository;

public class MMAManager 
{
	static DatabaseSQLite db = new DatabaseSQLite("pc.db");
	static MMARepository mmaRepo = new MMARepository(db);
	public static void main(String[] args) 
	{
		Console.print("Benvenuto a Ram Manager");
		String cmd;
		do
		{
			Console.print("Inserire comando");
			cmd = Console.readString();
			switch(cmd)
			{
				case "insert":
					insertMMA();
				break;
				case "update":
					updatePriceMMA();
				break;
				case "delete":
					deleteMMA();
				break;
				case "showall":
					printAll();
				break;
				case "searchByMaxPrice":
					searchByMaxPrice();
				break;
				default:
					Console.print("Comando non riconosciuto");
			}
		}while(!cmd.equals("quit"));
		Console.print("Bye bye");
	}
	private static void insertMMA() 
	{
		MMA mma = new MMA();
		Console.print("Inserire misura");
		mma.size=Console.readString();
		Console.print("Inserire tipo");
		mma.type=Console.readString();
		Console.print("Inserire prezzo");
		mma.price=Console.readInt();
		Console.print("Inserire velocità");
		mma.speed=Console.readInt();
		if(mma.isValid())
		{
			mmaRepo.insert(mma);
			Console.print("Inserito correttamente");
		}
		else
			Console.print("Dati inseriti in modo errato");
	}

	private static void updatePriceMMA() 
	{
		List<MMA> all=mmaRepo.findAll();
		Console.print("Lista MMA");
		for(MMA mma:all)
			Console.print(mma);
		
		Console.print("Inserire id account da aggiornare");
		int id = Console.readInt();
		MMA mma = mmaRepo.findById(id);
		if(mma==null)
			Console.print("Non ho trovato nulla");
		else
		{
			Console.print(mma);
			Console.print("Inserire prezzo da modificare");
			mma.price=Console.readInt();
			if(mma.isValid())
			{
				mmaRepo.update(mma);
				Console.print("Aggiornato");
			}
			else
				Console.print("Dati non validi, non aggiorno");
		}
	}

	private static void deleteMMA() 
	{
		Console.print("Inserire id account da cancellare");
		int id = Console.readInt();
		
		mmaRepo.delete(id);
		Console.print("Fatto");
	}

	private static void printAll() 
	{
		printMMA(mmaRepo.findAll());
	}

	private static void printMMA(List<MMA> printToMma) 
	{
		for(MMA mma:printToMma)
			Console.print(mma);
	}
	private static void searchByMaxPrice() 
	{
		Console.print("Inserire prezzo");
		String price = Console.readString();
		String criteria = "price>'[price]'".replace("[price]", price);
		List<MMA> matches = mmaRepo.findByCriteria(criteria);
		
		if(matches.size()==0)
			Console.print("Nessun risultato trovato");
		else
			printMMA(matches);
	}

}
