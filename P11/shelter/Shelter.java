package shelter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
public class Shelter{
	private String name;
	private String filename;
	private ArrayList<Animal> animals;
	private ArrayList<Client> clients;
	private HashMap<Animal,Client> adoptions;
	
	public Shelter(String name){
		this.name = name;
		this.animals = new ArrayList<>();
		this.clients = new ArrayList<>();
		this.adoptions=new HashMap<>();
	}
	
	public Shelter(BufferedReader br) throws IOException{
		name = br.readLine();
		int animalcount =Integer.parseInt(br.readLine());
		animals = new ArrayList<>(animalcount);
		
		for(int i = 0; i < animalcount; i++)
		{
			String type = br.readLine();
			
			if(type.equals("Dog"))
			{
				addAnimals(new Dog(br));
			}
			else if(type.equals("Lizard"))
			{
				addAnimals(new Lizard(br));
			}
			else
			{
				addAnimals(new GuineaPig(br));
			}
			
		}
		int clientcount =Integer.parseInt(br.readLine());
		clients = new ArrayList<>(clientcount);
		
		for(int i = 0; i < clientcount; i++)
		{
			addClient(new Client(br));
		}
		
	}
	
	public void save(BufferedWriter bw) throws IOException{
		bw.write("" + name + '\n');
        bw.write("" + animals.size()+'\n');        
        for (Animal a: animals)
		{
			a.save(bw);
		}
		bw.write("" + clients.size()+'\n');        
        for (Client a: clients)
		{
			a.save(bw);
		}
		
	}
	
	
	public String getFilename(){
		return filename;
	}
	
	public void setFilename(String filename)
	{
		this.filename =filename;
	}
	
	
	public void addAnimals(Animal animal){
		animals.add(animal);
	}
	
	public void addClient(Client client){
		clients.add(client);
	}
	
/*	
	public int numClients() {
        return clients.size();
    }
	
	public int numAnimals() {
        return animals.size();
    }
*/
	public ListIterator<Animal> animalListilerator(){
			return animals.listIterator();
	}

	public ListIterator<Client> clientListilerator(){
			return clients.listIterator();
	}

	
	
    public Animal getAnimal(int index) {
        return animals.get(index);
    }
	@Override
	public String toString(){
		String result = "";
		String seperator=" ";
		for (Animal a: animals) { 
                result += seperator + a;
				seperator= "\n";
        }
		return result;
	}
	public String clientToString(){
		String result = "";
		String seperator=" ";
		for (Client a: clients) { 
                result += seperator + a;
				seperator= "\n";
        }
		return result;
	}
	
	
	public void adopt(Animal animal,Client client)
	{
		adoptions.put(animal,client);
	}
	
	public Iterator<Animal> adoptedAnimaliterator(){
		return animals.iterator();
	}
	
	public void getAdoptesClient(Animal animal)
	{
		
	}
	
	
	
	public String adoptionsToString()
	{
		String result = "";
		String seperator=" ";
		for(Animal key : adoptions.keySet())
		{			
             result += seperator + key +adoptions.get(key);
			 seperator="\n";
		}
		return result;
	}
	
}