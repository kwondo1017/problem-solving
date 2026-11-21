#include <string>
#include <iostream>
using namespace std;

bool solution(string s)
{
    bool answer = true;
    
    int count = 0;

    for(char& c : s){
        if(c == 'p' || c == 'P') count++;
        if(c == 'y' || c == 'Y') count--;
    }
    
    answer = (count == 0) ? true : false;

    return answer;
}