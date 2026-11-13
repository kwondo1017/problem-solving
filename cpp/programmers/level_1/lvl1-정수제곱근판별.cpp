#include <string>
#include <vector>
#include<bits/stdc++.h>

using namespace std;

long long solution(long long n) {
    long long answer = 0;
    
    auto root = sqrt(n);
    auto point = root - static_cast<int>(root);
    
    if(point == 0) answer = pow(root + 1, 2);
    else answer = -1;
        
    return answer;
}