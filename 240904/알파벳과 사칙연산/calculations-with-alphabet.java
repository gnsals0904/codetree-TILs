import java.io.*;
import java.util.*;

public class Main {
    // a b c d e f
    static int[] alpha = new int[6];
    static int[] choice = new int[6];
    static int result = Integer.MIN_VALUE;
    static String inputs;
    public static void main(String[] args) throws Exception {
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ir);
        inputs = br.readLine();
        selectNumber(0);
        System.out.println(result);
    }

    static void selectNumber(int depth){
        if(depth == 6){
            result = Math.max(result, calc());
            return;
        }
        for(int i = 1; i <= 4; i++){
            choice[depth] = i;
            selectNumber(depth + 1);
        }
    }

    static int calc(){
        int tempResult = choice[inputs.charAt(0) - 'a'];
        for(int i = 1; i < inputs.length(); i+=2){
            // 기호
            char q = inputs.charAt(i);
            // 알파벳
            char a = inputs.charAt(i+1);
            tempResult = calcAlpha(tempResult, q, a);
        }
        return tempResult;
    }

    static int calcAlpha(int temp, char q, char c){
        int value = c - 'a';
        if(q == '-'){
            return temp - choice[value];
        } else if(q == '+'){
            return temp + choice[value];
        }
        return temp * choice[value]; 
    }

    
}