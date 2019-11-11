
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author henrico
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        AntColonyOptimization aco = new AntColonyOptimization(n);
        for(int i =0;i<n;i++){
            aco.insertCity(new City(sc.nextInt(), sc.nextInt(), sc.nextInt()));
        }
    }
}
