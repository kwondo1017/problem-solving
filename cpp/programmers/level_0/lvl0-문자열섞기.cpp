#include <string>
#include <vector>

using namespace std;

string solution(string str1, string str2) {
    string answer = "";
    
    for(auto i=0; i<str1.size(); ++i){
        answer += str1[i];
        answer += str2[i];
    }
        
    return answer;
}


// str + char는 string 객체를 새로 생성하지만, += 연산자 혹은 str.push_back(char) 메서드를 사용하면 기존 string 객체에 O(1) 시간 복잡도로 char를 추가할 수 있다. 
// 따라서 반복문 안에서 str + char를 사용하면 O(n^2) 시간 복잡도가 발생할 수 있으므로, += 연산자 혹은 str.push_back(char)를 사용하는 것이 좋다.