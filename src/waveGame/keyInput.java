
package waveGame;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class keyInput extends KeyAdapter{
    private boolean[] keydown = new boolean[4];
    private handler handler;
    private game game;
    public static float speed = 2;
    public keyInput(handler handler, game game){
        this.handler = handler; 
        this.game = game;
        
        keydown[0]=false;
        keydown[1]=false;
        keydown[2]=false;
        keydown[3]=false;
    }
    
    @Override
    public void keyPressed(KeyEvent e){
        int key = e.getKeyCode(); 
        
            for(int i = 0; handler.object.size() > i; i++){
                gameObject tempobject = handler.object.get(i);

                if(tempobject.getId() == ID.player){
                    //key events for player
                    if(key == KeyEvent.VK_UP){

                        tempobject.setVelY(-speed);
                        keydown[0] = true;

                    }
                    
                    if(key == KeyEvent.VK_DOWN){

                        tempobject.setVelY(speed);
                        keydown[2] = true;
                    }
                    
                }
            }
            
            
        
        
    }
    @Override
    public void keyReleased(KeyEvent e){
        int key = e.getKeyCode(); 
        for(int i = 0; handler.object.size() > i; i++){
            gameObject tempobject = handler.object.get(i);
            
            if(tempobject.getId() == ID.player){
                //stop key events for player
                if(key == KeyEvent.VK_UP){
                    keydown[0] = false;
                }
                
                if(key == KeyEvent.VK_DOWN){
                    keydown[2] = false;
                }
                
                if(!keydown[0] && !keydown[2]){
                    tempobject.setVelY(0);
                }
                
            }
            
            if(key == KeyEvent.VK_ESCAPE)System.exit(0);
            
        }    
    }
}

