
import java.io.*;
import java.util.*;
// 우선순위큐
public class Main {
    public static class Problem {
        int P, L;
        Problem(int P, int L) {
            this.P = P;
            this.L = L;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        
        // 난이도 오름차순, 같으면 번호 오름차순
        TreeSet<Problem> minHeap = new TreeSet<>((a, b) -> {
            if (a.L == b.L) return a.P - b.P;
            return a.L - b.L;
        });
        
        // 난이도 내림차순, 같으면 번호 내림차순
        TreeSet<Problem> maxHeap = new TreeSet<>((a, b) -> {
            if (a.L == b.L) return b.P - a.P;
            return b.L - a.L;
        });
        
        // 문제 번호를 키로 사용하는 맵, 값은 난이도
        HashMap<Integer, Integer> problems = new HashMap<>();
        
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int P = Integer.parseInt(st.nextToken());
            int L = Integer.parseInt(st.nextToken());
            
            Problem problem = new Problem(P, L);
            minHeap.add(problem);
            maxHeap.add(problem);
            problems.put(P, L);
        }
        
        int M = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            
            if (command.equals("recommend")) {
                int x = Integer.parseInt(st.nextToken());
                
                if (x == 1) {
                    sb.append(maxHeap.first().P).append('\n');
                } else {
                    sb.append(minHeap.first().P).append('\n');
                }
            } else if (command.equals("add")) {
                int P = Integer.parseInt(st.nextToken());
                int L = Integer.parseInt(st.nextToken());
                
                // 삭제된 동일 번호 문제 제거
                if (problems.containsKey(P)) {
                    int oldL = problems.get(P);
                    minHeap.remove(new Problem(P, oldL));
                    maxHeap.remove(new Problem(P, oldL));
                }
                
                Problem problem = new Problem(P, L);
                minHeap.add(problem);
                maxHeap.add(problem);
                problems.put(P, L);
            } else if (command.equals("solved")) {
                int P = Integer.parseInt(st.nextToken());
                int L = problems.get(P);
                
                minHeap.remove(new Problem(P, L));
                maxHeap.remove(new Problem(P, L));
                problems.remove(P);
            }
        }
        
        System.out.print(sb);
    }
}