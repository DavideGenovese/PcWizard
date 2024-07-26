package com.generation.pwd.main;

import com.generation.library.Console;
import com.generation.library.DatabaseSQLite;
import com.generation.library.List;
import com.generation.library.Set;
import com.generation.pwd.model.CPU;
import com.generation.pwd.model.MMA;
import com.generation.pwd.model.PC;
import com.generation.pwd.model.RAM;
import com.generation.pwd.repository.CPURepository;
import com.generation.pwd.repository.MMARepository;
import com.generation.pwd.repository.PCRepository;
import com.generation.pwd.repository.RAMRepository;

public class PCAssembler 
{

	static DatabaseSQLite db = new DatabaseSQLite("pc.db");
	static PCRepository pcRepo = new PCRepository(db);
	static CPURepository cpuRepo = new CPURepository(db);
	static MMARepository mmaRepo = new MMARepository(db);
	static RAMRepository ramRepo = new RAMRepository(db);
	static PC pc = new PC();
	
	
	public static void main(String[] args) 
	{
		
		Console.print("Inserire nome");
		pc.name = Console.readString();
		Console.print("Inserire prezzo");
		pc.price = Console.readDouble();
		pickCPU();
		pickMMA();
		pickRAM();
				
		if(pc.isValid())
		{
			pcRepo.insert(pc);
			Console.print("Salvato");
		}
		else
			Console.print("Pc non valido");
		
		
		
		
		
	}


	private static void pickRAM() 
	{
		Set<Integer> ramIds = new Set<Integer>();
		List<RAM> allRAM = ramRepo.findAll();
		
		for(RAM ram:allRAM)
		{
			Console.print(ram);
			ramIds.add(ram.id);
		}
		
		do
		{
			Console.print("Inserire un id fra quelli messi prima");
			pc.ramid = Console.readInt();
			if(!ramIds.contains(pc.ramid))
				Console.print("Id ram non trovato");
		}while(!ramIds.contains(pc.ramid));
	}


	private static void pickMMA() 
	{
		Set<Integer> mmaIds = new Set<Integer>();
		List<MMA> allMMA = mmaRepo.findAll();
		
		for(MMA mma:allMMA)
		{
			Console.print(mma);
			mmaIds.add(mma.id);
		}
		
		do
		{
			Console.print("Inserire un id fra quelli messi prima");
			pc.mmaid = Console.readInt();
			if(!mmaIds.contains(pc.mmaid))
				Console.print("Id cpu non trovato");
		}while(!mmaIds.contains(pc.mmaid));
	}


	private static void pickCPU() 
	{
		// ora in questo set, in questo INSIEME, ci sono tutti gli id delle cpu
		Set<Integer> cpuIds = new Set<Integer>();
		List<CPU> allCPU = cpuRepo.findAll();
		
		for(CPU cpu:allCPU)
		{
			Console.print(cpu);
			cpuIds.add(cpu.id);
		}
		
		do
		{
			Console.print("Inserire un id fra quelli messi prima");
			pc.cpuid = Console.readInt();
			if(!cpuIds.contains(pc.cpuid))
				Console.print("Id cpu non trovato");
		}while(!cpuIds.contains(pc.cpuid));
	}

}
