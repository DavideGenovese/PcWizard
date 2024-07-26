package com.generation.pwd.main;

import com.generation.library.Console;
import com.generation.library.DatabaseSQLite;
import com.generation.library.List;
import com.generation.pwd.model.RAM;
import com.generation.pwd.repository.RAMRepository;

public class RAMManager 
{
	static DatabaseSQLite db = new DatabaseSQLite("pc.db");
	static RAMRepository ramRepo = new RAMRepository(db);
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
					insertRAM();
				break;
				case "update":
					updatePriceRAM();
				break;
				case "delete":
					deleteRAM();
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
	private static void insertRAM() 
	{
		RAM ram = new RAM();
		Console.print("Inserire misura");
		ram.size=Console.readString();
		Console.print("Inserire tipo");
		ram.type=Console.readString();
		Console.print("Inserire prezzo");
		ram.price=Console.readInt();
		if(ram.isValid())
		{
			ramRepo.insert(ram);
			Console.print("Inserito correttamente");
		}
		else
			Console.print("Dati inseriti in modo errato");
	}

	private static void updatePriceRAM() 
	{
		List<RAM> all=ramRepo.findAll();
		Console.print("Lista CPU");
		for(RAM ram:all)
			Console.print(ram);
		
		Console.print("Inserire id account da aggiornare");
		int id = Console.readInt();
		RAM ram = ramRepo.findByID(id);
		if(ram==null)
			Console.print("Non ho trovato nulla");
		else
		{
			Console.print(ram);
			Console.print("Inserire prezzo da modificare");
			ram.price=Console.readInt();
			if(ram.isValid())
			{
				ramRepo.update(ram);
				Console.print("Aggiornato");
			}
			else
				Console.print("Dati non validi, non aggiorno");
		}
	}

	private static void deleteRAM() 
	{
		Console.print("Inserire id account da cancellare");
		int id = Console.readInt();
		
		ramRepo.delete(id);
		Console.print("Fatto");
	}

	private static void printAll() 
	{
		printRAM(ramRepo.findAll());
	}

	private static void printRAM(List<RAM> printToCpu) 
	{
		for(RAM ram:printToCpu)
			Console.print(ram);
	}
	private static void searchByMaxPrice() 
	{
		Console.print("Inserire prezzo");
		String price = Console.readString();
		String criteria = "price>'[price]'".replace("[price]", price);
		List<RAM> matches = ramRepo.findByCriteria(criteria);
		
		if(matches.size()==0)
			Console.print("Nessun risultato trovato");
		else
			printRAM(matches);
	}


}
