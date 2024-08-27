import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static int[][] graph;
    static int[][] tempGraph;
    static int Q;
    static int[][] vector = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    public static void main(String[] args) throws Exception {
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ir);
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        graph = new int[N][M];
        tempGraph = new int[N][M];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i = 0; i < Q; i++){
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken()) - 1;
            int y1 = Integer.parseInt(st.nextToken()) - 1;
            int x2 = Integer.parseInt(st.nextToken()) - 1;
            int y2 = Integer.parseInt(st.nextToken()) - 1;
            wind(x1, y1, x2, y2);
            changeNumber(x1, y1, x2, y2);
        }
        showGraph();
    }

    static void changeNumber(int x1, int y1, int x2, int y2){
        for(int i = x1; i <= x2; i++){
            for(int j = y1; j <= y2; j++){
                tempGraph[i][j] = calcAvg(i, j);
            }
        }
        for(int i = x1; i <= x2; i++){
            for(int j = y1; j <= y2; j++){
                graph[i][j] = tempGraph[i][j];
            }
        }
    }

    static int calcAvg(int x, int y){
        int temp = 0;
        int count = 1;
        for(int[] v : vector){
            int nx = x + v[0];
            int ny = y + v[1];
            if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
            count++;
            temp += graph[nx][ny];
        }
        temp += graph[x][y];
        return temp/count;
    }

    static void wind(int x1, int y1, int x2, int y2){
        int dir = 0;
        int x = x2;
        int y = y2;
        int temp = graph[x2][y2];
        while(true){
            int nx = x + vector[dir][0];
            int ny = y + vector[dir][1];

            if(isRange(nx, ny, x1, y1, x2, y2)) {
                graph[x][y] = graph[nx][ny];
                x = nx;
                y = ny;
            } else {
                dir++;
                if(dir == 4) {
                    graph[x2][y2 - 1] = temp;
                    break;
                }
            }
        }
    }

    static boolean isRange(int x, int y, int x1, int y1, int x2, int y2){
        return (x >= x1 && x <= x2 && y >= y1 && y <= y2);
    }

    static void showGraph(){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                sb.append(graph[i][j]).append(" ");
            }
            sb.setLength(sb.length() - 1);
            sb.append("\n");
        }
        System.out.println(sb);
    }
}