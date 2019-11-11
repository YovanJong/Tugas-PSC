
import java.util.Scanner;

/**
 *
 * @author Yovan, Henrico, Jodi
 * @reference http://www.theprojectspot.com/tutorial-post/applying-a-genetic-algorithm-to-the-travelling-salesman-problem/5
 */
public class Tester {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int i;
        for(i=0;i<n;i++){
            TourManager.addKota(new Kota(sc.nextInt(), sc.nextInt(), sc.nextInt()));
        }

        // Initialize population
        Population pop = new Population(50, true);
        System.out.println("Initial distance: " + pop.getFittest().getDistance());
        // Evolve population for 100 generations
        pop = GeneticAlgorithm.evolvePopulation(pop, n);
        for ( i = 0; i < 100; i++) {
            pop = GeneticAlgorithm.evolvePopulation(pop, n);
        }

        // Print final results
        System.out.println("Finished");
        System.out.println("Final distance: " + pop.getFittest().getDistance());
        System.out.println("Solution:");
        System.out.println(pop.getFittest());
    }
    
}
