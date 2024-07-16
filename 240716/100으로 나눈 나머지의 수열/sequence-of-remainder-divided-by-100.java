import java.io.*;
import java.util.*;

public class Main {
    static int N;
    public static void main(String[] args) throws Exception {
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ir);
        N = Integer.parseInt(br.readLine());
        System.out.println(func(N));
    }

    static int func(int k){
        if(k == 1) return 2;
        if(k == 2) return 4;
        return (func(k - 1) * func(k - 2)) % 100;
    }
}