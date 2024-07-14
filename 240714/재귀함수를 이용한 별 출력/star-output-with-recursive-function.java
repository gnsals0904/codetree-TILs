import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception{
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ir);
        N = Integer.parseInt(br.readLine());
        dfs(0);
        System.out.print(sb);
    }

    static void dfs(int depth){
        if(depth == N) return;
        for(int i = 0; i < depth + 1; i++){
            sb.append("*");
        }
        sb.append("\n");
        dfs(depth + 1);
    }
}