import java.util.*;
import java.io.*;

public class Main {
    static int N, T;
    static int[][] graph;
    public static void main(String[] args) throws Exception {
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ir);
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        graph = new int[3][N];
        for(int i = 0; i < 3; i++){            
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i = 0; i < T; i++){
            move();
        }
        showGraph();
    }

    static void move(){
        int temp1 = graph[0][N - 1];
        int temp2 = graph[1][N - 1];
        int temp3 = graph[2][N - 1];
        for(int i = 0; i < 3; i++){
            for(int j = N - 1; j > 0; j--){
                graph[i][j] = graph[i][j - 1];
            }
        }
        graph[0][0] = temp3;
        graph[1][0] = temp1;
        graph[2][0] = temp2;
    }

    static void showGraph(){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < N; j++){
                sb.append(graph[i][j]).append(" ");
            }
            sb.setLength(sb.length() - 1);
            sb.append("\n");
        }
        System.out.println(sb);
    }
}