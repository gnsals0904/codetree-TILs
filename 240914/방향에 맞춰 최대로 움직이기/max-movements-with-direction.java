import java.util.*;
import java.io.*;


public class Main {
    static int N;
    static int[][] graph;
    static int[][] dirGraph;
    static int result;
    static int[][] vector = {{0, 0}, {-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}};
    public static void main(String[] args) throws Exception {
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ir);
        N = Integer.parseInt(br.readLine());
        graph = new int[N][N];
        dirGraph = new int[N][N];
        StringTokenizer st;
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                dirGraph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken()) - 1;
        int y = Integer.parseInt(st.nextToken()) - 1;
        dfs(x, y, dirGraph[x][y], 0);
        System.out.println(result);
    }

    static void dfs(int x, int y, int dir, int depth){
        int currValue = graph[x][y];
        int nx = x + vector[dir][0];
        int ny = y + vector[dir][1];
        while(isRange(nx, ny)){
            if(canGo(currValue, nx, ny)){
                dfs(nx, ny, dirGraph[nx][ny], depth + 1);
            }
            nx = nx + vector[dir][0];
            ny = ny + vector[dir][1];
        }
        result = Math.max(result, depth);
        return;
    }

    static boolean isRange(int x, int y){
        return 0 <= x && x < N && 0 <= y && y < N;
    }

    static boolean canGo(int num, int x, int y){
        return graph[x][y] > num;
    }
}