import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int M;
    static int[][] graph;
    public static void main(String[] args) throws Exception {
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ir);
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new int[N][N];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int result = 0;
        for(int i = 0; i < N; i++){
            int garo = garoHappyNumber(i);
            int sero = seroHappyNumber(i);
            if(garo >= M) result++;
            if(sero >= M) result++;
        }
        System.out.println(result);
    }

    static int seroHappyNumber(int y){
        int count = 1;
        int maxCount = 0;
        int prevNum = graph[0][y];
        for(int i = 1; i < N; i++){
            if(prevNum != graph[i][y]){
                count = 1;
            }
            else{
                count++;
            }
            maxCount = Math.max(maxCount, count);
            prevNum = graph[i][y];
        }
        return maxCount;
    }

    static int garoHappyNumber(int x){
        int count = 1;
        int maxCount = 0;
        int prevNum = graph[x][0];
        for(int i = 1; i < N; i++){
            if(prevNum != graph[x][i]){
                count = 1;
            }
            else{
                count++;
            }
            maxCount = Math.max(maxCount, count);
            prevNum = graph[x][i];
        }
        return maxCount;
    }
}