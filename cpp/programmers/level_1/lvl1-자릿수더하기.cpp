#include <iostream>

using namespace std;
int solution(int n)
{
    int answer = 0;
    
    string s = to_string(n);
    
    for(char c : s){
        answer += c - '0';
    }

    return answer;
}

// char형에서 아스키 코드 값을 이용하여 '0'을 빼주면 int형으로 변환이 가능합니다.
// '0' - '9'까지 연속되어있고 'a' - 'z' - > 'A' - 'Z'까지 연속되어있기 때문에 아스키 코드 값을 이용한 변환이 가능합니다. 