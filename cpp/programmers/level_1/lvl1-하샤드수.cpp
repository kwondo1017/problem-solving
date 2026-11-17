#include <string>
#include <vector>

using namespace std;

bool solution(int x) {
    bool answer = true;
    
    string s = std::to_string(x);
    int count = 0;
    for(char c : s){
        count += c - '0';
    }
    
    if(x % count != 0) answer = false;
    
    return answer;
}