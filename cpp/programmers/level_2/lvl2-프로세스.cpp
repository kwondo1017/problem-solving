#include <bits/stdc++.h>

using namespace std;

int solution(vector<int> priorities, int location) {
    int answer = 0;
    deque<pair<int, int>> q;
    
    for (auto i=0; i<priorities.size(); ++i){
        q.push_back({i, priorities[i]});
    }
    
    auto max = max_element(
        q.begin(), q.end(),
        [](const auto& a, const auto& b) {
            return a.second < b.second;
        }
    )->second;
        
    while(true){
        if(q.front().second < max){
            auto [idx, val] = q.front();
            q.pop_front();
            q.push_back({idx, val});
        }
        else{
            if(q.front().first == location){
                q.pop_front();
                break;
            }
            q.pop_front();
            max = max_element(
                q.begin(), q.end(),
                [] (const auto& a, const auto& b){
                    return a.second < b.second;
                }
            )->second;
        }
    }
    
    answer = priorities.size() - q.size();

    return answer;
}