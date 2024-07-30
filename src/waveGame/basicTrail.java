
package waveGame;

import java.awt.Color;
import java.awt.Graphics;

public class basicTrail extends gameObject{
    
    private int col1, col2, col3;
    private handler handler;
    private float width, height, life, sizeChanger;
   
    long lastTime = System.currentTimeMillis();
    
    
    public basicTrail(int x, int y, int angle, ID id, float sizeChanger, int col1, int col2, int col3, int width, int height, int life, handler handler) {
        super(x, y, angle, id);
        this.handler = handler;
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
        
        width-=sizeChanger/100f;
        height-=sizeChanger/100f;
        x+=sizeChanger/100f;
        y+=sizeChanger/100f;
        
        
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
