import java.util.*;
public class DistanceVectorRouting{
    static final int INF=9999;
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter number of nodes: ");
        int n=sc.nextInt();
        int[][] graph=new int[n][n];
        System.out.println("Enter adjacency matrix (use -1 for no direct link):");
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                int val=sc.nextInt();
                graph[i][j]=(val==-1)?INF:val;
            }
        }
        int[][] cost=new int[n][n];
        int[][] nextHop=new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                cost[i][j]=graph[i][j];
                if(graph[i][j]!=INF&&i!=j) nextHop[i][j]=j;
                else nextHop[i][j]=-1;
            }
            cost[i][i]=0;
            nextHop[i][i]=i;
        }
        boolean updated;
        do{
            updated=false;
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    for(int k=0;k<n;k++){
                        if(cost[i][k]!=INF&&cost[k][j]!=INF&&cost[i][k]+cost[k][j]<cost[i][j]){
                            cost[i][j]=cost[i][k]+cost[k][j];
                            nextHop[i][j]=nextHop[i][k];
                            updated=true;
                        }
                    }
                }
            }
        }while(updated);
        System.out.println("\nRouting tables for all nodes:");
        for(int node=0;node<n;node++){
            printRoutingTable(node,cost,nextHop,n);
        }
        System.out.print("\nEnter source node: ");
        int src=sc.nextInt();
        if(src<0||src>=n){
            System.out.println("Invalid source node.");
            sc.close();
            return;
        }
        System.out.print("Enter destination node: ");
        int dest=sc.nextInt();
        if(dest<0||dest>=n){
            System.out.println("Invalid destination node.");
            sc.close();
            return;
        }
        if(cost[src][dest]==INF){
            System.out.println("No path exists from "+src+" to "+dest);
        }else{
            System.out.print("Path from node "+src+" to node "+dest+": ");
            printPath(src,dest,nextHop);
            System.out.println();
        }
        sc.close();
    }
    static void printPath(int src,int dest,int[][] nextHop){
        System.out.print(src);
        while(src!=dest){
            src=nextHop[src][dest];
            System.out.print(" -> "+src);
        }
    }
    static void printRoutingTable(int node,int[][] cost,int[][] nextHop,int n){
        System.out.println("\nRouting table for node "+node+":");
        System.out.println("Destination\tCost\tNext Hop");
        for(int j=0;j<n;j++){
            if(cost[node][j]==INF) System.out.println(j+"\t\tINF\t-");
            else System.out.println(j+"\t\t"+cost[node][j]+"\t"+nextHop[node][j]);
        }
    }
}
