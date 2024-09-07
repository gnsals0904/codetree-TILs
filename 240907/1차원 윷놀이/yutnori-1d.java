import java.io.*;
import java.util.*;


public class Main {
    static int N, M, K;
    static int[] numbers;
    static int[] horses;
    static int score;
    static ArrayList<Integer> whoGo = new ArrayList();
    public static void main(String[] args) throws Exception {
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ir);
        StringTokenizer st= new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        numbers = new int[N];
        horses = new int[K];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        dfs(0);
        System.out.println(score);
    }

    static void dfs(int depth){
        if(depth == N){
            score = Math.max(score, calc());
            resetHorses();
            return;
        }
        for(int i = 0; i < K; i++){
            whoGo.add(i);
            dfs(depth + 1);
            whoGo.remove(whoGo.size() - 1);
        }
    }

    static int calc(){
        int tempScore = 0;
        for(int i = 0; i < N; i++){
            horses[whoGo.get(i)] += numbers[i];
        }
        for(int i = 0; i < K; i++){
            if(horses[i] >= M - 1){
                tempScore++;
            }
        }
        return tempScore;
    }

    static void resetHorses(){
        Arrays.fill(horses, 0);
    }
}