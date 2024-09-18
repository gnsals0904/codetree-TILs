import java.util.*;
import java.io.*;

public class Main {
    static int result;
    static int N, M;
    static boolean[][] graph;
    static boolean[][] visited;
    static Queue<Point> queue = new LinkedList();
    static int[][] vector = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public static void main(String[] args) throws Exception {
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ir);
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new boolean[N][N];
        visited = new boolean[N][N];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                int temp = Integer.parseInt(st.nextToken());
                if(temp == 0) graph[i][j] = true;
            }
        }
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            if(visited[x][y]) continue;
            queue.add(new Point(x, y));
            visited[x][y] = true;
            bfs();
        }
        System.out.println(result);
    }

    static void bfs(){
        int temp = 1;
        while(!queue.isEmpty()){
            Point p = queue.poll();
            for(int[] v : vector){
                int nx = p.x + v[0];
                int ny = p.y + v[1];
                if(!isRange(nx, ny)) continue;
                if(visited[nx][ny]) continue;
                if(!graph[nx][ny]) continue;
                queue.add(new Point(nx, ny));
                visited[nx][ny] = true;
                temp++;
            }
        }
        result += temp;
    }

    static boolean isRange(int x, int y){
        return x >= 0 && x < N && y >= 0 && y < N;
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