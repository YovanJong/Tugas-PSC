
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author henrico
 */
public class Ant {
    protected int pathSize;
    protected int[] path;
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
    
    public double totalDistance(ArrayList<City> city){
        double distance = 0;
        int i;
        for(i=1;i<pathSize;i++){
            distance+= calcDistance(city.get(path[i]), city.get(path[i-1]));
        }
        return distance;
    }
    
    public double calcDistance(City a, City b){
        int x = Math.abs(a.getPosX() - b.getPosX());
        int y = Math.abs(a.getPosY()- b.getPosY());
        return Math.sqrt((x*x) + (y*y));
    }
    
    public void clear(){
        for(int i =0;i<pathSize;i++){
            visited[i]=false;
        }
    }
}
