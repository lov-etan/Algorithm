#include <string>
#include <vector>

using namespace std;
int answer = 0;
vector<int> nums;
int t;

void dfs(int idx, int sum) {
    if(idx == (int)nums.size()) {
        if(sum == t) answer++;
        return;
    }
    
    // 더한다
    dfs(idx+1, sum + (-1)*nums[idx]);
    // 뺀다
    dfs(idx+1, sum + nums[idx]);
}

int solution(vector<int> numbers, int target) {
    nums = numbers;
    t = target;
    
    dfs(0, 0);
    
    return answer;
}