import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int[] nums;
    public static void main(String[] args) throws Exception {
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ir);
        N = Integer.parseInt(br.readLine());
        nums = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println(func(N - 1));
    }

    static int func(int depth){
        if(depth == 0) return nums[0];
        return Math.max(func(depth - 1), nums[depth]);
    }
}