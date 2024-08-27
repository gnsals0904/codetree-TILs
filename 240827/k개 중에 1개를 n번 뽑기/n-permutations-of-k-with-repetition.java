import java.util.*;
import java.io.*;

public class Main {
    static int K, N;
    static int[] result;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ir);
        StringTokenizer st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        result = new int[N];
        dfs(0);
        System.out.println(sb);
    }

    static void dfs(int depth){
        if(depth == N){
            for(int j = 0; j < N; j++){
                sb.append(result[j]).append(" ");
            }
            sb.setLength(sb.length() - 1);
            sb.append("\n");
            return;
        }
        for(int i = 0; i < K; i++){
            result[depth] = i + 1;
            dfs(depth + 1);
        }
    }
}