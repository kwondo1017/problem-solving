#include <string>
#include <vector>

using namespace std;

string solution(string s) {
    string answer = "";
    
    if(s.size() % 2 == 0){
        int index = s.size() / 2 - 1;
        answer = s.substr(index, 2);
    }
    else{
        int index = s.size() / 2;
        answer += s[index];
    }
    
    return answer;
}