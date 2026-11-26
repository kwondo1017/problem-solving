#include <string>
#include <vector>

using namespace std;

int solution(int num) {
    int answer = 0;
    long long n = num;
    
    while (n != 1 && answer < 500) {
        n = (n % 2 == 0) ? n / 2 : 3 * n + 1;
        ++answer;
    }
    
    answer = (answer < 500) ? answer : -1;
    
    return answer;
}

// 테스트케이스 num = 626331에 대해 solution(626331)의 결과는 -1입니다.
// 하지만 계산 중 int 범위를 넘어 long long으로 계산해야 하는 경우가 발생할 수 있으므로
// // n을 long long으로 선언하여 계산하도록 수정했습니다.