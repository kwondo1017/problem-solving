#include <string>
#include <vector>
#include <bits/stdc++.h>

using namespace std;

string solution(string s) {
    string answer = "";
    string buff = "";
    vector<int> v;
    
    for(char c : s){
        if(c == ' '){
            v.push_back(std::stoi(buff));
            buff = "";
        }
        else{
            buff += c;
        }
    }
    
    v.push_back(std::stoi(buff));
    
    int max_val = *std::max_element(v.begin(), v.end());
    int min_val = *std::min_element(v.begin(), v.end());
    
    answer += to_string(min_val);
    answer += " ";
    answer += to_string(max_val);
    
    return answer;
}