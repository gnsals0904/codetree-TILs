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
        for(int i = 0; i < N - 1; i++){
            int n = func(nums[i], nums[i + 1]);
            nums[i + 1] = n;
        }
        System.out.println(nums[N-1]);
    }

    static int func(int nowN, int nextN){
        return nowN * nextN / getGCD(nowN, nextN);
    }

    public static int getGCD(int num1, int num2) {
        if (num1 % num2 == 0) {
            return num2;
        }
        return getGCD(num2, num1%num2);
    }
}