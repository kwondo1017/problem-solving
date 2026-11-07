#include <string>
#include <vector>

using namespace std;

string solution(vector<string> arr) {
    string answer = "";
    
    for(auto it : arr){
        answer += it;
    }
    
    return answer;
}