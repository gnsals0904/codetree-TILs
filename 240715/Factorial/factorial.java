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
    static int func(int depth){
        if(depth == 1) return 1;
        return depth * func(depth - 1);
    }
}