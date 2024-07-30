
package waveGame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;


public class HUD {
    
    public static int score = 0;
    private long timer = System.currentTimeMillis();
    public static String level = "Radio Wave";
    int greenval = 200;
    public static boolean scorechanger = true;
    public void tick(){
        if(System.currentTimeMillis()-timer>2100){
            timer+=2100;
            if(scorechanger){
                score+=1;
            }
        }
    }
    public void render(Graphics g){
        
        g.setColor(new Color( (int)game.col2, (int)game.col3, (int)game.col1));
        Font fnt3 = new Font("arial", 1, 20);
        Font fnt2 = new Font("arial", 1, 40);
        g.setFont(fnt3);
        
        g.drawString("score: " + score, 400, 25);
        g.drawString("level: " + level, 400, 45);
        
        
    }
    
}
