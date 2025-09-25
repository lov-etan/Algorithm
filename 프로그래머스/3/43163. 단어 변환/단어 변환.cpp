#include <string>
#include <vector>

using namespace std;
int INF = 98765432;
int ans = INF;
string b, t;
vector<string> arr;
vector<bool> used;

bool check(string s1, string s2) {
    int cnt = 0;
    for(int i=0; i<s1.size(); i++) {
        if(s1[i] != s2[i]) cnt++;
    }
    return cnt==1;
}

void dfs(string curr, int cnt) {
    if(curr == t) {
        ans = min(ans, cnt);
        return;
    }
    if(ans < cnt) return;
    
    for(int i=0; i<arr.size(); i++) {
        if(!used[i] && check(curr, arr[i])) {
            used[i] = true;
            dfs(arr[i], cnt+1);
            used[i] = false;
        }
    }
}

int solution(string begin, string target, vector<string> words) {
    b = begin; t = target; arr = words;
    used.resize(arr.size(), false);
    
    dfs(b, 0);
    if(ans == INF) return 0;
    else return ans;
}