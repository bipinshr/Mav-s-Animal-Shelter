public class Substitution implements Cypher
{
	protected char[] encryptkey =  new char[26];
	protected char[] decryptkey = new char[26];
	
	public Substitution(String key)
	{
		
			this.encryptkey = key.toCharArray();
			String decryptstring = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
			this.decryptkey = decryptstring.toCharArray();
		
	}
	
	public String encrypt(String unencrypted)
	{
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
			for(int j=0;j<decryptkey.length;j++)
			{
			      if(unencryptedchar[i]==decryptkey[j])
					  result += encryptkey[j];
			}
		}
		return result;
	}
	
	public String decrypt(String encrypted)
	{	
		String UPcaseencrpted = encrypted.toUpperCase();
		char[] encryptedchar = UPcaseencrpted.toCharArray();
		String result ="";
		for(int i=0;i<encrypted.length();i++)
		{
			if (encryptedchar[i] == ' ')
			        result += " ";
			
			if((int)encryptedchar[i]<=64)
			{
				result+=encryptedchar[i];
			}
			
			for(int j=0;j<decryptkey.length;j++)
			{
			      if(encryptedchar[i]==encryptkey[j])
					  result += decryptkey[j];
			}
		}
		return result;
	}
	
}