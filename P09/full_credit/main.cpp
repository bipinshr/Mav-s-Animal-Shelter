#include "color.h"
#include <iostream>

int main() {
   Color red{255,0,0};
   std::cout << red.colorize("Red") << std::endl;
}