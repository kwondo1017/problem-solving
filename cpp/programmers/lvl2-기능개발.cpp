#include <string>
#include <vector>
#include <bits/stdc++.h>

using namespace std;

vector<int> solution(vector<int> progresses, vector<int> speeds) {
    vector<int> answer;
    vector<int> days;
    
    
    for(auto i=0; i < progresses.size(); ++i){
        int n = (100 - progresses[i] + speeds[i] - 1) / speeds[i];
        days.push_back(n);
    }
    
    int max = days[0];
    stack<int> count;
    
    for(auto num : days){
        if(max < num){
            answer.push_back(count.size());
            while(!count.empty()) count.pop();
            max = num;
            count.push(num);
        }
        else{
            count.push(num);
        }
    }
    
    if(!count.empty()){
        answer.push_back(count.size());
    }
    
    return answer;
}

// 스택으로 되어있어서 스택으로 풀었지만 int형 변수 하나로도 풀 수 있음.
// for(auto i=0; i<count.size(); ++i)로 하면 안됨. count.size()는 계속 변하기 때문에 for문이 끝나지 않음.