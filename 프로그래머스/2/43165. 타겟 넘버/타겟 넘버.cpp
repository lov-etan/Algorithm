#include <string>
#include <vector>

using namespace std;

vector<int> s_numbers;
int s_target = 0;
int answer = 0;

void dfs(int idx, int sum) {
    if(idx == s_numbers.size()) {
        if(sum == s_target) answer++;
        return;
    }
    
    dfs(idx+1, sum + s_numbers[idx]);
    dfs(idx+1, sum - s_numbers[idx]);
}



int solution(vector<int> numbers, int target) {
    s_numbers = numbers;
    s_target = target;
    answer = 0;
    
    dfs(0,0);
    
    return answer;
}