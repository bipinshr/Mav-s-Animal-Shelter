package shelter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
public class GuineaPig extends Animal{
	private GuineaPigBreed breed;
	
	public GuineaPig()
	{
		this(GuineaPigBreed.valueOf("American"), "Default", Gender.female, 0);
	}
	
	public GuineaPig(GuineaPigBreed breed,String name,Gender gender,int age){
		super(name,gender,age);
		this.breed = breed;
	}
	
	
	public GuineaPig(BufferedReader br) throws IOException{
		super(br);
		breed = GuineaPigBreed.valueOf(br.readLine()); 
	}
	
	public void save(BufferedWriter bw) throws IOException{
		bw.write("" + family() + '\n');
		super.save(bw);
		bw.write("" + breed + '\n');
	}
	
	@Override
	public void create(Object breed,String name,Gender gender,int age)
	{
		//super(name,gender,age);
		this.name=name;
		this.gender=gender;
		this.age=age;
		this.breed=(GuineaPigBreed)breed;
	}
	
	@Override 
	public String family(){
		return "GuineaPig";
	}
	
	@Override 
	public String breed(){
		return breed.name();
	}
	
	@Override 
	public String toString(){
		return super.toString()+" "+ breed.name()+ " " +"GuineaPig"+ ")" ; 
	} 
}