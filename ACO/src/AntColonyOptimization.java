
import java.util.ArrayList;
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

    private int currentIndex;

    private int[] bestTourOrder;
    private double bestTourLength;
    
    
    public AntColonyOptimization(int nCities){
        this.nCities = nCities;
        this.nAnts = (int)(nCities * antFactor);
        this.graph = new ArrayList<City>();
        this.trails = new ArrayList<City>();
        this.ants = new ArrayList<Ant>();
        this.random = new Random();
        for(int i=0;i<nAnts;i++){
            ants.add(new Ant(nCities));
        }
    }
    
    
    public void insertCity(City city){
        this.graph.add(city);
    }
    
    
    

}
