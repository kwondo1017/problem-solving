#include <string>
#include <vector>

using namespace std;

double solution(vector<int> arr) {
    double answer = 0;
    
    int sum = 0;
    double size = arr.size();
    for(auto it = arr.begin(); it != arr.end(); ++it){
        sum += *it;
    }
    
    answer = sum / size;
    
    return answer;
}