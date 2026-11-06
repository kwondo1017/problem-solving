#include <string>
#include <vector>

using namespace std;

string solution(string my_string, string overwrite_string, int s) {
    string answer = "";
    
    std::string sub = my_string.substr(0, s);
    answer += sub;
    answer += overwrite_string;
    
    if(my_string.size() != answer.size()){
        std::string sub = my_string.substr(answer.size());
        answer += sub;
    }
    
    return answer;
}



// substr과 std::string + 오퍼레이션 모두 실제 문자열을 복사하는 비용이 들어 O(n) 시간복잡도를 가진다. 
// replace 오퍼레이션 사용 시 변경할 문자열만 복사하면 되므로 O(m) 시간복잡도를 가진다. (m = overwrite_string.size())
// answer = my_string.replace(s,overwrite_string.size(),overwrite_string);
