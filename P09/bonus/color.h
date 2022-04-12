#ifndef __COLOR_H 
#define __COLOR_H

#include <iostream>

class Color {
	private:
		int _red;
		int _green;
		int _blue;
		bool _reset;
	public:
		Color(int red, int green, int blue);
		std::string to_string();
		std::string colorize(std::string text);
		friend std::ostream& operator<<(std::ostream& os, const Color& color);
};

#endif