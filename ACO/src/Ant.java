import java.util.ArrayList;
/**
 *
 * @author Henrico, Yovan, Jodi
 * @reference https://www.baeldung.com/java-ant-colony-optimization
 * @reference https://github.com/eugenp/tutorials/tree/master/algorithms-genetic
 */
public class Ant {
    protected int pathSize;
    public int[] path;
    protected boolean[] visited;
    
    public Ant(int pathSize){
        this.pathSize = pathSize;
        this.path = new int[pathSize];
        this.visited = new boolean[pathSize];
    }
    
    public void visitCity(int curIdx, int city){
        path[curIdx+1] = city;
        visited[city] = true;
    }
    
    public boolean visited(int idx){
        return this.visited[idx];
    }
    
    public double totalDistance(double[][] edges){
       double length = edges[pathSize - 1][path[0]];
        for (int i = 0; i < this.pathSize - 1; i++) {
            length += edges[path[i]] [path[i + 1]];
        }
        return length;
    }
    
//    public double calcDistance(City a, City b){
//        int x = Math.abs(a.getPosX() - b.getPosX());
//        int y = Math.abs(a.getPosY()- b.getPosY());
//        return Math.sqrt((x*x) + (y*y));
//    }
    
    public void clear(){
        for(int i =0;i<pathSize;i++){
            visited[i]=false;
        }
    }
}
