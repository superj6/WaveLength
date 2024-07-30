
package waveGame;

import java.awt.Graphics;
import java.util.LinkedList;

public class handler {
    LinkedList<gameObject> object = new LinkedList<gameObject>();
    
    public void tick(){
        for(int i = 0; object.size() > i;i++){
            gameObject tempobject = object.get(i);
            tempobject.tick();
        }
    }
    public void render(Graphics g){
        for(int i = 0; object.size() > i;i++){
            gameObject tempobject = object.get(i);
            tempobject.render(g);
        }
    }
    public void clearEnemies(){
        try{
            for(int i = 0; i < object.size();i++){
                gameObject tempobject = object.get(i);
                if(tempobject.getId()==ID.player){
                    object.clear();
                    object.add(new player(tempobject.getX(), tempobject.getY(),tempobject.getAngle(), ID.player, this));
                }else if(i == object.size()-1){
                    object.clear();
                } 
            }
        }catch(Exception a){
            a.printStackTrace();
        }
    }
    public void addObject(gameObject object){
        this.object.add(object);
    }
    public void removeObject(gameObject object){
        this.object.remove(object);
    }
}
