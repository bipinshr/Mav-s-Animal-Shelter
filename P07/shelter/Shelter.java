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
		//this.filename ="untitled.nim";
		this.animals = new ArrayList<>();
	}
	
	public Shelter(BufferedReader br) throws IOException{
		name = br.readLine();
		int animalcount =Integer.parseInt(br.readLine());
		animals = new ArrayList<>(animalcount);
		
		for(int i = 0; i < animalcount; i++)
		{
			String type = br.readLine();
			
			if(type.equals("dog"))
			{
				addAnimals(new Dog(br));
			}
			else
			{
				addAnimals(new Lizard(br));
			}
			
		}
		
	}
	
	public void save(BufferedWriter bw) throws IOException{
		bw.write("" + name + '\n');
        bw.write("" + animals.size()+'\n');        
        for (Animal a: animals)
		{
			a.save(bw);
		}
		
	}
	
	
	public String getFilename(){
		return filename;
	}
	
	public void setFilename(String filename)
	{
		this.filename =filename;
	}
	
	
	public void addAnimals(Animal animal){
		animals.add(animal);
	}
	public int numAnimals() {
        return animals.size();
    }
    public Animal getAnimal(int index) {
        return animals.get(index);
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