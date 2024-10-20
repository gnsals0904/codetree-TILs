import java.util.Scanner;

public class Main {    
    public static final int MAX_N = 1000;
    
    // 변수 선언
    public static int n, m;
    public static int a, b;
    public static int[][] graph = new int[MAX_N + 1][MAX_N + 1];
    public static boolean[] visited = new boolean[MAX_N + 1];
    
    public static int[] dist = new int[MAX_N + 1];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 입력
        n = sc.nextInt();
        m = sc.nextInt();

        // 그래프를 인접행렬로 표현
        // 양방향 그래프이므로 양쪽 다 표시해줍니다.
        while(m-- > 0) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int z = sc.nextInt();

            graph[x][y] = z;
            graph[y][x] = z;
        }

        a = sc.nextInt();
        b = sc.nextInt();
        
        // 그래프에 있는 모든 노드들에 대해
        // 초기값을 전부 아주 큰 값으로 설정
        // INT_MAX 그 자체로 설정하면
        // 후에 덧셈 진행시 overflow가 발생할 수도 있으므로
        // 적당히 큰 숫자로 적어줘야함에 유의!
        for(int i = 1; i <= n; i++)
            dist[i] = (int)1e9;

        // 시작위치에는 dist값을 0으로 설정
        dist[b] = 0;

        // O(|V|^2) 다익스트라 코드
        for(int i = 1; i <= n; i++) {
            // V개의 정점 중 
            // 아직 방문하지 않은 정점 중
            // dist값이 가장 작은 정점을 찾아줍니다.
            int minIndex = -1;
            for(int j = 1; j <= n; j++) {
                if(visited[j])
                    continue;
                
                if(minIndex == -1 || dist[minIndex] > dist[j])
                    minIndex = j;
            }

            // 최솟값에 해당하는 정점에 방문 표시를 진행합니다.
            visited[minIndex] = true;

            // 최솟값에 해당하는 정점에 연결된 간선들을 보며
            // 시작점으로부터의 최단거리 값을 갱신해줍니다.
            for(int j = 1; j <= n; j++) {
                // 간선이 존재하지 않는 경우에는 넘어갑니다.
                if(graph[minIndex][j] == 0)
                    continue;

                if(dist[j] > dist[minIndex] + graph[minIndex][j])
                    dist[j] = dist[minIndex] + graph[minIndex][j];
            }
        }

        // 정점 B에서 정점 A로 가기 위한 최단거리를 출력합니다.
        System.out.println(dist[a]);

        // 도착지 A에서 시작하여
        // 시작점 B가 나오기 전까지
        // 최단거리를 만족하는 경로 중
        // 가장 간선 번호가 작은 곳으로 이동합니다.
        int x = a;
        System.out.print(x + " ");
        while(x != b) {
            for(int i = 1; i <= n; i++) {
                // 간선이 존재하지 않는 경우에는 넘어갑니다.
                if(graph[i][x] == 0)
                    continue;
                
                // 만약 b -> ... -> i -> x ... -> a로 
                // 실제 최단거리가 나올 수 있는 상황이었다면
                // i를 작은 번호부터 보고 있으므로
                // 바로 선택해줍니다.
                if(dist[i] + graph[i][x] == dist[x]) {
                    x = i;
                    break;
                }
            }
            System.out.print(x + " ");
        }
    }
}