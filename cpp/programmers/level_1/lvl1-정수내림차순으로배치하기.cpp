#include <string>
#include <vector>
#include <bits/stdc++.h>

using namespace std;

long long solution(long long n) {
    long long answer = 0;
    
    string s = std::to_string(n);
    std::sort(s.rbegin(), s.rend());
        
    for(char c : s){
        answer = answer *10 + (c - '0');
    }
    
    return answer;
}

// stoi()는 out_of_range는 예외를 발생시키지만, 
// stoll()은 out_of_range가 발생하지 않아 반복문을 대체할 수 있다