#include<string>
#include <iostream>
#include <bits/stdc++.h>

using namespace std;

bool solution(string s)
{
    bool answer = true;
    std::stack<char> brackets;
    
    for(auto it=s.begin(); it!=s.end(); ++it){
        if(*it=='(') brackets.push(*it);
        else if(!brackets.empty()) brackets.pop();
        else {
            answer = false;
            break;
        }
    }
    
    if(!brackets.empty()) answer = false;
    
    return answer;
}