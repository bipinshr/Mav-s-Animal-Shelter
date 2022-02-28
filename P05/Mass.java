import shelter.Shelter;
import shelter.Dog;
import shelter.Lizard;
import shelter.Gender;
import shelter.DogBreed;
import shelter.LizardBreed;

public class Mass{
	public static void main(String args[]){
		Shelter s1 = new Shelter("AnimalCompanions");
		Gender m = Gender.valueOf("male");
		Gender f = Gender.valueOf("female");
		try{
		s1.addAnimals(new Dog(DogBreed.valueOf("Boxer"),"Mack",m,5));
		s1.addAnimals(new Lizard(LizardBreed.valueOf("Gecko"),"Danger",f,3));
		}catch(IllegalArgumentException e){
			System.err.println(e.getMessage());
			System.exit(-1);
		}
		
		System.out.print(s1);
		
	
	
	}
}