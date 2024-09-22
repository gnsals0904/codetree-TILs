import java.io.*;
import java.util.*;

public class Main {
    static int[] dp;
    public static void main(String[] args) throws Exception {
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ir);
        int n = Integer.parseInt(br.readLine());
        dp = new int[n + 1];
        if(n == 2){
            System.out.println(1);
            return;
        }
        dp[0] = 0;
        dp[1] = 0;
        dp[2] = 1;
        dp[3] = 1;
        for(int i = 4; i < n + 1; i++){
            dp[i] = dp[i - 2] % 10007 + dp[i - 3] % 10007;
        }
        System.out.print(dp[n] % 10007);
    }
}