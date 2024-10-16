import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static ArrayList<Point>[] graph;
    static PriorityQueue<Element> pq = new PriorityQueue<>();
    static int[] dist;
    static final int MAX_DIST = 1000 * 11;
    public static void main(String[] args) throws Exception {
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ir);
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        dist = new int[N + 1];
        Arrays.fill(dist, MAX_DIST);
        graph = new ArrayList[N + 1];
        for(int i = 0; i < N + 1; i++){
            graph[i] = new ArrayList<>();
        }
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            graph[from].add(new Point(to, value));
        }
        pq.add(new Element(1, 0));
        dist[1] = 0;

        while(!pq.isEmpty()){
            int minDist = pq.peek().dist;
            int minIndex = pq.peek().index;
            pq.poll();
            
            if(minDist != dist[minIndex]) continue;

            for(int j = 0; j < graph[minIndex].size(); j++){
                int targetIndex = graph[minIndex].get(j).to;
                int targetDist = graph[minIndex].get(j).distance;
                int newDist = dist[minIndex] + targetDist;
                if(dist[targetIndex] > newDist){
                    dist[targetIndex] = newDist;
                    pq.add(new Element(targetIndex, newDist));
                }
            }
        }

        StringBuilder result = new StringBuilder();
        for(int i = 2; i < N + 1; i++){
            if(dist[i] == MAX_DIST){
                result.append(-1).append("\n");
                continue;
            }
            result.append(dist[i]).append("\n");
        }
        System.out.println(result);
    }

    static class Point{
        int to;
        int distance;

        Point(int to, int distance){
            this.to = to;
            this.distance = distance;
        }

        @Override
        public String toString(){
            return "to : " + this.to + " distance : " + this.distance;
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

    static void showGraph(){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N + 1; i++){
            sb.append(graph[i].toString()).append("\n");
        }
        System.out.println(sb);
    }
}