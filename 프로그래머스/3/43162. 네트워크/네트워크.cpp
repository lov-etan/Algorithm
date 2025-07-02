#include <string>
#include <vector>
#include <queue>

using namespace std;

int solution(int n, vector<vector<int>> computers) {
    int answer = 0;
    vector<bool> visited(n,false);
    
    for(int i=0; i<n; i++) {
        if(!visited[i]) {            
            queue<int> q;
            q.push(i);
            while(!q.empty()) {
                int curr = q.front(); q.pop();
                visited[curr] = true;
                
                for(int j=0; j<n; j++) {
                    if(!visited[j] && computers[curr][j] == 1) {
                        q.push(j);
                    }
                }
            }
            answer++;
        }
    }
    return answer;
}