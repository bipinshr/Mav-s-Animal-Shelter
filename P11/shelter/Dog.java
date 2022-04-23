package shelter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
public class Dog extends Animal{
	private DogBreed breed;
	
	public Dog()
	{
		this(DogBreed.valueOf("Beagle"), "Default", Gender.female, 0);
	}
	
	public Dog(DogBreed breed,String name,Gender gender,int age){
		super(name,gender,age);
		this.breed = breed;
	}
	
	
	public Dog(BufferedReader br) throws IOException{
		super(br);
		breed = DogBreed.valueOf(br.readLine()); 
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
		this.breed=(DogBreed)breed;
	}
	
	@Override 
	public String family(){
		return "Dog";
	}
	
	@Override 
	public String breed(){
		return breed.name();
	}
	
	@Override 
	public String toString(){
		return super.toString()+" "+ breed.name()+ " " +"Dog"+ ")" ; 
	} 
	
	@Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null) return false;
        if(this.getClass() != o.getClass()) return false;
        Dog a = (Dog) o;
        return breed.equals(a.breed);
    }
	
	@Override
    public int hashCode() {
        int hash = 7;
        hash = 31*hash + (breed == null ? 0 : breed.hashCode());
        return hash;
    }
}