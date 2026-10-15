#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        vector<int> result;
        unordered_map<int, int> visited;

        for(int i=0; i<nums.size(); i++){
            int x = target - nums[i];
            auto it = visited.find(x);
            if(it != visited.end()){
                result = {it->second, i};
                return result;
            }
            visited[nums[i]] = i;
        }

        return result;
    }
};