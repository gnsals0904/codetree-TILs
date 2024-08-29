import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int[][] graph;
    static boolean[][] boomArea;
    static int boomCount = 0;
    static int result = 0;
    static int[][][] vector = {
        {{-1, 0}, {-2, 0}, {1, 0}, {2, 0}},
        {{1, 0}, {-1, 0}, {0, -1}, {0, 1}},
        {{1, 1}, {1, -1}, {-1, 1}, {-1, -1}}
        };
    static int[] booms;
    public static void main(String[] args) throws Exception {
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ir);
        N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        graph = new int[N][N];
        boomArea = new boolean[N][N];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
                if(graph[i][j] == 1) {
                    boomCount++;
                }
            }
        }
        booms = new int[boomCount];
        dfs(0);
        System.out.print(result);
    }

    static void dfs(int depth){
        if(depth == boomCount){
            calcArea();
            result = Math.max(result, countArea());
            resetBoomArea();
            return;
        }
        for(int i = 1; i <= 3; i++){
            booms[depth] = i;
            dfs(depth + 1);
        }
    }

    static void calcArea(){
        int count = 0;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(graph[i][j] == 1){
                    boomArea[i][j] = true;
                    boomEffect(i, j, booms[count]-1);
                    count++;
                }
            }
        }
    }

    static int countArea(){
        int result = 0;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(boomArea[i][j]) result++;
            }
        }
        return result;
    }

    static void boomEffect(int x, int y, int dir){
        for(int i = 0; i < 4; i++){
            int nx = x + vector[dir][i][0];
            int ny = y + vector[dir][i][1];
            if(isRange(nx, ny))
                boomArea[nx][ny] = true;
        }
    }

    static void resetBoomArea(){
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                boomArea[i][j] = false;
            }
        }
    }


    static boolean isRange(int x, int y){
        return x >= 0 && x < N && y >= 0 && y < N;
    }

}