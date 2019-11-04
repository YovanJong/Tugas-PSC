/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Yovan, Henrico, Jodi
 * @reference http://www.theprojectspot.com/tutorial-post/applying-a-genetic-algorithm-to-the-travelling-salesman-problem/5
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
