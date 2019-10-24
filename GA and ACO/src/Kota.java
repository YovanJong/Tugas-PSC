/**
 *
 * @author YovanJong
 */
public class Kota {
    int x;
    int y;
    
    public Kota(){
        this.x = (int) (Math.random()*200);
        this.y = (int) (Math.random()*200);
    }
    
    public Kota(int x, int y){
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
    
    @Override
    public String toString(){
        return getX()+","+getY();
    }
}
