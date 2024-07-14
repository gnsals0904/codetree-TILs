import java.util.*;
import java.io.*;

public class Main {
    static int N;
    public static void main(String[] args) throws Exception {
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ir);
        N = Integer.parseInt(br.readLine());
        System.out.println(dfs(N));

    }

    static int dfs(int n){
        if(n < 10){
            return n * n;
        }
        int v = n % 10;
        return dfs(n / 10) + v * v;
    }
}