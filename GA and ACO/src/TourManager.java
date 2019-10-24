/**
 *
 * @author YovanJong
 */
import java.util.ArrayList;

public class TourManager {
    private static ArrayList kotaTujuan = new ArrayList<Kota>();
    
    public static void addKota(Kota kota){
        kotaTujuan.add(kota);
    }
    
    public static Kota getKota(int index){
        return (Kota) kotaTujuan.get(index);
    }
    
    public static int jumlahKota(){
        return kotaTujuan.size();
    }
}
