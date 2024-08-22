import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static int[][] graph;
    static int[][] vector = {{1, -1}, {1, 1}, {-1, 1}, {-1, -1}};
    static int result = 0;
    static int maxSize;
    public static void main(String[] args) throws Exception {
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ir);
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new int[N][N];
        maxSize = 2 * (N - 1);
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                result = Math.max(result, calcCoinAmount(i, j, maxSize));
            }
        }
        System.out.println(result);
    }

    static int calcCoinAmount(int x, int y, int k){
        int maxGoldNum = 0;
        for(int size = 0; size <= k; size++){
            int i = x - size;
            int j = y;
            int gold = 0;
            for(int[] v : vector){
                for(int cnt = 0; cnt < size; cnt++){
                    i = i + v[0];
                    j = j + v[1];
                    if(inRange(i, j)){
                        if(graph[i][j] == 1) gold++;
                    }
                }
            }
            if(canMiningCoin(size, gold)){
                maxGoldNum = Math.max(maxGoldNum, gold);
            }
        }
        return maxGoldNum;
    }

    static boolean canMiningCoin(int k, int amount){
        return amount * M >= calcMiningValue(k);
    }

    static int calcMiningValue(int k){
        return k*k+(k+1)*(k+1);
    }

    static boolean inRange(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < N;
    }
}