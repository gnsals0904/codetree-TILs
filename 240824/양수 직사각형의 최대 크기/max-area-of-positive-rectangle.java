import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static int[][] graph;
    public static void main(String[] args) throws Exception {
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
        int result = -1;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                for(int x = i; x < N; x++){
                    for(int y = j; y < M; y++){
                        if(isValid(i, j, x, y)){
                            result = Math.max(result, ((x - i + 1) * (y - j + 1)));
                        }
                    }
                }
            }
        }
        System.out.println(result);
    }

    static boolean isValid(int x1, int y1, int x2, int y2){
        for(int i = x1; i <= x2; i++){
            for(int j = y1; j <= y2; j++){
                if(graph[i][j] <= 0) return false;
            }
        }
        return true;
    }


}