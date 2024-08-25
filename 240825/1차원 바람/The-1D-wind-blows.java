import java.util.*;
import java.io.*;

public class Main {
    static int N, M, Q;
    static int[][] graph;
    // R 0, L 1
    public static void main(String[] args) throws Exception {
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ir);
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        graph = new int[N][M];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i = 0; i < Q; i++){
            st = new StringTokenizer(br.readLine());
            int moveIdx = Integer.parseInt(st.nextToken()) - 1;
            int dir =  whichDir(st.nextToken().charAt(0));
            windMove(moveIdx, dir);
            int upIdx = moveIdx;
            int upDir = dir;
            while(upGo(upIdx)){
                upDir = toggleDir(upDir);
                windMove(upIdx - 1, upDir);
                upIdx--;
            }
            int downIdx = moveIdx;
            int downDir = dir;
            while(downGo(downIdx)){
                downDir = toggleDir(downDir);
                windMove(downIdx + 1, downDir);
                downIdx++;
            }
        }
        showGraph();
    }
    
    static int toggleDir(int dir){
        return (dir+1)%2;
    }

    // true => go false => stop
    static boolean upGo(int idx){
        if (idx <= 0) return false;
        for(int i = 0; i < M; i++){
            if(graph[idx][i] == graph[idx - 1][i]) return true;
        }
        return false;
    }

    static boolean downGo(int idx){
        if (idx >= N - 1) return false;
        for(int i = 0; i < M; i++){
            if(graph[idx][i] == graph[idx + 1][i]) return true;
        }
        return false;
    }

    static void windMove(int idx, int dir){
        int temp = -1;
        if(dir == 1) {
            temp = graph[idx][M - 1];
            for(int i = M - 1; i >= 1; i--){
                graph[idx][i] = graph[idx][i - 1];
            }
            graph[idx][0] = temp;
        }
        else {
            temp = graph[idx][0];
            for(int i = 0; i < M - 1; i++){
                graph[idx][i] = graph[idx][i + 1];
            }
            graph[idx][M - 1] = temp;
        }
    }

    static int whichDir(char c){
        if(c == 'L') return 1;
        else return 0;
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