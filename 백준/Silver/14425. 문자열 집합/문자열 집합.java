

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		TrieNode trieNode = new TrieNode();
		for(int i=0; i<N; i++) {
			trieNode.insert(br.readLine());
		}
		
		int answer = 0;
		
		for(int i=0; i<M; i++) {
			if(trieNode.contain(br.readLine())) {
				answer++;
			}
		}
		
		System.out.println(answer);
		
		
	}
	
	static class TrieNode{
		//노드의 자식 노드들을 저장 
		//Map<Character, TrieNode> child = new HashMap<>();
		TrieNode[] child = new TrieNode[26]; //소문자 26개 
		//이 노드가 단어의 끝인지 저장 
		boolean endOfWord;
		
		public TrieNode() {
		}
		
		
		public void insert(String word) {
			TrieNode trieNode = this; //루트 노드부터 시작 
			for(int i=0; i<word.length(); i++) {
				char c = word.charAt(i);
				int index = c - 'a'; //알파벳은 0-25 인덱스로 변화 ㄴ 
				
				//c가 트라이 트리 내부에 없다면 추가해주기 
//				trieNode.child.putIfAbsent(c, new TrieNode());
//				trieNode = trieNode.child.get(c); //현재 노드를 해당하는 자식(c) 노드로 이동시키기 
				
				if(trieNode.child[index] == null) {
					trieNode.child[index] = new TrieNode();
				}
				trieNode= trieNode.child[index]; //현재 노드를 해당하는 자식(c) 노드로 이동시키기 
				
				if(i==word.length()-1) {
					trieNode.endOfWord = true;
					return;
				}
				
				
			}
		}
		
		public boolean contain(String word) {
			TrieNode trieNode = this; //루트 노드부터 시작 
			for(int i=0; i<word.length(); i++) {
				int index = word.charAt(i) - 'a'; //현재 노드의 자식들 중 현재 문자(index번째 알파벳)에 해당하는 노드를 찾는다. 
				if(trieNode.child[index] == null) { //해당하는 노드가 없다면 false 
					return false;
				}
				trieNode = trieNode.child[index]; //노드가 존재한다면, 현재 노드를 찾은 자식 노드로 이동 
			}
			
			return trieNode.endOfWord; //마지막 노드의  endOfWord 값을 반환. 만약 마지막까지 잘 왔다면 true를 반환할 것이다. 
		}
	}

}
