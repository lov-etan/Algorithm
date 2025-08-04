#include <string>
#include <vector>
#include <iostream>

using namespace std;

vector<int> arr;
int K;
int answer = 0;

void dfs(int idx, int sum) {
    if(idx == arr.size()) {
        if(sum == K) {
            answer++;
            return;
        }
        return;
    }
    
    
    dfs(idx+1, sum - arr[idx]);
    dfs(idx+1, sum + arr[idx]);
}

int solution(vector<int> numbers, int target) {
    arr = numbers; K = target;
    dfs(0, 0);
    
    return answer;
}