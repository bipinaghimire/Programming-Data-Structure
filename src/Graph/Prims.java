package src.Graph;

import java.util.Arrays;

public class Prims {
    public void Prim(int G[][], int V) {

        int num = Integer.MAX_VALUE;
        boolean[] selected = new boolean[V];
    
        // set selected false initially
        Arrays.fill(selected, false);
    
        // the number of egde in minimum spanning tree will be
        // always less than (V -1), where V is number of vertices in
        // graph
        
        int edge = 0;
        // choose 0th vertex and make it true
        selected[0] = true;
    
        while (edge < V - 1) {    
          int min = num;
          int x = 0; 
          int y = 0; 
    
          for (int i = 0; i < V; i++) {
            if (selected[i] == true) {
              for (int j = 0; j < V; j++) {
                // not in selected and there is an edge
                if (!selected[j] && G[i][j] != 0) {
                  if (min > G[i][j]) {
                    min = G[i][j];
                    x = i;
                    y = j;
                  }
                }
              }
            }
          }
          System.out.println(x + " - " + y + " :  " + G[x][y]);
          selected[y] = true;
          edge++;
        }
      }
    
      public static void main(String[] args) {
        Prims g = new Prims();
    
        // number of vertices in graph
        int V = 3;
        int[][] G = { { 0, 9, 75, }, { 9, 0, 95}, { 75, 95, 0} };
        g.Prim(G, V);
      }
}
