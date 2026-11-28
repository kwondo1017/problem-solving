#include <string>
#include <vector>

using namespace std;

string solution(string phone_number) {
    string answer = "";
    int count = phone_number.size();
    
    
    
    for(int i=0; i+4<count; ++i){
        answer += "*";
    }
    
    answer += phone_number.substr(count-4);
    
    return answer;
}

// sub_str 함수는 문자열을 복사하는 값이 있기에 phone_number[i]로 직접 변경하는게 더 효율적일 수 있다. 
// 혹은 replace 함수를 이용하여 phone_number의 앞부분을 *로 바꾸는 방법도 있다.