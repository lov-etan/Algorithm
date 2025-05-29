#include <iostream>
#include <queue>

using namespace std;

int main() {
    int N; 
    int answer = 1;
    cin >> N;

    queue<int> q;

    for(int i=1; i<=N; i++) {
        q.push(i);
    }

    while(q.size() > 1) {
        // cout << q.front() << "\n";
        // 제일 위에 걸 버린다
        q.pop();

        // 그 다음, 제일 위에 있는 카드를 제일 아래로 옮긴다.
        int num;
        num = q.front();
        q.pop();
        q.push(num);


        if(!q.empty()) {
            //현재 남아있는 수 확인
            answer = q.front();
        }
    }

    cout << answer << endl;
}