import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int[] dp;
    public static void main(String[] args) throws Exception {
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ir);
        N = Integer.parseInt(br.readLine());
        dp = new int[N + 1];
        if(N == 2){
            System.out.println(2);
            return;
        }
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        for(int i = 3; i < N + 1; i++){
            dp[i] = dp[i - 2] % 10007 + dp[i - 1] % 10007;
        }
        System.out.print(dp[N] % 10007);
    }
}