
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author henrico
 */
public class AntColonyOptimization {
    private double c = 1.0;
    private double alpha = 1;
    private double beta = 5;
    private double evaporation = 0.5;
    private double Q = 500;
    private double antFactor = 0.8;
    private double randomFactor = 0.01;

    private int maxIterations = 1000;

    private int nCities;
    private int nAnts;
    private ArrayList<City> graph;
    private ArrayList<City> trails;
    private ArrayList<Ant> ants;
    private Random random;
    private double probabilities[];

    private int curIdx;

    private int[] bestTourOrder;
    private double bestTourLength;
    
    
    public AntColonyOptimization(int nCities){
        this.nCities = nCities;
        this.nAnts = (int)(nCities * antFactor);
        this.graph = new ArrayList<City>();
        this.trails = new ArrayList<City>();
        this.ants = new ArrayList<Ant>();
        this.random = new Random();
        this.curIdx = 0;
        for(int i=0;i<nAnts;i++){
            ants.add(new Ant(nCities));
        }
    }
    
    
    public void insertCity(City city){
        this.graph.add(city);
    }
    
    public void startAntOptimization() {
        for(int i =0;i<3;i++){
            System.out.println("Attempt #" + i);
//            solve();
        }
    }
    
//    public int[] solve() {
//        setupAnts();
//        clearTrails();
//        IntStream.range(0, maxIterations)
//            .forEach(i -> {
//                moveAnts();
//                updateTrails();
//                updateBest();
//            });
//        System.out.println("Best tour length: " + (bestTourLength - nCities));
//        System.out.println("Best tour order: " + Arrays.toString(bestTourOrder));
//        return bestTourOrder.clone();
//    }
    
    private void setupAnts() {
        for(int i =0;i<nAnts;i++){
            ants.get(i).clear();
            ants.get(i).visitCity(-1, random.nextInt(nCities));
        } 
    }
    
    private void moveAnts() {
        for(int i = 1;i<nCities;i++){
            for(int j=1;j<nAnts;j++){
                ants.get(i).visitCity(curIdx, selectNextCity(ants.get(i)) );
            }
            curIdx++;
        }
    }
    
    private int selectNextCity(Ant ant){
        return 0;
    }

   

 
}
