import java.util.*;
public class BroadcastTree{
    static final int INF=9999;
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter number of hosts: ");
        int n=sc.nextInt();
        int[][] graph=new int[n][n];
        System.out.println("Enter adjacency matrix (use -1 for no direct link):");
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                int val=sc.nextInt();
                graph[i][j]=(val==-1)?INF:val;
            }
        }
        System.out.print("Enter number of hosts in subnet: ");
        int m=sc.nextInt();
        int[] subnet=new int[m];
        System.out.println("Enter host indices in subnet:");
        for(int i=0;i<m;i++) subnet[i]=sc.nextInt();
        boolean[] visited=new boolean[n];
        int[] key=new int[n];
        int[] parent=new int[n];
        Arrays.fill(key,INF);
        Arrays.fill(parent,-1);
        key[subnet[0]]=0;
        for(int count=0;count<m-1;count++){
            int u=minKey(key,visited,subnet);
            visited[u]=true;
            for(int v:subnet){
                if(graph[u][v]!=INF&&!visited[v]&&graph[u][v]<key[v]){
                    parent[v]=u;
                    key[v]=graph[u][v];
                }
            }
        }
        System.out.println("\nBroadcast Tree (Minimum Spanning Tree):");
        int totalCost=0;
        for(int i=0;i<m;i++){
            int v=subnet[i];
            if(parent[v]!=-1){
                System.out.println(parent[v]+" -> "+v+" (Cost: "+graph[parent[v]][v]+")");
                totalCost+=graph[parent[v]][v];
            }
        }
        System.out.println("Total Cost of Broadcast Tree: "+totalCost);
        sc.close();
    }
    static int minKey(int[] key,boolean[] visited,int[] subnet){
        int min=INF,minIndex=-1;
        for(int v:subnet){
            if(!visited[v]&&key[v]<min){
                min=key[v];
                minIndex=v;
            }
        }
        return minIndex;
    }
}
