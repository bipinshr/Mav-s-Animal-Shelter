package shelter;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
public class Shelter{
	private String name;
	private String filename;
	private ArrayList<Animal> animals;
	
	public Shelter(String name){
		this.name = name;
		this.filename ="untitled.nim";
		this.animals = new ArrayList<>();
	}
	/*
	public Shelter(BufferReader br){
		
	}
	
	public void save(BufferedWriter bw){
		
	}
	
	
	public String getFilename(){
		return filename;
	}
	
	public void setFilename(String filename)
	{
		filename ="untitled.nim";
	}
	*/
	
	public void addAnimals(Animal animal){
		animals.add(animal);
	}
	
	@Override
	public String toString(){
		String result = "";
		String seperator=" ";
		for (Animal a: animals) { 
                result += seperator + a;
				seperator= "\n";
        }
		return result;
	}
	
}