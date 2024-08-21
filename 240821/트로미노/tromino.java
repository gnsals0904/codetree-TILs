import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static int[][] graph;
    static int[][] vector = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    static int result = 0;
    public static void main(String[] args) throws Exception{
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ir);
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new int[N][M];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                dfs(i, j, graph[i][j], 1);
            }
        }
        System.out.println(result);
    }

    static void dfs(int x, int y, int tempSum, int k){
        if(k >= 3){
            result = Math.max(result, tempSum);
            return;
        }
        for(int[] v: vector){
            int nx = v[0] + x;
            int ny = v[1] + y;
            if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
            // System.out.println("nx ny : " + nx + " : " + ny);
            dfs(nx, ny, tempSum + graph[nx][ny], k + 1);
        }
    }
}