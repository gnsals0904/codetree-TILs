import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static ArrayList<Point>[] graph;
    static PriorityQueue<Element> pq = new PriorityQueue<>();
    static int[] dist;
    static final int MAX_DIST = 100_000 * 1_000 + 1;
    static int result = Integer.MIN_VALUE;
    public static void main(String[] args) throws Exception {
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ir);
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new ArrayList[N + 1];
        dist = new int[N + 1];
        for(int i = 0; i < N + 1; i++){
            graph[i] = new ArrayList<>();
        }
        Arrays.fill(dist, MAX_DIST);
        dist[N] = 0;
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int distance = Integer.parseInt(st.nextToken());
            graph[to].add(new Point(from, distance));
        }
        pq.add(new Element(N, 0));

        // dijkstra
        while(!pq.isEmpty()){
            Element tempE = pq.poll();
            int minDist = tempE.dist;
            int minIndex = tempE.index;
            if(minDist != dist[minIndex])
                continue;
            
            for(int j = 0; j < graph[minIndex].size(); j++){
                int targetIndex = graph[minIndex].get(j).index;
                int targetDist = graph[minIndex].get(j).dist;
                
                int newDist = dist[minIndex] + targetDist;
                if(dist[targetIndex] > newDist){
                    dist[targetIndex] = newDist;
                    pq.add(new Element(targetIndex, newDist));
                }
            }
        }

        for(int i = 0; i < N; i++){
            if(dist[i] != MAX_DIST){
                result = Math.max(result, dist[i]);
            }
        }
        // System.out.println(Arrays.toString(dist));
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



    static class Element implements Comparable<Element> {
        int index;
        int dist;

        Element(int index, int dist){
            this.dist = dist;
            this.index = index;
        }

        @Override
        public int compareTo(Element e){
            return this.dist - e.dist;
        }
    }
}