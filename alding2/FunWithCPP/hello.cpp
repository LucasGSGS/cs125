//UIUC CS125 FALL 2013 MP. File: hello.cpp, CS125 Project: FunWithCPP, Version: 2013-11-18T23:36:18-0600.567861214
#include <iostream>
#include <string>

using std::string;
using std::cout;
using std::endl;

int main()
{
   cout << "Hey,";
   string mesg = "this my second C++ program";
   mesg += "!";
   cout << mesg << endl;
 
  // endl stands for 'end line'

   for(int i=1; i<17; i++) {
     for (int j = 1; j<17; j++) {
	cout << i*j;
     }
     cout << endl;
   }
   return 0;
}
