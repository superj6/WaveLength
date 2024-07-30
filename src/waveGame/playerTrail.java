
package waveGame;

import java.awt.Color;
import java.awt.Graphics;

public class playerTrail extends gameObject{
    
    private int col1, col2, col3;
    private float vel;
    private handler handler;
    private float width, height, life, sizeChanger;
    long lastTime = System.currentTimeMillis();
    
    
    public playerTrail(float x, float y, int angle, ID id, float vel, float sizeChanger, int col1, int col2, int col3, float width, float height, float life, handler handler) {
        super(x, y, angle, id);
        this.handler = handler;
        this.vel = vel;
        this.col1 = col1;
        this.col2 = col2;
        this.col3 = col3;
        this.width = width;
        this.height = height;
        this.life = life;
        this.sizeChanger = sizeChanger;
    }
   
    
    @Override
    public void tick(){
        x+=velX;
        width-=sizeChanger/100f;
        height-=sizeChanger/100f;
        x+=sizeChanger/100f;
        y+=sizeChanger/100f;
        velX=-vel;
        if(System.currentTimeMillis() - lastTime >= life){
            handler.removeObject(this);
        }else{
            if(col1 < 250){
                col1+=1;
            }    
            if(col2 < 250){
                col2+=1;
            }
            if(col3 < 250){
                col3+=1;
            }
        }
        
    }
    @Override
    public void render(Graphics g){
        g.setColor(new Color(col1,col2,col3));
        shapes.aRectangle(g, x, y, width, height, angle);
    }
    
}
