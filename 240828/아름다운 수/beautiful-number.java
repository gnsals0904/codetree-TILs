import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static ArrayList<Integer> nums = new ArrayList<>();
    static int result = 0;
    public static void main(String[] args) throws Exception {
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ir);
        N = Integer.parseInt(br.readLine());
        dfs(0);
        System.out.println(result);
    }

    static void dfs(int depth){
        if(depth == N){
            if(isBeautiful()) {
                result++;
            }
            return;
        }
        for(int i = 1; i <= 4; i++){
            nums.add(i);
            dfs(depth + 1);
            nums.remove(depth);
        }
    }
    
    static boolean isBeautiful(){
        int count = 1;
        int prev = nums.get(0);
        for(int i = 1; i < N; i++){
            int nowNumber = nums.get(i);
            if(prev != nowNumber){
                if(count % prev != 0) {
                    return false;
                }
                else count = 1;
            }
            else{
                count++;
            }
            prev = nowNumber;
        }
        if(count % prev != 0) return false;
        return true;
    }

    static void show(){
        StringBuilder sb = new StringBuilder();
        for(int i : nums){
            sb.append(i);
        }
        sb.append("\n");
        System.out.print(sb);
    }
}