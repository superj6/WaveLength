
package waveGame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;


public class spawner {
    public static float pos = 0, wavelength = 500, pheight = 165,aheight=10, angle = 0, vel = 1;
    private game game;
    long time = game.randomInt(4000,10000);
    long timer= System.currentTimeMillis();
    boolean bossTrue= false;
    boolean shooterTrue = false;
    long bosstime;
    private handler handler;
    private HUD hud;
    private int bosslevel =1;
    private int min = 6000,max = 10000;
    private int odd = 6, odd2=40;
    private int min1 = 1000, min2 = 50, min3 = 75;
    private int max1 = 2000, max2 = 65, max3 = 500;
    int drawing = 0;
    public spawner(HUD hud,handler handler, game game){
        this.handler = handler;
        this.hud=hud;
        this.game = game;
    }
    public float wave(float aheight, float wavelength, float pos){
        return (float)(aheight*(Math.cos(((2*Math.PI)/wavelength)*pos)));
    } 
    public void tick(){
        if(!bossTrue){ 
            handler.addObject(new wave(game.WIDTH,0,vel, (int) angle,ID.wave, pheight,wave(aheight, wavelength, pos),handler));
            pos+=1; 

            if(System.currentTimeMillis()-timer>time){
                time=game.randomInt(min,max);
                timer+=time;
                int blub=game.randomInt(1,100);
                if(blub<=odd){
                    handler.addObject(new enemy(game.WIDTH, game.randomInt((int)pheight,game.HEIGHT-(int)pheight), 0, (float)game.randomInt(min1,max1)/1000f, ID.enemy, game.randomInt(min2,max2), game.randomInt(min3,max3), pos, handler));
                    handler.addObject(new enemy(game.WIDTH, game.randomInt((int)pheight,game.HEIGHT-(int)pheight), 0, (float)game.randomInt(min1,max1)/1000f, ID.enemy, game.randomInt(min2,max2), game.randomInt(min3,max3), pos, handler));
                    handler.addObject(new enemy(game.WIDTH, game.randomInt((int)pheight,game.HEIGHT-(int)pheight), 0, (float)game.randomInt(min1,max1)/1000f, ID.enemy, game.randomInt(min2,max2), game.randomInt(min3,max3), pos, handler));
                }else if(blub<=odd2){
                    handler.addObject(new enemy(game.WIDTH, game.randomInt((int)pheight,game.HEIGHT-(int)pheight), 0, (float)game.randomInt(min1,max1)/1000f, ID.enemy, game.randomInt(min2,max2), game.randomInt(min3,max3), pos, handler));
                    handler.addObject(new enemy(game.WIDTH, game.randomInt((int)pheight,game.HEIGHT-(int)pheight), 0, (float)game.randomInt(min1,max1)/1000f, ID.enemy, game.randomInt(min2,max2), game.randomInt(min3,max3), pos, handler));
                }else{
                    handler.addObject(new enemy(game.WIDTH, game.randomInt((int)pheight,game.HEIGHT-(int)pheight), 0, (float)game.randomInt(min1,max1)/1000f, ID.enemy, game.randomInt(min2,max2), game.randomInt(min3,max3), pos, handler));
                    
                }
            }
            if(hud.score==11){
                bossTrue=true;
                
                bosstime = System.currentTimeMillis();
                hud.level = hud.level+" BOSS";
                
            }else if(hud.score==59){
                bossTrue=true;
                
                bosstime = System.currentTimeMillis();
                hud.level = hud.level+" BOSS";
                
            }
        }else if(bossTrue){ 
            
            if(bosslevel == 1){
                
                if(System.currentTimeMillis()-bosstime<=11500){
                    drawing = 1;
                    hud.scorechanger = false;
                    game.bacColTransition(150,0,0,3);
                    if(pheight<game.HEIGHT/2){
                        pheight+=1;
                        
                        handler.addObject(new wave(game.WIDTH,0,vel, (int) angle,ID.wave, pheight,wave(aheight, wavelength, pos),handler));
                    }
                }else if(System.currentTimeMillis()-bosstime<=12000){
                    handler.clearEnemies();
                    pos = 0;
                    hud.scorechanger = true;
                    wavelength = 2000;         
                    aheight=game.WIDTH/2-96;
                    drawing = 0;
                    shooterTrue = true;
                }else if(System.currentTimeMillis()-bosstime<=57000){
                    if(pos % 120==0){
                        handler.addObject(new enemy(game.WIDTH-96, (float)wave(aheight, wavelength, pos)+game.HEIGHT/2-20, 0, vel, ID.enemy, 0,1,0, handler));
                    }
                    pos+=1;
                    
                }else if(System.currentTimeMillis()-bosstime<=58000){
                   
                    wavelength = 390;
                    aheight=15;
                    pos=0;
                    odd2=45;
                    odd = 12;
                    vel = 1.5f;
                    game.bacColTransition(255,0,255,1);
                    shooterTrue = false;
                }else if(System.currentTimeMillis()-bosstime<=60500){
                    
                    pos+=1;
                    if(pheight>150){
                        pheight-=1;
                    }
                    handler.addObject(new wave(game.WIDTH,0,vel, (int) angle,ID.wave, pheight,wave(aheight, wavelength, pos),handler));
                    game.bacColTransition(255,0,255,1);
                    
                }else{
                    bossTrue=false;
                    
                    hud.level = "Micro Wave";
                    bosslevel = 2;
                    min1 = 1200;
                    min2 = 40;
                    max2 = 75;
                    max3 = 435;
                    min = 5500;
                    max = 8850;
                    timer= System.currentTimeMillis();
                }
            }else if(bosslevel == 2){
                
                if(System.currentTimeMillis()-bosstime<=11500){
                    drawing = 2;
                    hud.scorechanger = false;
                    game.bacColTransition(140,0,0,10);
                    if(pheight<game.HEIGHT/2){
                        pheight+=1;
                        
                        handler.addObject(new wave(game.WIDTH,0,vel, (int) angle,ID.wave, pheight,wave(aheight, wavelength, pos),handler));
                    }
                }else if(System.currentTimeMillis()-bosstime<=12000){
                    handler.clearEnemies();
                    pos = 0;
                    shooterTrue = true;
                    hud.scorechanger = true;
                    wavelength = 1425;         
                    aheight=game.WIDTH/2-96;
                    drawing = 0;
                }else if(System.currentTimeMillis()-bosstime<=57000){
                    if(pos % 72 == 0){
                        handler.addObject(new enemy(game.WIDTH-96, (float)wave(aheight, wavelength, pos)+game.HEIGHT/2-32, 0, vel, ID.enemy, 0,1,0, handler));
                    }
                    pos+=1;
                    
                }else if(System.currentTimeMillis()-bosstime<=58000){
                   
                    wavelength = 295;
                    aheight=18;
                    pos=0;
                    vel = 1.75f;
                    odd2=50;
                    for(int i = 0; i<handler.object.size(); i++){
                        if(handler.object.get(i).getId() == ID.player){
                            handler.object.get(i).setVelX(0.1f);
                        }
                    }
                    shooterTrue = false;
                    
                    game.bacColTransition(0,255,255,0.5f);
                }else if(System.currentTimeMillis()-bosstime<=60500){
                    
                    pos+=1;
                    if(pheight>140){
                        pheight-=1;
                    }
                    handler.addObject(new wave(game.WIDTH,0,vel, (int) angle,ID.wave, pheight,wave(aheight, wavelength, pos),handler));
                    game.bacColTransition(0,255,255,2f);
                    
                }else{
                    bossTrue=false;
                    for(int i = 0; i<handler.object.size(); i++){
                        if(handler.object.get(i).getId() == ID.player){
                            handler.object.get(i).setVelX(0);
                        }
                    }
                    hud.level = "Infra Red";
                    bosslevel = 3;
                    min1 = 1250;
                    max1 = 2700;
                    max3 = 415;
                    min3 = 100;
                    min = 5000;
                    max = 8000;
                    timer= System.currentTimeMillis();
                }
            } 
        } 
        
       
    }
    public void render(Graphics g){
        Font fnt3 = new Font("arial", 1, 20);
        Font fnt2 = new Font("arial", 1, 40);
        if(drawing ==1){
            g.setFont(fnt2);
            g.setColor(new Color( (int)game.col3, (int)game.col1, (int)game.col2));
            g.drawString("BOSS LEVEL:", game.WIDTH/2-140, game.HEIGHT/2-80);
            g.setFont(fnt3);
            g.drawString("Radio Wave", game.WIDTH/2-70, game.HEIGHT/2-40);
        }
        if(drawing ==2){
            g.setFont(fnt2);
            g.setColor(new Color( 255-(int)game.col3, (int)game.col1, (int)game.col2));
            g.drawString("BOSS LEVEL:", game.WIDTH/2-140, game.HEIGHT/2-80);
            g.setFont(fnt3);
            g.drawString("Micro Wave", game.WIDTH/2-70, game.HEIGHT/2-40);
        }
        if(shooterTrue){
            g.setColor(Color.BLACK);
            shapes.aRectangle(g,game.WIDTH - 48, wave(aheight, wavelength, pos)+game.HEIGHT/2-32, 48, 48, (int)angle);
            shapes.pointRectangle(g, game.WIDTH - 32, wave(aheight, wavelength, pos)+game.HEIGHT/2-22, 32,32,48, (int)angle+180, (int)angle+180);
            g.setColor(Color.red);
            shapes.pointArc(g, game.WIDTH - 24, wave(aheight, wavelength, pos)+game.HEIGHT/2-19, 12, 67, (int)angle+180, 180, (int)angle+180);
            shapes.arc(g, game.WIDTH - 32, wave(aheight, wavelength, pos)+game.HEIGHT/2-16, 8, 360, 0);
        }
    }
    
}
