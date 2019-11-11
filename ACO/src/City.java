/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author henrico
 */
public class City {
    private int posX;
    private int posY;
    
    public City(int posX, int posY){
        this.posX = posX;
        this.posY = posY;
    }
    
    public int getPosX(){
        return this.posX;
    }
    
    public int getPosY(){
        return this.posY;
    }
    
    public void setPosX(int posX){
        this.posX = posX;
    }
    
    public void setPosY(int posY){
        this.posY = posY;
    }
}
