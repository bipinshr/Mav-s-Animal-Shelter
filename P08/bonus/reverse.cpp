#include <iostream>
#include <algorithm>
 int main(int argc, char* argv[]) 
 {
	std::string name;
	
	for(int i=1;i<argc;i++ )
	{
		name = argv[i];
		std::reverse(name.begin(),name.end());
		std::cout<<name<<"\n";
	}
	
 }