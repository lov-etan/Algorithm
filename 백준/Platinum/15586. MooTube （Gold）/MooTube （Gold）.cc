#include <iostream>
#include <vector>
#include <queue>
#include <tuple>
#include <algorithm>

using namespace std;

int N, Q;
vector<tuple<int,int,int>> graph; // {유사도u, 영상a, 영상b} //k 10억까지니까 int형 가능
vector<tuple<int,int,int>> query; // {유사도K, 정점, 쿼리idx}
vector<int> parent; // parent[자식] = 부모
vector<int> groupCnt; // groupCnt[정점] = 가진 하위의 정점 수
vector<int> ans;

int Find(int a);
void Merge(int a, int b);

int main() {
    cin.tie(0); cout.tie(0); ios::sync_with_stdio(0);
    cin >> N >> Q;
    
    parent.resize(N+1, 0); groupCnt.resize(N+1, 0); 
    ans.resize(Q,0);
    
    for(int i=1; i<=N; i++) {
        parent[i] = i;
        groupCnt[i] = 1;
    }

    for(int i=0; i<N-1; i++) {
        int a, b, usado;
        cin >> a >> b >> usado;
        graph.push_back({usado, a, b});
    }

    for(int qidx=0; qidx<Q; qidx++) {
        int k, v;
        cin >> k >> v;
        query.push_back({k, v, qidx});
    }

    sort(graph.rbegin(), graph.rend());
    sort(query.rbegin(), query.rend()); // 유사도 높은 순으로 모두 정렬

    int gIdx = 0;
    for(int i=0; i<Q; i++) { // 질문을 K 높은 순으로 할게~
        auto[k, v, qidx] = query[i];
        
        while(gIdx < N-1 && k <= get<0>(graph[gIdx])) { // gIdx가 범위 내에 있고, 그것의 k유사도가 K보다 크거나 같을 때 고려해볼 조건이 됨
            int a = get<1>(graph[gIdx]); int b = get<2>(graph[gIdx]);
            Merge(a, b); // 둘이 먼저 연결시켜주기
            
            gIdx++;
        }
        
        ans[qidx] = groupCnt[Find(v)]-1; // 자기 자신은 빼주기
    }

    for(auto o : ans) {
        cout << o << "\n";
    }
    
    return 0;
}


void Merge(int a, int b) {
    a = Find(a); b = Find(b);
    parent[b] = a;
    groupCnt[a] += groupCnt[b];
}

int Find(int a) {
    if(parent[a] == a) return a;
    return parent[a] = Find(parent[a]);
}