package platformer;

import gameObjects.Enemy;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import gameObjects.Player;
import gameObjects.Platform;
import gameObjects.behaviours.LineMovementBehaviour;
import gameObjects.behaviours.NoMovementBehaviour;
import gameObjects.behaviours.PlayerMovementBehaviour;
import gameObjects.weaponObjects.MeleeObject;
import geometry.LineFunction;
import stages.Stage;
import viewables.GUIViewable;
import viewables.MenuHandler;

/**
 *
 * @author Charlie Hands
 */
public class Platformer extends Canvas implements Runnable{
    private Thread thread;
    private boolean running;
    private final Window window;
    private final Handler handler;
    private final int width = 800, height = 480;
    public static final float GRAVITY = 1f;
    private final Player player;
    private Stage currentStage;
    private final MenuHandler menuHandler;
    public Platformer(){
        window = new Window("Platformer", width, height, this);
        handler = new Handler();
        currentStage = new Stage();
        menuHandler = new MenuHandler();
        Platform platform = new Platform(320,200,200,10,currentStage);
        Platform platform2 = new Platform(120,250,100,10,currentStage);
        PlayerMovementBehaviour pmb = new PlayerMovementBehaviour();
        this.player = new Player(100,100, pmb,currentStage);
        Enemy e = new Enemy(100,100,32,32,32,Color.red, new LineMovementBehaviour(new LineFunction(0,50,new float[]{0,500},new float[]{-1,200}),2)/*new NoMovementBehaviour()*/,currentStage);
        addKeyListener(pmb); 
        addMouseListener(menuHandler);
        currentStage.addObject(this.player);
        currentStage.addObject(platform);
        currentStage.addObject(platform2);
        currentStage.addObject(e);
        handler.addObject(this.player);
        handler.addObject(platform);
        handler.addObject(platform2);
        handler.addObject(e);
        MeleeObject o = new MeleeObject(1,1,15,32,0,null,new NoMovementBehaviour(),null, player);
        currentStage.addObject(o);
        handler.addObject(o);
        menuHandler.addViewable(new GUIViewable(player,o));
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Platformer game = new Platformer();
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
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
    @Override
    public void run() {
        requestFocus();
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        /*long timer = System.currentTimeMillis();
        int frames = 0;*/
        while(running){
            long now = System.nanoTime();
            delta += (now - lastTime)/ns;
            lastTime = now;
            while(delta >= 1){
                tick();
                render();
                delta--;
            }
            
            /*frames++;
            if(System.currentTimeMillis() - timer > 1000){
                timer += 1000;
                System.out.println("FPS: " + frames);
                frames = 0;
            }*/
        }
        stop();	
    }
    private void tick(){
        currentStage.tick();
    }
    private void render(){
        BufferStrategy bs = this.getBufferStrategy();
        if(bs == null){
            this.createBufferStrategy(4);
            return;
        }
        Graphics g = bs.getDrawGraphics();
        g.setColor(Color.white);
        g.fillRect(0, 0, width, height);
        handler.render(g);
        menuHandler.render(g);
        
        g.dispose();
        bs.show();
    }
    public static float clamp(float var, float min, float max){
        if(var >= max) return max;
        if(var <= min) return min;
        return var;
    }
    public Player getPlayer(){
        return this.player;
    }
    public void setStage(Stage stage){
        this.currentStage = stage;
    }
    public Stage getCurrentStage(){
        return currentStage;
    }
}
