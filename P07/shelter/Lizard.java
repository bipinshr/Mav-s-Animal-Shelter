package shelter;
public class Lizard extends Animal{
	private LizardBreed breed;
	
	public Lizard(LizardBreed breed,String name,Gender gender,int age){
		super(name,gender,age);
		this.breed = breed;
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