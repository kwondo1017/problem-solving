#include <string>
#include <vector>
#include <bits/stdc++.h>

using namespace std;

vector<int> solution(long long n) {
    vector<int> answer;
    
    string s = std::to_string(n);
    std::reverse(s.begin(), s.end());
    
    for(char c : s){
        int num = c - '0';
        answer.push_back(num);
    }
    
    return answer;
}