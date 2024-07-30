
package waveGame;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;



public class game extends Canvas implements Runnable{
    public static int WIDTH = 640, HEIGHT = WIDTH/12*9;
    
    private Thread thread;
    private handler handler;
    private keyInput keyInput;
    private HUD hud;
    private spawner spawner;  
    
    private boolean running = false;
    public static float col1=0, col2=0, col3=0;
    public static Color col=new Color(col1,col2,col3);
    
    
    public game(){
        handler = new handler();
        keyInput = new keyInput(handler, this);
        spawner = new spawner(hud,handler, this);
        hud = new HUD();
         this.addKeyListener(keyInput);
         for(int i = 0; i < game.WIDTH+10; i++){
            handler.addObject(new wave(i,0,1,0,ID.wave, spawner.pheight,spawner.aheight,handler));
         }
        handler.addObject(new enemy(WIDTH, 250, 0,2, ID.enemy, 50, 200, 0, handler));
        handler.addObject(new player(125,HEIGHT/2+8,0, ID.player, handler));
        new window(WIDTH, HEIGHT, "WaveLength", this);
    }
    public synchronized void start(){
        thread = new Thread(this);
        thread.start();
        running = true;
    }
    public synchronized void stop(){
        try{
            thread.join();
            running = false;
        }catch(Exception e){
            e.printStackTrace(); 
        }
    }
    public void run(){
        this.requestFocus();
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000/amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;
        long timerC = System.currentTimeMillis();
        while(running){
            long now = System.nanoTime();
            delta += (now-lastTime)/ns;
            lastTime = now;
            while(delta>=1){
                tick();
                delta--;
            } 
            if(running)
                render();
            frames++;
            if(System.currentTimeMillis()-timer > 1000){
                timer += 1000;
                System.out.println("FPS: " + frames);
                frames = 0;
            }
                
        }
        stop();
    }
    private void tick(){
        try{
            handler.tick();
        }catch(Exception e){
        
        }
        spawner.tick();
        hud.tick();
        if(hud.score <10){
            bacColTransition(185,255,0,1.5f);
        }    
        
    }
    private void render(){
        BufferStrategy bs = this.getBufferStrategy(); 
        if(bs == null){
            this.createBufferStrategy(3);
            return;
        } 
        
        
        Graphics g = bs.getDrawGraphics();
        
        g.setColor(col);
        g.fillRect(0,0,WIDTH,HEIGHT);
        try{
            handler.render(g);
        
        }catch(Exception e){
        
        }
        
        hud.render(g);
        spawner.render(g);
        g.dispose();
        bs.show();
    }
    public static int randomInt(int min, int max){
        return min+(int)(Math.random()*((max-min)+1));
        
    }
    public static float clamp(float var, float min, float max){
        if(var>=max){
            return var=max;
        }else if(var<=min){
            return var=min;
        }else{
            return var;
        }
    }
    public static void bacColTransition(float col1, float col2, float col3, float speed){
        if(game.col1!=col1){
            if((game.col1<col1 && game.col1+speed>col1) || (game.col1>col1 && game.col1-speed<col1)){
                game.col1=col1;
            }else{
                
                if(col1>game.col1){
                    game.col1+=speed;
                    
                }else{
                    game.col1-=speed;
                }
            }
        }
        if(game.col2!=col2){
            if((game.col2<col2 && game.col2+speed>col2) || (game.col2>col2 && game.col2-speed<col2)){
                game.col2=col2;
                
            }else{
                if(col2>game.col2){
                    game.col2+=speed;
                }else{
                    game.col2-=speed;
                }
            }
        }
        if(game.col3!=col3){
            if((game.col3<col3 && game.col3+speed>col3) || (game.col3>col3 && game.col3-speed<col3)){
                game.col3=col3;
            }else{
                if(col3>game.col3){
                    game.col3+=speed;
                }else{
                    game.col3-=speed;
                }
            }
        }
        col = new Color((int)game.col1, (int)game.col2, (int)game.col3);
    }
    
    public static void main(String[] args) {
        new game();
    }
    
}
