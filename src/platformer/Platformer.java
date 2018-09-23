package platformer;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import gameObjects.Player;
import gameObjects.Platform;
import gameObjects.behaviours.PlayerMovementBehaviour;

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
    public static final float GRAVITY = 0.25f;
    private final Player player;
    public Platformer(){
        window = new Window("Platformer", width, height, this);
        handler = new Handler();
        Platform platform = new Platform(120,height - 200,10,200);
        Platform platform2 = new Platform(120, height - 50,200,10);
        PlayerMovementBehaviour pmb = new PlayerMovementBehaviour(this);
        this.player = new Player(100,100, pmb);
        addKeyListener(pmb);
        handler.addObject(this.player);
        handler.addObject(platform);
        handler.addObject(platform2);
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
        handler.tick();
    }
    private void render(){
        BufferStrategy bs = this.getBufferStrategy();
        if(bs == null){
            this.createBufferStrategy(4);
            return;
        }
        Graphics g = bs.getDrawGraphics();
        g.setColor(Color.white);
        System.out.println(Color.white.getRGB());
        g.fillRect(0, 0, width, height);
        handler.render(g);
        
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
}
