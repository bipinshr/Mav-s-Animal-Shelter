#include "color.h"
#include <iostream>

int main() {
    int x,y,z;
	Color orange{255,165,0}; 
	std::cout << orange.colorize("UTA Orange")<<" ";
	Color purple{159,43,104};
	std::cout << purple.colorize("UTA purple")<<" ";
	Color white{255,255,255};
	std::cout << white.colorize("UTA White") << std::endl;
	std::cout << "Enter red, green, and blue ints  ";
	std::cin >>x;
	std::cin >>y;
	std::cin >>z;
	Color guess{x,y,z};
	std::cout << guess.colorize(guess.to_string())<<std::endl;

}