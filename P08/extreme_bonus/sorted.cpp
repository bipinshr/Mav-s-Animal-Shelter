#include <iostream>
#include <algorithm>
#include <string>
#include <vector>
 int main() 
 {
	std::string line;
	std::vector<std::string> v;
	
	while(std::getline(std::cin, line))
	{
	   v.push_back(line);
	}
	for(int i=0;i<v.size();i++)
	{
		std::cout<< v[i] <<"\n";
	}
	
	std::cout<<"\n";
	std::sort(v.begin(), v.end());
	
	for(int i=0;i<v.size();i++)
	{
		std::cout<< v[i] <<"\n";
	}
 return 0;
 }