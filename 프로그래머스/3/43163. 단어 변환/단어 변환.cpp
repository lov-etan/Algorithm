#include <string>
#include <vector>
#include <iostream>
#include <queue>

using namespace std;

bool changeOne(string a, string b) {
    int cnt = 0;
    for(int i=0; i<a.length(); i++) {
        if(a[i] != b[i]) cnt++;
    }
    
    if(cnt == 1) {
        return true;
    } else {
        return false;
    }
}

int solution(string begin, string target, vector<string> words) {
    int answer = 0;
    int N = words.size();
    
    // 반환 불가
    int impos = 0;
    for(int i=0; i<N; i++) {
        if(words[i] == target) impos++;
    }
    if(impos == 0) return 0;
    
    vector<bool> visited(N, false);
    queue<pair<string, int>> q;
    q.push({begin,0});
    while(!q.empty()) {
        pair<string, int> curr = q.front(); q.pop();
        string word = curr.first;
        int cnt = curr.second;
        
        if(word == target) {
            return cnt;
        }
        
        for(int i=0; i<N; i++) {
            if(!visited[i] && changeOne(word, words[i])) {
                visited[i] = true;
                q.push({words[i], cnt+1});
            }
        }
        
    }
    
    
    
    return answer;
}