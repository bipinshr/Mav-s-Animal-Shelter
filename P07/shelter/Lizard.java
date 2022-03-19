package shelter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
public class Lizard extends Animal{
	private LizardBreed breed;
	
	public Lizard(LizardBreed breed,String name,Gender gender,int age){
		super(name,gender,age);
		this.breed = breed;
	}
	/*
	public Animal(BufferReader br){
		
	}
	
	public void save(BufferedWriter bw){
		
	}
	*/
	@Override 
	public String family(){
		return "lizard";
	}
	
	@Override 
	public String breed(){
		return breed.name();
	}
	
	@Override 
	public String toString(){
		return super.toString() +" "+ breed.name() + " " +"Lizard"+ ")"  ; 
	} 
}