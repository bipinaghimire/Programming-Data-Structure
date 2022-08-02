import java.util.HashSet;
import java.util.PriorityQueue;


public class PriorityQueueDemo {
    public int minCostConnectPoints(int[][] points) {

        //First we create min heap
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((o1, o2) -> (o1[2] - o2[2]));
        // for storing cost
        int cost = 0;
        
        pq.offer(new int[] {0, 0, 0});
        
        HashSet<Integer> visit = new HashSet<Integer>();
        int size = points.length-1;
        
        while(visit.size()<=size && !pq.isEmpty()){
            
            int[] curr = pq.poll();
            int end = curr[1];
            int costP = curr[2];
            
            if(visit.contains(end))continue;
            
            cost+=costP;
            visit.add(end);
            
            for(int i=0;i<=size;i++)
            {
                if(!visit.contains(i)){
                    pq.offer(new int[]{end,i,distance(points,end,i)});
                }
            }
        }
        return cost;
    }
    public int distance(int[][] points, int i, int j) {
        return Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
    }

    
}

// you are provided coordinates of houses in 2D map and write an algorithm that will print
// optimal path to construct a road connecting all houses with minimum cost. cost between 
// two coordinates is the Manhattan distance between them.

// public class Question3 {
//     class Node{
//         int x, y;
//         int dist;
//         Node(int x, int y, int dist){
//             this.x=x;
//             this.y=y;
//             this.dist=dist;
//         }
//     }

//     // to update the distance of the node from the start node
//     public void updateDistance(Node[] nodes, int index, boolean[] visited){
//         int x=nodes[index].x;
//         int y=nodes[index].y;
//         for(int i=0;i<nodes.length;i++){
//             if(!visited[i]){
//                 int newDist=Math.abs(nodes[i].x-x)+Math.abs(nodes[i].y-y);
//                 nodes[i].dist=Math.min(nodes[i].dist, newDist);
//             }
//         }
//     }

//     // finding the minimum distance node from the unvisited nodes
//     public int findNextNode(Node[] nodes, boolean[] visited){
//         int min=Integer.MAX_VALUE;
//         int ans=-1;
//         for(int i=0;i<nodes.length;i++){
//             if(nodes[i].dist<min && !visited[i]){
//                 min=nodes[i].dist;
//                 ans=i;
//             }
//         }
//         return ans;
//     }
// // to find the minimum distance node from the start node
//     public int minCost(int[][] points) {
//         boolean[] visited=new boolean[points.length];
//         Node[] nodes=new Node[points.length];
//         int ans=0;
//         for(int i=0;i<points.length;i++){
//             int[] point=points[i];
//             nodes[i]=new Node(point[0], point[1], Integer.MAX_VALUE);
//         }
//         nodes[0].dist=0;
        
//         int numNodes=points.length;
//         while(numNodes>0){
//             numNodes--;
//             int minIndex=findNextNode(nodes, visited);
//             ans+=nodes[minIndex].dist;
//             visited[minIndex]=true;
//             updateDistance(nodes, minIndex, visited);
//         }
//         return ans;
//     }
//     public static void main(String[] args) {
//         Question3 q=new Question3();
//         int[][] points={{0,0},{2,2},{3,10},{4,4},{5,2},{7,0}};
//         System.out.println(q.minCost(points));
//     }

// }


