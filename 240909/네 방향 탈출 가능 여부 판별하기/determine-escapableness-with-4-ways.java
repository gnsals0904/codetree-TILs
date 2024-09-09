import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static int[][] graph;
    static boolean[][] visited;
    static int[][] vector = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static Queue<Point> queue = new LinkedList();
    public static void main(String[] args) throws Exception {
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ir);
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new int[N][M];
        visited = new boolean[N][M];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        queue.add(new Point(0, 0));
        visited[0][0] = true;
        bfs();
        if(visited[N - 1][M - 1])
            System.out.println(1);
        else
            System.out.println(0);
    }

    static void bfs(){
        while(!queue.isEmpty()){
            Point p = queue.poll();
            for(int[] v: vector){
                int nx = p.x + v[0];
                int ny = p.y + v[1];
                if(!isRange(nx, ny)) continue;
                if(visited[nx][ny]) continue;
                if(graph[nx][ny] == 0) continue;
                visited[nx][ny] = true;
                queue.add(new Point(nx, ny)); 
            }
        }
    }
    
    static boolean isRange(int x, int y){
        return x < N && x >= 0 && y < M && y >= 0;
    }

    static class Point{
        int x;
        int y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}