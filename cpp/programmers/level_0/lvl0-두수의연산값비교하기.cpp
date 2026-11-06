#include <string>
#include <vector>

using namespace std;

int solution(int a, int b) {
    int answer = 0;
    
    string str = std::to_string(a) + std::to_string(b);
    answer = std::stoi(str);
    
    if( 2*a*b > answer) return 2*a*b;
    else return answer;
}