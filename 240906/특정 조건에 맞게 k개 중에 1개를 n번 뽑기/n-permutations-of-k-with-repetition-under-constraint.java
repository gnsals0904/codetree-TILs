import java.io.*;
import java.util.*;

public class Main {
    static int K, N;
    static ArrayList<Integer> list = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ir);
        StringTokenizer st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        dfs(0, 0, 0);
        System.out.print(sb);
    }

    static void dfs(int prev, int count, int depth){
        if(depth == N){
            saveNums();
            sb.append("\n");
            return;
        }
        for(int i = 1; i <= K; i++){
            list.add(i);
            if(i == prev){
                if(count < 2){
                    dfs(i, count + 1, depth + 1);
                }
            }
            else{
                dfs(i, 1, depth + 1);
            }
            list.remove(list.size() - 1);
        }
    }

    static void saveNums(){
        for(int num : list){
            sb.append(num).append(" ");
        }
        sb.setLength(sb.length() - 1);
    }
}