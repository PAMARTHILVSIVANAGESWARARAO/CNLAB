import java.util.*;
public class Dijkstra {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of vertices: ");
        int n = sc.nextInt();
        int[][] graph = new int[n][n];
        System.out.println("Enter adjacency matrix (use 0 for no edge):");
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                graph[i][j] = sc.nextInt();

        System.out.print("Enter source vertex (0 to " + (n - 1) + "): ");
        int src = sc.nextInt();

        int[] dist = new int[n];
        boolean[] visited = new boolean[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        for (int i = 0; i < n - 1; i++) {
            int u = minDistance(dist, visited);
            visited[u] = true;
            for (int v = 0; v < n; v++) {
                if (!visited[v] && graph[u][v] != 0 && dist[u] != Integer.MAX_VALUE
                        && dist[u] + graph[u][v] < dist[v])
                    dist[v] = dist[u] + graph[u][v];
            }
        }

        System.out.println("Shortest distances from source " + src + ":");
        for (int i = 0; i < n; i++)
            System.out.println("To " + i + " : " + (dist[i] == Integer.MAX_VALUE ? "∞" : dist[i]));
        sc.close();
    }

    private static int minDistance(int[] dist, boolean[] visited) {
        int min = Integer.MAX_VALUE, minIndex = -1;
        for (int i = 0; i < dist.length; i++)
            if (!visited[i] && dist[i] < min) {
                min = dist[i];
                minIndex = i;
            }
        return minIndex;
    }
}
