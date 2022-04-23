package shelter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
public class Lizard extends Animal{
	private LizardBreed breed;
	
	public Lizard()
	{
		this(LizardBreed.valueOf("Tuatara"), "Default", Gender.female, 0);
	}
	
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
	public void create(Object breed,String name,Gender gender,int age)
	{
		this.name=name;
		this.gender=gender;
		this.age=age;
		
		this.breed=(LizardBreed)breed;
	}
	
	@Override 
	public String family(){
		return "Lizard";
	}
	
	@Override 
	public String breed(){
		return breed.name();
	}
	
	@Override 
	public String toString(){
		return super.toString() +" "+ breed.name() + " " +"Lizard"+ ")"  ; 
	} 
	
	
	@Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null) return false;
        if(this.getClass() != o.getClass()) return false;
        Lizard a = (Lizard) o;
        return breed.equals(a.breed);
    }
	
	@Override
    public int hashCode() {
        int hash = 7;
        hash = 31*hash + (breed == null ? 0 : breed.hashCode());
        return hash;
    }
}