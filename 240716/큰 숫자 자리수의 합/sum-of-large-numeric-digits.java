import java.util.*;
import java.io.*;

public class Main {
    static int num = 1;
    static int result;
    public static void main(String[] args) throws Exception {
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ir);
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 3; i++){
            num *= Integer.parseInt(st.nextToken());
        }
        result += func(num);
        System.out.println(result);
    }
    
    static int func(int num){
        if(num < 10) return num % 10; 
        return func(num/10) + num % 10;
    }
}