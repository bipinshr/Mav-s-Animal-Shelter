package shelter;
public abstract class Animal {
    
	private String name;
	private Gender gender;
	private int age;
    
	public Animal(String name,Gender gender,int age){
		if(age < 0){ 
            throw new IllegalArgumentException("Invalid age");
		}
		this.name = name;
		this.gender = gender;
		this.age = age;
	}
	public abstract String family();
	public abstract String breed();
	public String name() {return name;}
    public Gender gender() {return gender;}
    public int age() {return age;}
	
	public String toString(){
		return name + " (" + age + " year old " + gender;
	}
}



