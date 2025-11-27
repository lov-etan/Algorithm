import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int N;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        if(N%2 != 0) System.out.println("SK");
        else System.out.println("CY");
    }
}