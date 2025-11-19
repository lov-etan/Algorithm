import java.util.*;

class Solution {
    int answer = 0;
    int[] arr;
    boolean[] vis;
    HashSet<Integer> sets = new HashSet<>();
    
    boolean isPrime(int num) {
        if(num == 0 || num == 1) return false;
        for(int i=2; i<=Math.sqrt(num); i++) {
            if(num%i == 0) return false;
        }
        return true;
    }

    void dfs(int num) {
        sets.add(num);
        
        for(int i=0; i<arr.length; i++) {
            if(!vis[i]) {
                vis[i] = true;
                dfs(num*10 + arr[i]);
                vis[i] = false;
            }
        }
    }

    public int solution(String numbers) {
        arr = new int[numbers.length()];
        for(int i=0; i<numbers.length(); i++) {
            arr[i] = numbers.charAt(i) - '0';
        }
        vis = new boolean[arr.length];
        
        dfs(0);
        for(int s : sets) {
            // System.out.println(s);
            if(isPrime(s)) answer++;
        }
        
        return answer;
    }
}