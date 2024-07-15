import java.util.*;
import java.io.*;

public class Main {
    static int N;
    public static void main(String[] args) throws Exception {
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ir);
        N = Integer.parseInt(br.readLine());
        System.out.print(func(N));
    }
    
    static int func(int depth){
        if(depth <= 2){
            return depth;
        }
        return depth + func(depth - 2);
    }
}