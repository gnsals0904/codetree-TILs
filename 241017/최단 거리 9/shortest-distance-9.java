import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] dist;
    static int[] path;
    static ArrayList<Point>[] graph;
    static PriorityQueue<Element> pq = new PriorityQueue();
    static final int MAX_DIST = 100_000 * 1_000 + 1;
    public static void main(String[] args) throws Exception {
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ir);
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new ArrayList[N + 1];
        dist = new int[N + 1];
        path = new int[N + 1];
        Arrays.fill(dist, MAX_DIST);
        for(int i = 0; i < N + 1; i++){
            graph[i] = new ArrayList<>();
        }
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            graph[from].add(new Point(to, value));
            graph[to].add(new Point(from, value));
        }
        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        pq.add(new Element(a, 0));
        dist[a] = 0;

        while(!pq.isEmpty()){
            int tempIdx = pq.peek().index;
            int tempDist = pq.peek().dist;
            pq.poll();
            if(dist[tempIdx] != tempDist) continue;

            for(int j = 0; j < graph[tempIdx].size(); j++){
                int targetIdx = graph[tempIdx].get(j).to;
                int targetDist = graph[tempIdx].get(j).dist;
                int newDist = tempDist + targetDist;
                if(newDist < dist[targetIdx]){
                    dist[targetIdx] = newDist;
                    path[targetIdx] = tempIdx;
                    pq.add(new Element(targetIdx, newDist));
                }
            }
        }

        StringBuilder result = new StringBuilder();
        result.append(dist[b]).append("\n");
        ArrayList<Integer> tempList = new ArrayList();
        int tempB = b;
        tempList.add(tempB);
        while(tempB != a){
            tempB = path[tempB];
            tempList.add(tempB);
        }
        for(int i = tempList.size() - 1; i >= 0; i--){
            result.append(tempList.get(i)).append(" ");
        }
        result.setLength(result.length() - 1);
        System.out.println(result);
    }

    static class Point{
        int to;
        int dist;

        Point(int to, int dist){
            this.to = to;
            this.dist = dist;
        }

        @Override
        public String toString(){
            return "to : " + this.to + " dist : " + this.dist;
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