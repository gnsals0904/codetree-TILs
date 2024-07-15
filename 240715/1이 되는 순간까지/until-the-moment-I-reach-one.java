import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int result;
    public static void main(String[] args) throws Exception {
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ir);
        N = Integer.parseInt(br.readLine());
        recur(0);
        System.out.println(result);
    }

    static void recur(int depth){
        if(N == 1){
            result = depth;
            return;
        }
        if(N % 2 == 0){
            N = N / 2;
        }
        else{
            N = N / 3;
        }
        recur(depth + 1);
    }
}