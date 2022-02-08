
public class Word 
{
    private char[] letters = new char[5];
    
	public Word(String solution) {
        this.letters = solution.toCharArray();
    }
	
	public char charAt(int position) {
		return letters[position];
        
    }
	
	public void setCharAt(char c,int position) {
		letters[position] = c;
    }
	
	public String toString() {
		return new String(letters);
        
    }
	
   
}
