
package waveGame;

import java.awt.Graphics;

public class shapes {
    public static void aRectangle(Graphics g, float x, float y, float width, float height, int angle){
         
        
        
        float r = (float) (Math.sqrt(Math.pow((width/2), 2)+Math.pow((height/2), 2))),
        theta = (float) ((Math.acos(height/(2*r)))*180/Math.PI),        
        ax = (float) (-(r*(Math.cos(theta*Math.PI/180)+Math.cos((angle-theta)*Math.PI/180)))+height),        
        ay = (float) (r*(Math.sin(theta*Math.PI/180)+Math.sin((angle-theta)*Math.PI/180)));   
        
        
        
        xyRectangle(g, x+ax, y+ay, width, height, angle);
    }
    public static void xyRectangle(Graphics g, float x, float y, float width, float height, int angle){
        int xpoints[] = {(int)x,(int)(x+(0*Math.cos(angle*Math.PI/180)+height*Math.sin(angle*Math.PI/180))),(int)(x+(width*Math.cos(angle*Math.PI/180)+height*Math.sin(angle*Math.PI/180))),(int)(x+(width*Math.cos(angle*Math.PI/180)+0*Math.sin(angle*Math.PI/180)))};
        
        int ypoints[] = {(int)y,(int)(y+(height*Math.cos(angle*Math.PI/180)-0*Math.sin(angle*Math.PI/180))),(int)(y+(height*Math.cos(angle*Math.PI/180)-width*Math.sin(angle*Math.PI/180))),(int)(y+(0*Math.cos(angle*Math.PI/180)-width*Math.sin(angle*Math.PI/180)))};
        
        
        g.fillPolygon(xpoints, ypoints, 4);  
        
    }
    public static void pointRectangle(Graphics g, float x, float y, float width, float height, float rotateRadius, int radAngle, int angle){
        float r = (float) (Math.sqrt(Math.pow((width/2), 2)+Math.pow((height/2), 2))),
        theta = (float) ((Math.acos(height/(2*r)))*180/Math.PI),           
        bx = (float) ((rotateRadius)*(Math.cos(theta*Math.PI/180)+Math.cos((radAngle)*Math.PI/180))-rotateRadius/1.5f),        
        by = (float) (-(rotateRadius)*(Math.sin(theta*Math.PI/180)+Math.sin((radAngle)*Math.PI/180))+rotateRadius/1.5f); 
        
        
        aRectangle(g, bx+x, by+y, width, height, angle);
        
    }
    public static void arc(Graphics g, float x, float y, float radius, int arcAngle, int angle){
         
        g.fillArc((int)(x), (int)(y), (int)radius*2, (int)radius*2, angle+90, arcAngle);
    }
    public static void pointArc(Graphics g, float x, float y, float radius, float rotateRadius, int radAngle,  int arcAngle, int angle){
        
               
        float bx = (float) ((rotateRadius)*(Math.cos((radAngle)*Math.PI/180))),        
        by = (float) (-(rotateRadius)*(Math.sin((radAngle)*Math.PI/180))); 
        
        arc(g, bx+x, by+y, radius, arcAngle, angle);
    }
    
}
