
package waveGame;

import java.awt.Color;
import java.awt.Graphics;

public class circleTrail extends gameObject{
    private int col1, col2, col3, arcAngle;
    
    private handler handler;
    private float radius, life, sizeChanger;
    long lastTime = System.currentTimeMillis();
    
    
    public circleTrail(float x, float y, int angle, ID id, float sizeChanger, int col1, int col2, int col3, float radius, int arcAngle, float life, handler handler) {
        super(x, y, angle, id);
        this.handler = handler;
        
        this.col1 = col1;
        this.col2 = col2;
        this.col3 = col3;
        this.radius=radius;
        this.arcAngle=arcAngle;
        this.life = life;
        this.sizeChanger = sizeChanger;
    }
   
    
    @Override
    public void tick(){
        x+=velX;
        radius-=sizeChanger/50f;
        
        x+=sizeChanger/50f;
        y+=sizeChanger/50f;
        
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
        shapes.arc(g, x, y, radius, arcAngle, angle);
    }
    
}
