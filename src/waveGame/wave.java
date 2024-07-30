
package waveGame;

import java.awt.Color;
import java.awt.Graphics;


public class wave extends gameObject{
    long timer = System.currentTimeMillis();
    private handler handler;
    
    public float pheight, position;
    public wave(float x, float y,float vel, int angle, ID id, float pheight, float position, handler handler) {
        super(x, y, angle, id);
        this.handler = handler;
        this.pheight = pheight;
        this.position = position;
        
        handler.addObject(new waveII(x,y+(game.HEIGHT)-(game.HEIGHT/2-pheight+position), vel, angle,id, pheight, position,handler));
        this.height = (game.HEIGHT/2)-pheight-position;
        this.velX=-vel;
        this.width = 2+Math.abs(velX);
        
        
        
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
        shapes.aRectangle(g, x, y, 2+Math.abs(velX), (game.HEIGHT/2)-pheight-position,angle);
        
        
        
    }
    
}
