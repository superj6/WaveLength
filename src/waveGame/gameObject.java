
package waveGame;

import java.awt.Graphics;

public abstract class gameObject {
    protected float x, y;
    protected int angle;
    protected ID id;
    protected float velX, velY, width, height;
    
    public gameObject(float x, float y, int angle, ID id){
        this.x = x;
        this.y = y;
        this.id = id;
        this.angle = angle;
    }
    public abstract void tick();
    public abstract void render(Graphics g);
    public float getX(){
        return x;
    }public float getY(){
        return y;
    }public int getAngle(){
        return angle;
    }public ID getId(){
        return id;
    }public float getWidth(){
        return width;
    }public float getHeight(){
        return height;
    }public float getVelX(){
        return velX;
    }public float getVelY(){
        return velY;
    }public void setX(float x){
        this.x=x;
    }public void setY(float y){
        this.y=y;
    }public void setAngle(int a){
        this.angle=a;
    }public void setId(ID id){
        this.id=id;
    }public void setVelX(float velX){
        this.velX=velX;
    }public void setVelY(float velY){
        this.velY=velY;
    }
}
