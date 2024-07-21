import java.util.*;
import java.io.*;

public class Main {
    static LinkedList<Integer> list = new LinkedList<>();
    static int N;
    public static void main(String[] args) throws Exception {
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ir);
        N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            String input = st.nextToken();
            switch(input){
                case "push_front":
                    list.addFirst(Integer.parseInt(st.nextToken()));
                    break;
                case "push_back":
                    list.addLast(Integer.parseInt(st.nextToken()));
                    break;
                case "pop_front":
                    sb.append(list.pollFirst()).append("\n");
                    break;
                case "pop_back":
                    sb.append(list.pollLast()).append("\n");
                    break;
                case "size":
                    sb.append(list.size()).append("\n");
                    break;
                case "empty":
                    if(list.isEmpty()) sb.append(1).append("\n");
                    else sb.append(0).append("\n");
                    break;
                case "front":
                    sb.append(list.peekFirst()).append("\n");
                    break;
                case "back":
                    sb.append(list.peekLast()).append("\n");
                    break;
            }
        }
        System.out.println(sb);
    }
}