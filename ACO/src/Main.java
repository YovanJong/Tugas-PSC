
import java.util.Scanner;
/**
 *
 * @author Henrico, Yovan, Jodi
 * @reference https://www.baeldung.com/java-ant-colony-optimization
 * @reference https://github.com/eugenp/tutorials/tree/master/algorithms-genetic
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        AntColonyOptimization aco = new AntColonyOptimization(n);
        for(int i =0;i<n;i++){
            aco.insertCity(new City(sc.nextInt(), sc.nextInt(), sc.nextInt()));
        }
        aco.startAntOptimization();
    }
}
