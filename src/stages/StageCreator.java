package stages;

import gameObjects.Enemy;
import gameObjects.behaviours.NoMovementBehaviour;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferStrategy;
import platformer.Handler;
import platformer.Window;

/**
 *
 * @author Charlie Hands
 */
public class StageCreator extends Canvas implements Runnable{
    private Thread thread;
    private boolean running;
    private final Window window;
    private final int width = 800, height = 480;
    private final Stage currentStage;
    private final Handler handler;
    public StageCreator(){
        this.window = new Window("Stage Creator",width,height,this);
        this.currentStage = new Stage();
        this.handler = new Handler();
        addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                System.out.println("o");
                if(e.getButton() == MouseEvent.BUTTON2){
                    Enemy temp = new Enemy(e.getX(), e.getY(),24,24,32,Color.red, new NoMovementBehaviour(),currentStage);
                    currentStage.addObject(temp);
                    handler.addObject(temp);
                }
            }
        });
    }
    public static void main(String... args){
        new StageCreator();
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
        g.dispose();
        bs.show();
   }
}
