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
	
	public Lizard(BufferedReader br) throws IOException{
		super(br);
		breed = LizardBreed.valueOf(br.readLine()); 
	}
	
	
	public void save(BufferedWriter bw) throws IOException{
		bw.write("" + family() + '\n');
		super.save(bw);
		bw.write("" + breed + '\n');
	}
	
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