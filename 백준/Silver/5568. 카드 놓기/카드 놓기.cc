#include <iostream>
#include <vector>
#include <algorithm>
#include <set>

using namespace std;
int N, K;
vector<int> cards;
vector<bool> used;
set<string> sets;

void dfs(int cnt, string s) {
    if(cnt == K) {
        sets.insert(s);
        return;
    }    

    int tmp = -1;
    for(int i=0; i<N; i++) {
        if(!used[i] && tmp != cards[i]) {
            used[i] = true;
            
            string tmp = to_string(cards[i]);
            dfs(cnt+1, s + tmp);
            
            used[i] = false;
            tmp = cards[i];
        }
    }
}

int main() {
    cin.tie(0); cout.tie(0); ios::sync_with_stdio(0);
    cin >> N >> K;
    cards.resize(N, 0);
    used.resize(N, false);

    for(int i=0; i<N; i++) {
        cin >> cards[i];
    }
    sort(cards.begin(), cards.end());

    dfs(0, "");
    cout << sets.size();
    
    return 0;
}