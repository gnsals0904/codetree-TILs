import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int[][] vector = {{-1, 1}, {-1, -1}, {1, -1}, {1, 1}};
    static int[][] graph;
    static int result = 0;
    public static void main(String[] args) throws Exception {
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
                for(int k = 0; k < N; k++){
                    for(int m = 0; m < N; m++){
                        result = Math.max(result, calcNumber(i, j, k, m));
                    }
                }
            }
        }
        System.out.println(result);
    }

    static int calcNumber(int x, int y, int width, int length){
        int nx = x;
        int ny = y;
        int tempResult = 0;
        int[] go = {width, length, width, length};
        for(int i = 0; i < 4; i++){
            int count = 1;
            while(count != go[i]){
                nx += vector[i][0];
                ny += vector[i][1];
                count++;
                if(!isRange(nx, ny)) return 0;
                tempResult += graph[nx][ny];
            }
        }
        return tempResult;
    }

    static boolean isRange(int x, int y){
        return x >= 0 && x < N && y >= 0 && y < N;
    }
}