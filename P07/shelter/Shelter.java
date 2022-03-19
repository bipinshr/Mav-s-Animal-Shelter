package shelter;

import java.util.ArrayList;
public class Shelter{
	private String name;
	private ArrayList<Animal> animals;
	
	public Shelter(String name){
		this.name = name;
		this.animals = new ArrayList<>();
	}
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