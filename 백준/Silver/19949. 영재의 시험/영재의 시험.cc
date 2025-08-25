#include <iostream>
#include <vector>

using namespace std;

int ans;
vector<int> picks;
vector<int> answers;

using namespace std;

void dfs(int pre, int cnt, int depth, int score) {
    if(depth == 10) {
        if(score >= 5) ans++;
        return;
    }
    
    for(int i=1; i<=5; i++) {
        int tmpScore = score;
        if(answers[depth] == i) tmpScore++;
        
        if(pre!= i) {
            picks.push_back(i);
            dfs(i, 1, depth+1, tmpScore);
            picks.pop_back();
        }
        else if(pre == i && cnt < 2) {
            picks.push_back(i);
            dfs(i, 2, depth+1, tmpScore);
            picks.pop_back();
        }
    }
}

int main() {
    cin.tie(0); cout.tie(0); ios::sync_with_stdio(0);
    answers.resize(10, 0);
    for(int i=0; i<10; i++) {
        cin >> answers[i];
    }
    
    dfs(0,0,0,0);
    cout << ans;
    return 0;
}