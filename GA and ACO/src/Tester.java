/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author YovanJong
 */
public class Tester {
    public static void main(String[] args) {
        Kota city = new Kota(60, 200);
        TourManager.addKota(city);
        Kota city2 = new Kota(180, 200);
        TourManager.addKota(city2);
        Kota city3 = new Kota(80, 180);
        TourManager.addKota(city3);
        Kota city4 = new Kota(140, 180);
        TourManager.addKota(city4);
        Kota city5 = new Kota(20, 160);
        TourManager.addKota(city5);
        Kota city6 = new Kota(100, 160);
        TourManager.addKota(city6);
        Kota city7 = new Kota(200, 160);
        TourManager.addKota(city7);
        Kota city8 = new Kota(140, 140);
        TourManager.addKota(city8);
        Kota city9 = new Kota(40, 120);
        TourManager.addKota(city9);
        Kota city10 = new Kota(100, 120);
        TourManager.addKota(city10);
        Kota city11 = new Kota(180, 100);
        TourManager.addKota(city11);
        Kota city12 = new Kota(60, 80);
        TourManager.addKota(city12);
        Kota city13 = new Kota(120, 80);
        TourManager.addKota(city13);
        Kota city14 = new Kota(180, 60);
        TourManager.addKota(city14);
        Kota city15 = new Kota(20, 40);
        TourManager.addKota(city15);
        Kota city16 = new Kota(100, 40);
        TourManager.addKota(city16);
        Kota city17 = new Kota(200, 40);
        TourManager.addKota(city17);
        Kota city18 = new Kota(20, 20);
        TourManager.addKota(city18);
        Kota city19 = new Kota(60, 20);
        TourManager.addKota(city19);
        Kota city20 = new Kota(160, 20);
        TourManager.addKota(city20);

        // Initialize population
        Population pop = new Population(50, true);
        System.out.println("Initial distance: " + pop.getFittest().getDistance());

        // Evolve population for 100 generations
        pop = GeneticAlgorithm.evolvePopulation(pop);
        for (int i = 0; i < 100; i++) {
            pop = GeneticAlgorithm.evolvePopulation(pop);
        }

        // Print final results
        System.out.println("Finished");
        System.out.println("Final distance: " + pop.getFittest().getDistance());
        System.out.println("Solution:");
        System.out.println(pop.getFittest());
    }
    
}
