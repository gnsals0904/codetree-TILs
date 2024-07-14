import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ir);
        N = Integer.parseInt(br.readLine());
        dfs(0);
        System.out.print(sb);
    }

    static void dfs(int depth){
        if(depth == N) return;
        for(int i = 0; i < N - depth; i++){
            sb.append("*").append(" ");
        }
        sb.setLength(sb.length() - 1);
        sb.append("\n");
        dfs(depth + 1);
        for(int i = 0; i < N - depth; i++){
            sb.append("*").append(" ");
        }
        sb.setLength(sb.length() - 1);
        sb.append("\n");
    }
}