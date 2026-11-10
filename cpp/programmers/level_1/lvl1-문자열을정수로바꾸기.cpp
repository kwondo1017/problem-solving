#include <string>
#include <vector>

using namespace std;

int solution(string s) {
    int answer = 0;
    
    if(s[0] == '+' || s[0] == '-'){
        answer = (s[0] == '+') ? std::stoi(s.substr(1)) : (-1) * std::stoi(s.substr(1));
    }
    else{
        answer = std::stoi(s);
    }
    
    
    return answer;
}

// std::stoi()는 앞 부호까지 포함해서 변경이 되기에 딱히 부호를 제외한 숫자 부분만 변환하기 위해 
// substr()를 사용하여 부호 조건식을 구현할 필요는 없습니다. 

// answer + std::stoi(s)로 바로 구현해도 됩니다.