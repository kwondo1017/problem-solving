#include <string>
#include <vector>
#include <bits/stdc++.h>

using namespace std;

vector<int> solution(vector<int> arr) {
    vector<int> answer;
    
    auto it = min_element(arr.begin(), arr.end());
    arr.erase(it);
    
    if(!arr.empty()){
        answer = std::move(arr);
    }
    else answer.push_back(-1);
    
    return answer;
}

// move 함수는 벡터를 생성할땐 vector<int> v2(std::move(v1)); 이런식으로 사용하지만, 이미 만든 벡터에 대입할땐 arg로 move를 넣을 수 없다.
// 이미 만들었지만 초기화하지않은 벡터를 대입할땐 v2 = std::move(v1); 이런식으로 사용한다.

// move 함수 사용 시 원본을 비워버리고 O(1)로 복사할 수 있다. 하지만 원본을 비워버리기 때문에 원본을 다시 사용해야하는 경우에는 move를 사용하면 안된다.