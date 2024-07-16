import java.util.*;
import java.io.*;

public class Main {
    static int N;
    public static void main(String[] args) throws Exception {
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ir);
        N = Integer.parseInt(br.readLine());
        System.out.println(func(N));
    }

    static int func(int n){
        if(n <= 2 ) return n;
        return func(n/3) + func(n-1);
    }
}