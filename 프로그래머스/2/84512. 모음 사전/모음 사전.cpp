#include <string>
#include <vector>
#include <iostream>

using namespace std;
int answer = 0;
string arr = "AEIOU";
string w;
int cnt = 0;

void dfs(int sIdx, string s) {
    if(answer != 0 || sIdx == 6) return;
    if(s != "") cnt++;
    
    if(s == w) {
        answer = cnt;
        return;
    }
    
    for(int i=0; i<5; i++) {
        dfs(sIdx+1 ,s+arr[i]);
    }
}

int solution(string word) {
    w = word;
    dfs(0,"");
    return answer;
}