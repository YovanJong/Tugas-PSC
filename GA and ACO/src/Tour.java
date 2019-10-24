/**
 *
 * @author YovanJong
 */
import java.util.ArrayList;
import java.util.Collections;

public class Tour {
    private ArrayList tour = new ArrayList<Kota>();
    private double fitness = 0;
    private int distance = 0;
    
    public Tour(){
        for(int i=0;i<TourManager.jumlahKota();i++){
            tour.add(null);
        }
    }
    
    public Tour(ArrayList tour){
        this.tour = tour;
    }
    
    public void generateIndividual(){
        for(int i=0;i<TourManager.jumlahKota();i++){
            setKota(i,TourManager.getKota(i));
        }
        Collections.shuffle(tour);
    }
    
    public Kota getCity(int tourPosition){
        return (Kota) tour.get(tourPosition);
    }
    
    public void setKota(int tourPosition, Kota kota){
        tour.set(tourPosition, kota);
        fitness = 0;
        distance = 0;
    }
    
    public double getFitness(){
        if(fitness == 0){
            fitness = 1/(double)getDistance();
        }
        return fitness;
    }
    
    public int getDistance(){
        if(distance == 0){
            int tourDistance = 0;
            for(int i=0;i<tour.size();i++){
                Kota kotaAsal = getCity(i);
                Kota kotaTujuan;
                if(i+1<tour.size()){
                    kotaTujuan = getCity(i+1);
                }
                else{
                    kotaTujuan = getCity(0);
                }
                tourDistance += kotaAsal.jarakKeKota(kotaTujuan);
            }
            distance = tourDistance;
        }
        return distance;
    }
    
    public int tourSize(){
        return tour.size();
    }
    
    public boolean containsCity(Kota kota){
        return tour.contains(kota);
    }
    
    @Override
    public String toString() {
        String geneString = "|";
        for (int i = 0; i < tourSize(); i++) {
            if(i==tourSize()-1){
                geneString += getCity(i)+"|";
            }
            else{
                geneString += getCity(i)+"| |";
            }
        }
        return geneString;
    }
}
