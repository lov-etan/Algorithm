#include <string>
#include <vector>
#include <algorithm>

using namespace std;
vector<vector<string>> t;
vector<bool> visited(t.size(), false);
vector<string> answer;

bool dfs(string curr, int cnt) {
    answer.push_back(curr);
    if(cnt == t.size()) {
        return true;
    }
    
    for(int i=0; i<t.size(); i++) {
        if(!visited[i] && t[i][0] == curr) {
            visited[i] = true;
            if(dfs(t[i][1], cnt+1)) {
                return true;
            } else {
                visited[i] = false;
                answer.pop_back();
            }
        }
    }
    
    return false;
}

vector<string> solution(vector<vector<string>> tickets) {
    t = tickets;
    visited.resize(t.size(), false);
    sort(t.begin(), t.end());
    dfs("ICN", 0);
    return answer;
}