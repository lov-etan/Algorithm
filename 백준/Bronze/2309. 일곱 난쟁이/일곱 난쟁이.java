import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[] Nr = new int[9]; //아홉 난쟁이 
		int nineSum = 0;
		for(int i=0; i<9; i++) {
			Nr[i] = sc.nextInt();
			nineSum += Nr[i];
		}
		Arrays.sort(Nr); //9 난쟁이 키 순으로 정렬  
		//System.out.println(Arrays.toString(Nr));
		
		int diffIdx1 = 0;
		int diffIdx2 = 0;
		//조합: 9 C 2
		for(int i=0; i<9-1; i++) {
			for(int j=i+1; j<9; j++) {
				int	diffSum = 0;
				diffSum = Nr[i] + Nr[j]; //제외할 두 수 
				
				if(nineSum - diffSum == 100) {
					diffIdx1 = i;
					diffIdx2 = j;
				}
			}
		}
		
		for(int i=0; i<9; i++) {
			if(i == diffIdx1 || i == diffIdx2) {
				continue;
			} else {
				System.out.println(Nr[i]);
			}
		}
		
		
	}

}