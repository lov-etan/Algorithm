#include <string>
#include <vector>
#include <algorithm>

using namespace std;
vector<vector<string>> tarr;
vector<int> used;
vector<string> ans;
vector<string> picks;
bool isS = false;

void dfs(int cnt, string start) {
    if(isS) return;
    
    if(cnt == tarr.size()) {
        ans = picks;
        isS = true;
        return;
    }
    
    for(int i=0; i<tarr.size(); i++) {
        if(!used[i] && tarr[i][0] == start) {
            used[i] = true; picks.push_back(tarr[i][1]);
            dfs(cnt+1, tarr[i][1]);
            used[i] = false; picks.pop_back();
        }
    }
}

vector<string> solution(vector<vector<string>> tickets) {
    tarr = tickets;
    used.resize(tickets.size());
    sort(tarr.begin(), tarr.end());
    
    picks.push_back("ICN");
    dfs(0, "ICN");
    
    return ans;
}