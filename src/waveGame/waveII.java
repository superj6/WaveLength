
package waveGame;

import java.awt.Color;
import java.awt.Graphics;


public class waveII extends gameObject{
    long timer = System.currentTimeMillis();
    private handler handler;
    
    public float pheight, position;
    public waveII(float x, float y, float vel, int angle, ID id, float pheight, float position, handler handler) {
        super(x, y, angle, id);
        this.handler = handler;
        this.pheight = pheight;
        this.position = position;
        
        this.velX=-vel;
        this.width = 2+Math.abs(velX);
        this.height = (float)(game.HEIGHT/2)-pheight+position;
        
    }
    public void tick(){
        x+=velX;
        y+=velY;
        
        
        if(x<-pheight){
            handler.removeObject(this);
        }
       
        
        
    }
    
    
    public void render(Graphics g){
        g.setColor(Color.BLACK);
        
        
        shapes.aRectangle(g, x, y,Math.abs(velX)+2, (float)(game.HEIGHT/2)-pheight+position,angle);
        
    }
}
