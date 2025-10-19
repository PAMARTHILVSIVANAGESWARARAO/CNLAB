
import java.util.*;
public class Dijkstra {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter No of Vertices :");
        int n = sc.nextInt();
        sc.nextLine(); 
        char[] arr = new char[n];
        Map<Character, Integer> vertexMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            System.out.println("Enter the name of Vertex " + i + ":");
            arr[i] = sc.next().charAt(0);
            vertexMap.put(arr[i], i);
        }
        List<int[]> edges = new ArrayList<>();
        System.out.println("Enter the number of edges:");
        int e = sc.nextInt();
        sc.nextLine();  
        for (int i = 0; i < e; i++) {
            System.out.print("Enter edge (e.g., a -> b): ");
            String edge = sc.nextLine();
            String[] parts = edge.split("->");
            if (parts.length != 2) {
                System.out.println("Invalid input format. Use 'a -> b'.");
                return;
            }
            char u = parts[0].trim().charAt(0); 
            char v = parts[1].trim().charAt(0); 
            if (!vertexMap.containsKey(u) || !vertexMap.containsKey(v)) {
                System.out.println("Invalid vertices. Ensure they are within the vertex list.");
                return;
            }
            System.out.print("Enter the weight for edge " + u + " -> " + v + ": ");
            int w = sc.nextInt();
            sc.nextLine();
            if (w < 0) {
                System.out.println("Negative weights are not allowed in Dijkstra's algorithm.");
                return;
            }
            edges.add(new int[]{vertexMap.get(u), vertexMap.get(v), w});
        }
        if (n <= 0) {
            System.out.println("Number of vertices must be positive.");
            return;
        }
        int[] dist = new int[n];  
        boolean[] visited = new boolean[n];  
        int[] prev = new int[n];  
        Arrays.fill(dist, Integer.MAX_VALUE);
        Arrays.fill(visited, false);
        Arrays.fill(prev, -1);
        System.out.print("Enter the source vertex (e.g., a): ");
        char sourceChar = sc.next().charAt(0);
        int src = vertexMap.get(sourceChar);
        dist[src] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.add(new int[]{src, 0});
        List<List<int[]>> adj = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adj.get(edge[0]).add(new int[]{edge[1], edge[2]});
        }
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int u = curr[0];
            int d = curr[1];
            if (visited[u]) continue;
            visited[u] = true;
            for (int[] neighbor : adj.get(u)) {
                int v = neighbor[0];
                int w = neighbor[1];
                if (dist[v] > dist[u] + w) {
                    dist[v] = dist[u] + w;
                    prev[v] = u;
                    pq.add(new int[]{v, dist[v]});
                }
            }
        }
        System.out.print("Enter the destination vertex (e.g., b): ");
        char destChar = sc.next().charAt(0);
        int dest = vertexMap.get(destChar);
         if (dist[dest] == Integer.MAX_VALUE) {
            System.out.println("Destination " + destChar + " is unreachable from " + sourceChar);
        } else {
            System.out.println("Shortest path from " + sourceChar + " to " + destChar + ":");
            List<Character> path = new ArrayList<>();
            int current = dest;
            while (current != -1) {
                path.add(arr[current]);
                current = prev[current];
            }
            Collections.reverse(path);
            for (char c : path) {
                System.out.print(c + " ");
            }
            System.out.println();
            System.out.println("Total cost: " + dist[dest]);  
        }
    }
    
}

