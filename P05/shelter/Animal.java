package shelter;
abstract class Animal {
    
	protected String name;
	protected Gender gender;
	protected int age;
    
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
	
	public String toString(){
		return "" + name +" (" + age + " year old " + gender + ")" ;
	}
}



