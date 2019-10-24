/**
 *
 * @author YovanJong
 */
public class Population {
    Tour[] tours;
    
    public Population(int populationsSize, boolean initialise){
        tours = new Tour[populationsSize];
        if(initialise){
            for(int i=0;i<tours.length;i++){
                Tour newTour = new Tour();
                newTour.generateIndividual();
                tours[i] = newTour;
            }
        }
    }
    
    public Tour getFittest(){
        Tour fittest = tours[0];
        for(int i=1;i<tours.length;i++){
            if(fittest.getFitness()<=getTour(i).getFitness()){
                fittest = getTour(i);
            }
        }
        return fittest;
    }
    
    public int populationSize(){
        return tours.length;
    }
    
    public void saveTour(int index, Tour tour){
        tours[index] = tour;
    }
    
    public Tour getTour(int index){
        return tours[index];
    }
}
