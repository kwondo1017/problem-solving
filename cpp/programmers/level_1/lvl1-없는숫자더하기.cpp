#include <string>
#include <vector>
#include <bits/stdc++.h>

using namespace std;

int solution(vector<int> numbers) {
    int answer = -1;
    
    int sum = std::accumulate(numbers.begin(), numbers.end(), 0);
    answer = 45 - sum;
    
    return answer;
}

// numbers 배열에 중복되는 숫자가 없기에 가능한 풀이
// 중복이 있다면 set을 이용하여 중복 제거 후 합계를 구하는 방법도 가능