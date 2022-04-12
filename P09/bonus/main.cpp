#include "color.h"
#include <iostream>

int main() {
	Color try = new Color(50, 50, 0);
	Color reset = new Color();  // This ends all colors and returns to the default
	std::cout << try << "Trying." << reset << std::endl;
}