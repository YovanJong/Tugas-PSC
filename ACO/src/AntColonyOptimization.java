
import java.util.ArrayList;
import java.util.Arrays;
import java.util.OptionalInt;
import java.util.Random;
import java.util.stream.IntStream;

/**
 *
 * @author Henrico, Yovan, Jodi
 * @reference https://www.baeldung.com/java-ant-colony-optimization
 * @reference https://github.com/eugenp/tutorials/tree/master/algorithms-genetic
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
    private int curIdx;
    
    private double[] probabilities;
    private double[][] edges;
    private double[][] path;
    private ArrayList<City> cities;
    private ArrayList<Ant> ants;
    
    private Random random;
    
    private int[] bestTourOrder;
    private double bestTourLength;
    
    public AntColonyOptimization(int nCities){
        this.nCities = nCities;
        this.nAnts = (int)(nCities * antFactor);
        this.edges = new double[nCities][nCities];
        this.path = new double[nCities][nCities];
        this.ants = new ArrayList<Ant>();
        this.cities = new ArrayList<City>();
        this.random = new Random();
        this.curIdx = 0;
        //Init all ants
        for(int i=0;i<nAnts;i++){
            ants.add(new Ant(nCities));
        }
        //Init all edges
        generateEdges();
    }
    
    public void generateEdges(){
        int i, j;
        for(i=0;i<nCities;i++){
            for(j=0;j<nCities;j++){
                double x = Math.abs(cities.get(i).getPosX() - cities.get(j).getPosX());
                double y = Math.abs(cities.get(i).getPosX() - cities.get(j).getPosY());
                edges[i][j]= Math.sqrt((x*x)+(y*y));
            }
        }
    }
    
    public void insertCity(City city){
        this.cities.add(city);
    }
    
    public void startAntOptimization() {
        for(int i =0;i<3;i++){
            System.out.println("Attempt #" + i);
            solve();
        }
    }
    
    public int[] solve() {
        setupAnts();
        clear();
        IntStream.range(0, maxIterations)
            .forEach(i -> {
                moveAnts();
                updatePath();
                updateBest();
            });
        System.out.println("Best tour length: " + (bestTourLength - nCities));
        System.out.println("Best tour order: " + Arrays.toString(bestTourOrder));
        return bestTourOrder.clone();
    }
    
    private void setupAnts() {
        for(int i =0;i<nAnts;i++){
            ants.get(i).clear();
            ants.get(i).visitCity(-1, random.nextInt(nCities));
        } 
    }
    
    private void moveAnts() {
        IntStream.range(curIdx, this.nCities - 1)
                .forEach(i -> {
                    ants.forEach(Semut -> Semut.visitCity(curIdx, selectNextCity(Semut)));
                    curIdx++;
                });
    }
    
    private int selectNextCity(Ant ant){
        int t = random.nextInt(this.nCities - curIdx);
        if (random.nextDouble() < this.randomFactor) {
            OptionalInt cityIndex = IntStream.range(0, this.nCities)
                    .filter(i -> i == t && !ant.visited(i))
                    .findFirst();
            if (cityIndex.isPresent()) {
                return cityIndex.getAsInt();
            }
        }
        hitungKemungkinan(ant);
        double r = random.nextDouble();
        double total = 0;
        for (int i = 0; i < this.nCities; i++) {
            total += probabilities[i];
            if (total >= r) {
                return i;
            }
        }
        throw new RuntimeException("No More City");
    }

    private void hitungKemungkinan(Ant ant) {
        int tmp = ant.path[curIdx];
        double pheromone=0;
        for(int i=0;i<this.nCities;i++){
            if(!ant.visited(i)){
                pheromone += Math.pow(path[tmp][i], alpha) * Math.pow(1.0/edges[tmp][i], beta);
            }
        }
        for(int i=0;i<this.nCities;i++){
            if(ant.visited(i)){
                probabilities[i] = 0.0;
            }
            else{
                probabilities[i]= (Math.pow(path[tmp][i], alpha) * Math.pow(1.0/edges[tmp][i], beta))/pheromone;
            }
        }
    }    

    private void updatePath(){
        int i, j;
        for(i=0;i<this.nCities;i++){
            for(j=0;j<this.nCities;j++){
                path[i][j]*=evaporation;
            }
        }
        for(i =0;i<nAnts;i++){
            double contribution = Q / ants.get(i).totalDistance(edges);
            for(j=0;j<nCities-1;j++){
                path[ants.get(i).path[j]][ants.get(i).path[j]]+=contribution;
            }
            path[ants.get(i).path[nCities-1]][ants.get(i).path[0]] +=contribution;
        }
    }
    
    
    private void updateBest(){
        int i;
        for(i=0;i<nAnts;i++){
            if(ants.get(i).totalDistance(edges)>bestTourLength){
                this.bestTourLength = ants.get(i).totalDistance(edges);
                this.bestTourOrder = ants.get(i).path;
            }
        }
    }
    
    private void clear(){
        IntStream.range(0, this.nCities)
            .forEach(i -> {
                IntStream.range(0, this.nCities)
                .forEach(j -> path[i][j] = c);
            });
    }
   

 
}
