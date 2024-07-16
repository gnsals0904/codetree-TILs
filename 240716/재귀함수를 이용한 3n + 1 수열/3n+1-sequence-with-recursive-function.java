import java.util.*;
import java.io.*;

public class Main{
    static int N;
    public static void main(String[] args) throws Exception {
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ir);
        N = Integer.parseInt(br.readLine());
        System.out.print(func(N));
    }

    static int func(int n){
        if(n == 1) return 0;
        if(n % 2 == 0) return func(n / 2) + 1;
        else return func(n * 3 + 1) + 1;
    }
}