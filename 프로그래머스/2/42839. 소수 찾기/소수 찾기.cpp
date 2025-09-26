#include <string>
#include <vector>
#include <iostream>
#include <algorithm>
#include <set>
#include <cmath>

using namespace std;
string s;
set<int> sets;
vector<bool> used;

bool isPrime(int num) {
    if(num == 1) return false;
    for(int i=2; i<=sqrt(num); i++) {
        if(num%i == 0) return false;
    }
    return true;
}

void dfs(int cnt, int sum) {
    if(sum != 0) sets.insert(sum);
    if(cnt == s.size()) return;
    
    int tmp = -1;
    for(int i=0; i<s.size(); i++) {
        int curr = s[i]-'0';
        if(used[i] || tmp == curr) continue;
        
        used[i] = true;
        
        dfs(cnt+1, sum*10+curr);
        
        used[i] = false;
        tmp = curr;
    }
    
}

int solution(string numbers) {
    int answer = 0;
    s = numbers;
    sort(s.begin(), s.end());
    used.resize(s.size(), false);
    dfs(0,0);
    for(auto s : sets) {
        if(isPrime(s)) {
            answer++;
        }
    }
    return answer;
}