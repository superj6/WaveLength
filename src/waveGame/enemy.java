
package waveGame;

import java.awt.Color;
import java.awt.Graphics;
import static waveGame.spawner.aheight;
import static waveGame.spawner.pos;
import static waveGame.spawner.wavelength;

public class enemy extends gameObject{
    long timer = System.currentTimeMillis();
    private handler handler;
    
    public float aheight, wavelength, position, pos;
    public enemy(float x, float y, int angle,float vel, ID id, float aheight, float wavelength, float position, handler handler) {
        super(x, y, angle, id);
        this.handler = handler;
        
        this.position = position;
        this.aheight=aheight;
        this.wavelength=wavelength;
        
        pos=position; 
        
        this.velX=-vel;
        this.width=32;
        this.height=32;
        
        
    }
    public void tick(){
        x+=velX;
        y+=velY;
        
        pos+=1;
        if(x<-width){
            handler.removeObject(this);
        }
       
        
        handler.addObject(new circleTrail(x, (float)(y+(aheight*(Math.cos(((2*Math.PI)/wavelength)*pos)))), angle, ID.player, 20, 255, 150, 0, 16, 360, 150, handler));
    }
    
    
    public void render(Graphics g){
        
        g.setColor(new Color(255,150,0));
        shapes.arc(g, x, (float)(y+(aheight*(Math.cos(((2*Math.PI)/wavelength)*pos)))), 16, 360, 0);
        
    }
}
