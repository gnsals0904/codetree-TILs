import java.util.*;
import java.io.*;

// L <-
// R ->
// D delet
// P & insert
public class Main {
    static int N;
    static int M;
    public static void main(String[] args) throws Exception {
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ir);
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        LinkedList<Character> list = new LinkedList<>();
        String input = br.readLine();
        for(int i = 0; i < N; i++){
            list.add(input.charAt(i));
        }
        StringBuilder sb = new StringBuilder();
        ListIterator<Character> it = list.listIterator(list.size());
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            char order = st.nextToken().charAt(0);
            // P & insert
            if(order == 'L') {
                if (it.hasPrevious()) it.previous();
            }
            else if(order == 'R') {
                if (it.hasNext()) it.next();
            }
            else if(order == 'D') {
                it.remove();
            }
            else if(order == 'P') {
                it.add(st.nextToken().charAt(0));
                if(it.hasNext()) it.next();
            }
        }
        it = list.listIterator();
        while (it.hasNext()) {
            sb.append(it.next());
        }
        System.out.println(sb);
    }
}