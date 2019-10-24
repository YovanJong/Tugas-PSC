/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author YovanJong
 */
public class GeneticAlgorithm {
    private static final double mutationRate = 0.015;
    private static final int tournamentSize = 5;
    private static final boolean elitism = true;
    
    public static Population evolvePopulation(Population pop){
        Population newPopulation = new Population(pop.populationSize(),false);
        
        int elitismOffset = 0;
        if(elitism){
            newPopulation.saveTour(0, pop.getFittest());
            elitismOffset = 1;
        }
        
        for(int i=elitismOffset;i<newPopulation.populationSize();i++){
            Tour parent1 = tournamentSelection(pop);
            Tour parent2 = tournamentSelection(pop);
            Tour child = crossover(parent1,parent2);
            newPopulation.saveTour(i,child);
        }
        
        for(int i=elitismOffset;i<newPopulation.populationSize();i++){
            mutate(newPopulation.getTour(i));
        }
        
        return newPopulation;
    }
    
    public static Tour crossover(Tour parent1,Tour parent2){
        Tour child = new Tour();
        int startPos = (int) (Math.random()*parent1.tourSize());
        int endPos = (int)(Math.random()*parent1.tourSize());
        
        for(int i=0;i<child.tourSize();i++){
            if(startPos<endPos && i>startPos && i<endPos){
                child.setKota(i, parent1.getCity(i));
            }
            else if(startPos>endPos){
                if(!(i<startPos && i>endPos)){
                    child.setKota(i,parent1.getCity(i));
                }
            }
        }
        
        for(int i=0;i<parent2.tourSize();i++){
            if(!child.containsCity(parent2.getCity(i))){
                for(int j=0;j<child.tourSize();j++){
                    if(child.getCity(j)==null){
                        child.setKota(j, parent2.getCity(i));
                        break;
                    }
                }
            }
        }
        
        return child;
    }
    
    private static void mutate(Tour tour){
        for(int tourPos1=0;tourPos1<tour.tourSize();tourPos1++){
            if(Math.random()<mutationRate){
                int tourPos2 = (int) (tour.tourSize()*Math.random());
                
                Kota kota1 = tour.getCity(tourPos1);
                Kota kota2 = tour.getCity(tourPos2);
                
                tour.setKota(tourPos2, kota1);
                tour.setKota(tourPos1, kota2);
            }
        }
    }
    
    private static Tour tournamentSelection(Population pop){
        Population tournament = new Population(tournamentSize, false);
        for(int i=0;i<tournamentSize;i++){
            int randomId = (int) (Math.random()*pop.populationSize());
            tournament.saveTour(i, pop.getTour(randomId));
        }
        Tour fittest = tournament.getFittest();
        return fittest;
    }
}
