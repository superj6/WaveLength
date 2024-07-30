
package waveGame;

import java.awt.Color;
import java.awt.Graphics;

public class player extends gameObject{
    long timer = System.currentTimeMillis();
    private handler handler;
    
    
    public player(float x, float y, int angle, ID id, handler handler) {
        super(x, y, angle, id);
        this.handler = handler;
        
        this.width = 16;
        this.height = 16; 
    }
    public void tick(){
        x+=velX;
        y+=velY;
        
        y =  game.clamp(y,32,game.HEIGHT-80);
        
        angle+=1;
        
        if(angle>=360){
            angle = 0;
            
        }
        collision();
        handler.addObject(new playerTrail(x, y, angle, ID.player, keyInput.speed*1.3f+velX+spawner.vel-1, 20, 255, 0, 0, 16, 16, 350, handler));
    }
    private void collision(){
        for(int i = 0; i < handler.object.size(); i++){
            gameObject tempobject = handler.object.get(i);
            
        }
            
         
       
        
    }
    private boolean rectCollision(gameObject tempobject){
        float r1 = (float) (Math.sqrt(Math.pow((width/2), 2)+Math.pow((height/2), 2))),
                theta1 = (float) ((Math.acos(height/(2*r1)))*180/Math.PI),        
                ax1 = (float) (-(r1*(Math.cos(theta1*Math.PI/180)+Math.cos((angle-theta1)*Math.PI/180)))+height),        
                ay1 = (float) (r1*(Math.sin(theta1*Math.PI/180)+Math.sin((angle-theta1)*Math.PI/180))); 
                
                float r2 = (float) (Math.sqrt(Math.pow((tempobject.getWidth()/2), 2)+Math.pow((tempobject.getHeight()/2), 2))),
                theta2 = (float) ((Math.acos(tempobject.getHeight()/(2*r2)))*180/Math.PI),        
                ax2 = (float) (-(r2*(Math.cos(theta2*Math.PI/180)+Math.cos((tempobject.getAngle()-theta2)*Math.PI/180)))+tempobject.getHeight()),        
                ay2 = (float) (r2*(Math.sin(theta2*Math.PI/180)+Math.sin((tempobject.getAngle()-theta2)*Math.PI/180))); 

                int a_x1 = (int)(x+ax1),
                a_x2 = (int)((x+(0*Math.cos(angle*Math.PI/180)+height*Math.sin(angle*Math.PI/180)))+ax1),
                a_x3 = (int)((x+(width*Math.cos(angle*Math.PI/180)+height*Math.sin(angle*Math.PI/180)))+ax1),
                a_x4 = (int)((x+(width*Math.cos(angle*Math.PI/180)+0*Math.sin(angle*Math.PI/180)))+ax1),
                        
                a_y1 = (int)(y+ay1),
                a_y2 = (int)((y+(height*Math.cos(angle*Math.PI/180)-0*Math.sin(angle*Math.PI/180)))+ay1),
                a_y3 = (int)((y+(height*Math.cos(angle*Math.PI/180)-width*Math.sin(angle*Math.PI/180)))+ay1),
                a_y4 = (int)((y+(0*Math.cos(angle*Math.PI/180)-width*Math.sin(angle*Math.PI/180)))+ay1),
                                        
                b_x1 = (int)(tempobject.getX()+ax2),
                b_x2 = (int)((tempobject.getX()+(0*Math.cos(tempobject.getAngle()*Math.PI/180)+tempobject.getHeight()*Math.sin(tempobject.getAngle()*Math.PI/180)))+ax2),
                b_x3 = (int)((tempobject.getX()+(tempobject.getWidth()*Math.cos(tempobject.getAngle()*Math.PI/180)+tempobject.getHeight()*Math.sin(tempobject.getAngle()*Math.PI/180)))+ax2),
                b_x4 = (int)((tempobject.getX()+(0*Math.cos(tempobject.getAngle()*Math.PI/180)-tempobject.getWidth()*Math.sin(tempobject.getAngle()*Math.PI/180)))+ax2),
                                  
                b_y1 = (int)(tempobject.getY()+ay2),
                b_y2 = (int)((tempobject.getY()+(tempobject.getHeight()*Math.cos(tempobject.getAngle()*Math.PI/180)-0*Math.sin(tempobject.getAngle()*Math.PI/180)))+ay2),
                b_y3 = (int)((tempobject.getY()+(tempobject.getHeight()*Math.cos(tempobject.getAngle()*Math.PI/180)-tempobject.getWidth()*Math.sin(tempobject.getAngle()*Math.PI/180)))+ay2),
                b_y4 = (int)((tempobject.getY()+(0*Math.cos(tempobject.getAngle()*Math.PI/180)-tempobject.getWidth()*Math.sin(tempobject.getAngle()*Math.PI/180)))+ay2);
;
                
                int axis1X = a_x2-a_x1,
                axis1Y = a_y2-a_y1;
                
                        
                
                
                
                int aScalar11 = (int)( (((a_x1*axis1X + a_y1*axis1Y)/(Math.abs(Math.pow(axis1X,2)+Math.pow(axis1Y,2))))*axis1X)*axis1X  +  (((a_x1*axis1X + a_y1*axis1Y)/(Math.abs(Math.pow(axis1X,2)+Math.pow(axis1Y,2))))*axis1Y)*axis1Y ),
                aScalar21 = (int)( (((a_x2*axis1X + a_y2*axis1Y)/(Math.abs(Math.pow(axis1X,2)+Math.pow(axis1Y,2))))*axis1X)*axis1X  +  (((a_x2*axis1X + a_y2*axis1Y)/(Math.abs(Math.pow(axis1X,2)+Math.pow(axis1Y,2))))*axis1Y)*axis1Y ),
                aScalar31 = (int)( (((a_x3*axis1X + a_y3*axis1Y)/(Math.abs(Math.pow(axis1X,2)+Math.pow(axis1Y,2))))*axis1X)*axis1X  +  (((a_x3*axis1X + a_y3*axis1Y)/(Math.abs(Math.pow(axis1X,2)+Math.pow(axis1Y,2))))*axis1Y)*axis1Y ),
                aScalar41 = (int)( (((a_x4*axis1X + a_y4*axis1Y)/(Math.abs(Math.pow(axis1X,2)+Math.pow(axis1Y,2))))*axis1X)*axis1X  +  (((a_x4*axis1X + a_y4*axis1Y)/(Math.abs(Math.pow(axis1X,2)+Math.pow(axis1Y,2))))*axis1Y)*axis1Y ),
                
                bScalar11 = (int)( (((b_x1*axis1X + b_y1*axis1Y)/(Math.abs(Math.pow(axis1X,2)+Math.pow(axis1Y,2))))*axis1X)*axis1X  +  (((b_x1*axis1X + b_y1*axis1Y)/(Math.abs(Math.pow(axis1X,2)+Math.pow(axis1Y,2))))*axis1Y)*axis1Y ),
                bScalar21 = (int)( (((b_x2*axis1X + b_y2*axis1Y)/(Math.abs(Math.pow(axis1X,2)+Math.pow(axis1Y,2))))*axis1X)*axis1X  +  (((b_x2*axis1X + b_y2*axis1Y)/(Math.abs(Math.pow(axis1X,2)+Math.pow(axis1Y,2))))*axis1Y)*axis1Y ),
                bScalar31 = (int)( (((b_x3*axis1X + b_y3*axis1Y)/(Math.abs(Math.pow(axis1X,2)+Math.pow(axis1Y,2))))*axis1X)*axis1X  +  (((b_x3*axis1X + b_y3*axis1Y)/(Math.abs(Math.pow(axis1X,2)+Math.pow(axis1Y,2))))*axis1Y)*axis1Y ),
                bScalar41 = (int)( (((b_x4*axis1X + b_y4*axis1Y)/(Math.abs(Math.pow(axis1X,2)+Math.pow(axis1Y,2))))*axis1X)*axis1X  +  (((b_x4*axis1X + b_y4*axis1Y)/(Math.abs(Math.pow(axis1X,2)+Math.pow(axis1Y,2))))*axis1Y)*axis1Y );
                
                
                if(max(aScalar11, aScalar21, aScalar31, aScalar41)>=min(bScalar11, bScalar21, bScalar31, bScalar41)  && max(bScalar11, bScalar21, bScalar31, bScalar41)>=min(aScalar11, aScalar21, aScalar31, aScalar41)){
                    
                    int axis2X = a_x2-a_y3,
                    axis2Y = a_y2-a_y3;
                    
                    int aScalar12 = (int)( (((a_x1*axis2X + a_y1*axis2Y)/(Math.abs(Math.pow(axis2X,2)+Math.pow(axis2Y,2))))*axis2X)*axis2X  +  (((a_x1*axis2X + a_y1*axis2Y)/(Math.abs(Math.pow(axis2X,2)+Math.pow(axis2Y,2))))*axis2Y)*axis2Y ),
                    aScalar22 = (int)( (((a_x2*axis2X + a_y2*axis2Y)/(Math.abs(Math.pow(axis2X,2)+Math.pow(axis2Y,2))))*axis2X)*axis2X  +  (((a_x2*axis2X + a_y2*axis2Y)/(Math.abs(Math.pow(axis2X,2)+Math.pow(axis2Y,2))))*axis2Y)*axis2Y ),
                    aScalar32 = (int)( (((a_x3*axis2X + a_y3*axis2Y)/(Math.abs(Math.pow(axis2X,2)+Math.pow(axis2Y,2))))*axis2X)*axis2X  +  (((a_x3*axis2X + a_y3*axis2Y)/(Math.abs(Math.pow(axis2X,2)+Math.pow(axis2Y,2))))*axis2Y)*axis2Y ),
                    aScalar42 = (int)( (((a_x4*axis2X + a_y4*axis2Y)/(Math.abs(Math.pow(axis2X,2)+Math.pow(axis2Y,2))))*axis2X)*axis2X  +  (((a_x4*axis2X + a_y4*axis2Y)/(Math.abs(Math.pow(axis2X,2)+Math.pow(axis2Y,2))))*axis2Y)*axis2Y ),

                    bScalar12 = (int)( (((b_x1*axis2X + b_y1*axis2Y)/(Math.abs(Math.pow(axis2X,2)+Math.pow(axis2Y,2))))*axis2X)*axis2X  +  (((b_x1*axis2X + b_y1*axis2Y)/(Math.abs(Math.pow(axis2X,2)+Math.pow(axis2Y,2))))*axis2Y)*axis2Y ),
                    bScalar22 = (int)( (((b_x2*axis2X + b_y2*axis2Y)/(Math.abs(Math.pow(axis2X,2)+Math.pow(axis2Y,2))))*axis2X)*axis2X  +  (((b_x2*axis2X + b_y2*axis2Y)/(Math.abs(Math.pow(axis2X,2)+Math.pow(axis2Y,2))))*axis2Y)*axis2Y ),
                    bScalar32 = (int)( (((b_x3*axis2X + b_y3*axis2Y)/(Math.abs(Math.pow(axis2X,2)+Math.pow(axis2Y,2))))*axis2X)*axis2X  +  (((b_x3*axis2X + b_y3*axis2Y)/(Math.abs(Math.pow(axis2X,2)+Math.pow(axis2Y,2))))*axis2Y)*axis2Y ),
                    bScalar42 = (int)( (((b_x4*axis2X + b_y4*axis2Y)/(Math.abs(Math.pow(axis2X,2)+Math.pow(axis2Y,2))))*axis2X)*axis2X  +  (((b_x4*axis2X + b_y4*axis2Y)/(Math.abs(Math.pow(axis2X,2)+Math.pow(axis2Y,2))))*axis2Y)*axis2Y );
                    
                    if(max(aScalar12, aScalar22, aScalar32, aScalar42)>=min(bScalar12, bScalar22, bScalar32, bScalar42)  && max(bScalar12, bScalar22, bScalar32, bScalar42)>=min(aScalar12, aScalar22, aScalar32, aScalar42)){
                        
                        int axis3X = b_x2-b_x1,
                        axis3Y = b_y2-b_y1;
                        
                        int aScalar13 = (int)( (((a_x1*axis3X + a_y1*axis3Y)/(Math.abs(Math.pow(axis3X,2)+Math.pow(axis3Y,2))))*axis3X)*axis3X  +  (((a_x1*axis3X + a_y1*axis3Y)/(Math.abs(Math.pow(axis3X,2)+Math.pow(axis3Y,2))))*axis3Y)*axis3Y ),
                        aScalar23 = (int)( (((a_x2*axis3X + a_y2*axis3Y)/(Math.abs(Math.pow(axis3X,2)+Math.pow(axis3Y,2))))*axis3X)*axis3X  +  (((a_x2*axis3X + a_y2*axis3Y)/(Math.abs(Math.pow(axis3X,2)+Math.pow(axis3Y,2))))*axis3Y)*axis3Y ),
                        aScalar33 = (int)( (((a_x3*axis3X + a_y3*axis3Y)/(Math.abs(Math.pow(axis3X,2)+Math.pow(axis3Y,2))))*axis3X)*axis3X  +  (((a_x3*axis3X + a_y3*axis3Y)/(Math.abs(Math.pow(axis3X,2)+Math.pow(axis3Y,2))))*axis3Y)*axis3Y ),
                        aScalar43 = (int)( (((a_x4*axis3X + a_y4*axis3Y)/(Math.abs(Math.pow(axis3X,2)+Math.pow(axis3Y,2))))*axis3X)*axis3X  +  (((a_x4*axis3X + a_y4*axis3Y)/(Math.abs(Math.pow(axis3X,2)+Math.pow(axis3Y,2))))*axis3Y)*axis3Y ),

                        bScalar13 = (int)( (((b_x1*axis3X + b_y1*axis3Y)/(Math.abs(Math.pow(axis3X,2)+Math.pow(axis3Y,2))))*axis3X)*axis3X  +  (((b_x1*axis3X + b_y1*axis3Y)/(Math.abs(Math.pow(axis3X,2)+Math.pow(axis3Y,2))))*axis3Y)*axis3Y ),
                        bScalar23 = (int)( (((b_x2*axis3X + b_y2*axis3Y)/(Math.abs(Math.pow(axis3X,2)+Math.pow(axis3Y,2))))*axis3X)*axis3X  +  (((b_x2*axis3X + b_y2*axis3Y)/(Math.abs(Math.pow(axis3X,2)+Math.pow(axis3Y,2))))*axis3Y)*axis3Y ),
                        bScalar33 = (int)( (((b_x3*axis3X + b_y3*axis3Y)/(Math.abs(Math.pow(axis3X,2)+Math.pow(axis3Y,2))))*axis3X)*axis3X  +  (((b_x3*axis3X + b_y3*axis3Y)/(Math.abs(Math.pow(axis3X,2)+Math.pow(axis3Y,2))))*axis3Y)*axis3Y ),
                        bScalar43 = (int)( (((b_x4*axis3X + b_y4*axis3Y)/(Math.abs(Math.pow(axis3X,2)+Math.pow(axis3Y,2))))*axis3X)*axis3X  +  (((b_x4*axis3X + b_y4*axis3Y)/(Math.abs(Math.pow(axis3X,2)+Math.pow(axis3Y,2))))*axis3Y)*axis3Y );
                        
                        if(max(aScalar13, aScalar23, aScalar33, aScalar43)>=min(bScalar13, bScalar23, bScalar33, bScalar43)  && max(bScalar13, bScalar23, bScalar33, bScalar43)>=min(aScalar13, aScalar23, aScalar33, aScalar43)){
                            
                            int axis4X = b_x2-b_y3,
                            axis4Y = b_y2-b_y3;
                            
                            int aScalar14 = (int)( (((a_x1*axis4X + a_y1*axis4Y)/(Math.abs(Math.pow(axis4X,2)+Math.pow(axis4Y,2))))*axis4X)*axis4X  +  (((a_x1*axis4X + a_y1*axis4Y)/(Math.abs(Math.pow(axis4X,2)+Math.pow(axis4Y,2))))*axis4Y)*axis4Y ),
                            aScalar24 = (int)( (((a_x2*axis4X + a_y2*axis4Y)/(Math.abs(Math.pow(axis4X,2)+Math.pow(axis4Y,2))))*axis4X)*axis4X  +  (((a_x2*axis4X + a_y2*axis4Y)/(Math.abs(Math.pow(axis4X,2)+Math.pow(axis4Y,2))))*axis4Y)*axis4Y ),
                            aScalar34 = (int)( (((a_x3*axis4X + a_y3*axis4Y)/(Math.abs(Math.pow(axis4X,2)+Math.pow(axis4Y,2))))*axis4X)*axis4X  +  (((a_x3*axis4X + a_y3*axis4Y)/(Math.abs(Math.pow(axis4X,2)+Math.pow(axis4Y,2))))*axis4Y)*axis4Y ),
                            aScalar44 = (int)( (((a_x4*axis4X + a_y4*axis4Y)/(Math.abs(Math.pow(axis4X,2)+Math.pow(axis4Y,2))))*axis4X)*axis4X  +  (((a_x4*axis4X + a_y4*axis4Y)/(Math.abs(Math.pow(axis4X,2)+Math.pow(axis4Y,2))))*axis4Y)*axis4Y ),

                            bScalar14 = (int)( (((b_x1*axis4X + b_y1*axis4Y)/(Math.abs(Math.pow(axis4X,2)+Math.pow(axis4Y,2))))*axis4X)*axis4X  +  (((b_x1*axis4X + b_y1*axis4Y)/(Math.abs(Math.pow(axis4X,2)+Math.pow(axis4Y,2))))*axis4Y)*axis4Y ),
                            bScalar24 = (int)( (((b_x2*axis4X + b_y2*axis4Y)/(Math.abs(Math.pow(axis4X,2)+Math.pow(axis4Y,2))))*axis4X)*axis4X  +  (((b_x2*axis4X + b_y2*axis4Y)/(Math.abs(Math.pow(axis4X,2)+Math.pow(axis4Y,2))))*axis4Y)*axis4Y ),
                            bScalar34 = (int)( (((b_x3*axis4X + b_y3*axis4Y)/(Math.abs(Math.pow(axis4X,2)+Math.pow(axis4Y,2))))*axis4X)*axis4X  +  (((b_x3*axis4X + b_y3*axis4Y)/(Math.abs(Math.pow(axis4X,2)+Math.pow(axis4Y,2))))*axis4Y)*axis4Y ),
                            bScalar44 = (int)( (((b_x4*axis4X + b_y4*axis4Y)/(Math.abs(Math.pow(axis4X,2)+Math.pow(axis4Y,2))))*axis4X)*axis4X  +  (((b_x4*axis4X + b_y4*axis4Y)/(Math.abs(Math.pow(axis4X,2)+Math.pow(axis4Y,2))))*axis4Y)*axis4Y );
                            
                            if(max(aScalar14, aScalar24, aScalar34, aScalar44)>=min(bScalar14, bScalar24, bScalar34, bScalar44)  && max(bScalar14, bScalar24, bScalar34, bScalar44)>=min(aScalar14, aScalar24, aScalar34, aScalar44)){
                                return true;
                            }else{
                                return false;
                            }
                        }else{
                            return false;
                        }
                    }else{
                        return false;
                    }
                }else{
                    return false;
                }
    }
    public int min(int num1, int num2,int num3,int num4){
        if(num1 <= num2 && num1 <= num3 && num1 <= num4){
            return num1;
        }else if(num2 <= num1 && num2 <= num3 && num2 <= num4){
            return num2;
        }else if(num3 <= num1 && num3 <= num2 && num3 <= num4){
            return num3;
        }else if(num4 <= num1 && num4 <= num2 && num4 <= num3){
            return num4;
        }else{
            return 999999999;
        }
    }
    public int max(int num1, int num2,int num3,int num4){
        if(num1 >= num2 && num1 >= num3 && num1 >= num4){
            return num1;
        }else if(num2 >= num1 && num2 >= num3 && num2 >= num4){
            return num2;
        }else if(num3 >= num1 && num3 >= num2 && num3 >= num4){
            return num3;
        }else if(num4 >= num1 && num4 >= num2 && num4 >= num3){
            return num4;
        }else{
            return -999999999;
        }
    }
    public void render(Graphics g){
        g.setColor(Color.RED);
        
        shapes.aRectangle(g, x,y, 16, 16, angle);
        
        g.setColor(Color.BLUE);
        shapes.pointArc(g, x, y, 8, 32,angle*5, angle, angle);
        
        
        
        g.setColor(Color.GREEN);
        shapes.pointArc(g, x+4, y+4, 4, 32,angle*5, angle, angle);
        
    }
    
}
