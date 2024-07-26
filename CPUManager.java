package com.generation.pwd.main;

import com.generation.library.Console;
import com.generation.library.DatabaseSQLite;
import com.generation.library.List;
import com.generation.pwd.model.CPU;
import com.generation.pwd.repository.CPURepository;

public class CPUManager 
{

	static DatabaseSQLite db = new DatabaseSQLite("pc.db");
	static CPURepository cpuRepo = new CPURepository(db);
	
	public static void main(String[] args) 
	{
		Console.print("Benvenuto a Contact Manager");
		String cmd;
		do
		{
			Console.print("Inserire comando");
			cmd = Console.readString();
			switch(cmd)
			{
				case "insert":
					insertCPU();
				break;
				case "update":
					updateBenchmarkAndPriceCPU();
				break;
				case "delete":
					deleteCPU();
				break;
				case "showall":
					printAll();
				break;
				case "searchByMaxPrice":
					searchByMaxPrice();
				break;
				case "searchByMinBenchmark":
					searchByMinBenchmark();
				break;
				case "fullSearch":
					searchByMinBenchmarkAndMaxPrice();
				break;
				default:
					Console.print("Comando non riconosciuto");
			}
		}while(!cmd.equals("quit"));
		Console.print("Bye bye");
		
	}

	private static void insertCPU() 
	{
		CPU cpu = new CPU();
		Console.print("Inserire modello");
		cpu.model=Console.readString();
		Console.print("Inserire modello");
		cpu.benchmark=Console.readInt();
		Console.print("Inserire modello");
		cpu.price=Console.readInt();
		if(cpu.isValid())
		{
			cpuRepo.insert(cpu);
			Console.print("Inserito correttamente");
		}
		else
			Console.print("Dati inseriti in modo errato");
	}

	private static void updateBenchmarkAndPriceCPU() 
	{
		List<CPU> all=cpuRepo.findAll();
		Console.print("Lista CPU");
		for(CPU cpu:all)
			Console.print(cpu);
		
		Console.print("Inserire id account da aggiornare");
		int id = Console.readInt();
		CPU cpu = cpuRepo.findById(id);
		if(cpu==null)
			Console.print("Non ho trovato nulla");
		else
		{
			Console.print(cpu);
			Console.print("Inserire benchmark da modificare");
			cpu.benchmark=Console.readInt();
			Console.print("Inserire esperienza da modificare");
			cpu.price=Console.readInt();
			if(cpu.isValid())
			{
				cpuRepo.update(cpu);
				Console.print("Aggiornato");
			}
			else
				Console.print("Dati non validi, non aggiorno");
		}
	}

	private static void deleteCPU() 
	{
		Console.print("Inserire id account da cancellare");
		int id = Console.readInt();
		
		cpuRepo.delete(id);
		Console.print("Fatto");
	}

	private static void printAll() 
	{
		printCPU(cpuRepo.findAll());
	}

	private static void searchByMaxPrice() 
	{
		Console.print("Inserire prezzo");
		String price = Console.readString();
		String criteria = "price>'[price]'".replace("[price]", price);
		List<CPU> matches = cpuRepo.findByCriteria(criteria);
		
		if(matches.size()==0)
			Console.print("Nessun risultato trovato");
		else
			printCPU(matches);
	}

	private static void searchByMinBenchmark() 
	{
		Console.print("Inserire benchmark");
		String price = Console.readString();
		String criteria = "benchmark<'[b]'".replace("[b]", price);
		List<CPU> matches = cpuRepo.findByCriteria(criteria);
		
		if(matches.size()==0)
			Console.print("Nessun risultato trovato");
		else
			printCPU(matches);
	}
	private static void printCPU(List<CPU> cpuToPrint)
	{
		for(CPU cpu:cpuToPrint)
			Console.print(cpu);
	}

	private static void searchByMinBenchmarkAndMaxPrice() 
	{
		Console.print("Inserire prezzo");
		String benchmark = Console.readString();
		String criteria = "benchmark>'[b]' and benchmark<'[b]'".replace("[benchmark]", benchmark).replace("[benchmark]", benchmark);
		List<CPU> matches = cpuRepo.findByCriteria(criteria);
		
		if(matches.size()==0)
			Console.print("Nessun risultato trovato");
		else
			printCPU(matches);
	}

}
