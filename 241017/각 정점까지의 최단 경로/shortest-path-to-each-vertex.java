import java.io.*;
import java.util.*;

public class Main {
    static int N, M, K;
    static ArrayList<Point>[] graph;
    static int[] dist;
    static final int MAX_DISTANCE = 300_010 * 10;
    static PriorityQueue<Element> pq = new PriorityQueue<>();
    public static void main(String[] args) throws Exception {
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ir);
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(br.readLine());
        graph = new ArrayList[N + 1];
        dist = new int[N + 1];
        for(int i = 0; i < N + 1; i++){
            graph[i] = new ArrayList();
        }
        Arrays.fill(dist, MAX_DISTANCE);
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());
            graph[from].add(new Point(to, dist));
            graph[to].add(new Point(from, dist));
        }
        dist[K] = 0;
        pq.add(new Element(K, 0));

        while(!pq.isEmpty()){
            int tIdx = pq.peek().index;
            int tDist = pq.peek().dist;
            pq.poll();

            if(tDist != dist[tIdx]) continue;

            int tSize = graph[tIdx].size();
            for(int i = 0; i < tSize; i++){
                int targetIdx = graph[tIdx].get(i).index;
                int targetDist = graph[tIdx].get(i).dist;
                int newDist = targetDist + tDist;

                if(newDist < dist[targetIdx]){
                    dist[targetIdx] = newDist;
                    pq.add(new Element(targetIdx, newDist));
                }
            }
        }

        StringBuilder result = new StringBuilder();
        for(int i = 1; i < N + 1; i++){
            if(dist[i] == MAX_DISTANCE){
                result.append(-1).append("\n");
                continue;
            }
            result.append(dist[i]).append("\n");
        }
        System.out.println(result);
    }

    static class Point{
        int index;
        int dist;

        Point(int index, int dist){
            this.index = index;
            this.dist = dist;
        }
    }

    static class Element implements Comparable<Element>{
        int index;
        int dist;

        Element(int index, int dist){
            this.index = index;
            this.dist = dist;
        }

        @Override
        public int compareTo(Element e){
            return this.dist - e.dist;
        }

    }
}