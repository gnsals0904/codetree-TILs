import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static final int MAX_DIST = 1_000 * 100_000 + 1;
    static ArrayList<Node>[] graph;
    static int[] dist;
    static PriorityQueue<Element> pq = new PriorityQueue();
    public static void main(String[] args) throws Exception{
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ir);
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        dist = new int[N + 1];
        Arrays.fill(dist, MAX_DIST);
        graph = new ArrayList[N + 1];
        for(int i = 0; i < N + 1; i++){
            graph[i] = new ArrayList();
        }
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            graph[from].add(new Node(to, weight));
            graph[to].add(new Node(from, weight));
        }
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        pq.add(new Element(start, 0));
        dist[start] = 0;
        while(!pq.isEmpty()){
            int tempIdx = pq.peek().index;
            int tempDist = pq.peek().dist;
            pq.poll();
            for(int j = 0; j < graph[tempIdx].size(); j++){
                int targetIdx = graph[tempIdx].get(j).index;
                int targetDist = graph[tempIdx].get(j).dist;
                int newDist = tempDist + targetDist;
                if(dist[targetIdx] > newDist){
                    pq.add(new Element(targetIdx, newDist));
                    dist[targetIdx] = newDist;
                }
            }
        }
        System.out.println(dist[end]);
    }

    static class Node{
        int index;
        int dist;
        Node(int index, int dist){
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