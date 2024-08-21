import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] graph;
    static int maxResult = 0;
    public static void main(String[] args) throws IOException {
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ir);
        N = Integer.parseInt(br.readLine());
        graph = new int[N][N];
        StringTokenizer st;
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                maxResult = Math.max(maxResult, countNum(i, j));
            }
        }
        System.out.println(maxResult);
    }

    static int countNum(int x, int y){
        int count = 0;
        for(int i = x; i < x + 3; i++){
            if(i >= N) return 0;
            for(int j = y; j < y + 3; j++){
                if(j >= N) return 0;
                if(graph[i][j] == 1) count++;
            }
        }
        return count;
    }
}