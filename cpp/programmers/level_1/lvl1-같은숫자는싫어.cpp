#include <vector>
#include <iostream>

using namespace std;

vector<int> solution(vector<int> arr) 
{
    vector<int> answer;
    
    answer.push_back(arr[0]);
    int current_idx = 0; 
    
    for(int i=1; i<arr.size(); i++){
        if(arr[i] != answer[current_idx]){
            current_idx++;
            answer.push_back(arr[i]);
        }
    }

    return answer;
}

/*
arr.erase(unique(arr.begin(), arr.end()), arr.end());
STL 내부 함수를 이용하여 더 간단히 구현은 가능하지만 시간복잡도가 똑같이 O(n)이므로 내 구현도 괜찮다고 생각함.

current_idx를 없애는게 더 좋은 방법
*/