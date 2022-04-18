public class Rot13 extends Substitution
{
	public Rot13(){
	
	}
	@override
	public String encrypt(String unencrypted)
	{
		
		char[] s = unencrypted.toCharArray();
		String result = "";
        for(char c : s.toCharArray()) {
            if(c == ' ') {result += c; continue;}
            if('a' <= c && c <= 'z') {
                result += encryptkey.charAt(c-'a'); 
                continue;
            }
            throw new RuntimeException("Invalid char: " + c);
        }
        return result;
		/*
		String UPcaseunencrpted = unencrypted.toUpperCase();
		char[] unencryptedchar = UPcaseunencrpted.toCharArray();
		
		String result ="";
		for(int i=0;i<unencrypted.length();i++)
		{
			if (unencryptedchar[i] == ' ')
			        result += " ";
			if((int)unencryptedchar[i]<=64)
			{
				result+=unencryptedchar[i];
			}
			else
			{
				
			}
		}
		return result;
		*/
	}
}