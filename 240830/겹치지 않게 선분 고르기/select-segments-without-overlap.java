import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static Line[] lines;
    static boolean[] choice;
    static boolean[] isUsed = new boolean[1001];
    static int result = 0;
    public static void main(String[] args) throws Exception {
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ir);
        N = Integer.parseInt(br.readLine());
        lines = new Line[N];
        choice = new boolean[N];
        StringTokenizer st;
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            lines[i] = new Line(x1, x2);
        }
        dfs(0);
        System.out.println(result);
    }

    static void dfs(int depth){
        if(depth == N){
            int count = 0;
            for(int j = 0; j < N; j++){
                if(choice[j]){
                    if(useLine(lines[j].x1, lines[j].x2)) 
                        count++;
                    else{
                        result = Math.max(result, count);
                        resetLine();
                        return;
                    }
                }
            }
            result = Math.max(result, count);
            resetLine();
            return;
        }
        choice[depth] = false;
        dfs(depth + 1);

        choice[depth] = true;
        dfs(depth + 1);
    }

    static boolean useLine(int x1, int x2){
        for(int i = x1; i <= x2; i++){
            if(isUsed[i]) return false;
            isUsed[i] = true;
        }
        return true;
    }

    static void resetLine(){
        for(int i = 0; i < 1001; i++){
            isUsed[i] = false;
        }
    }

    static class Line{
        int x1;
        int x2;
        Line(int x1, int x2){
            this.x1 = x1;
            this.x2 = x2;
        }
    }
}