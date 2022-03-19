package shelter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
public class Dog extends Animal{
	private DogBreed breed;
	
	public Dog(DogBreed breed,String name,Gender gender,int age){
		super(name,gender,age);
		this.breed = breed;
	}
	
	/*
	public Dog(BufferReader br){
		
	}
	
	public void save(BufferedWriter bw){
		
	}
	*/
	
	@Override 
	public String family(){
		return "dog";
	}
	
	@Override 
	public String breed(){
		return breed.name();
	}
	
	@Override 
	public String toString(){
		return super.toString()+" "+ breed.name()+ " " +"Dog"+ ")" ; 
	} 
}