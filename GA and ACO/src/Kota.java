/**
 *
 * @author YovanJong
 */
public class Kota {
    int x;
    int y;
    int kota;
    
    public Kota(int kota, int x, int y){
        this.kota = kota;
        this.x = x;
        this.y = y;
    }
    
    public double jarakKeKota(Kota kota){
        int jarakX = Math.abs(getX() - kota.getX());
        int jarakY = Math.abs(getY() - kota.getY());
        double totalJarak = Math.sqrt((jarakX*jarakX)+(jarakY*jarakY));
        
        return totalJarak;
    }
    
    public int getX(){
        return this.x;
    }

    public int getY(){
        return this.y;
    }
    
    public int getKota(){
        return this.kota;
    }
    @Override
    public String toString(){
        return "Kota " + getKota() + " Koordinat " +getX()+","+getY();
    }
}
