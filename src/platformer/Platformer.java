package platformer;

import abilities.AbilityHandler;
import abilities.DashAbility;
import gameObjects.Enemy;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import gameObjects.Player;
import gameObjects.Platform;
import gameObjects.behaviours.NoMovementBehaviour;
import gameObjects.behaviours.OnPlatformMovementBehaviour;
import gameObjects.behaviours.PlayerMovementBehaviour;
import gameObjects.weaponObjects.MeleeObject;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import stages.Stage;
import viewables.GUIViewable;
import viewables.GameOverViewable;
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
    private static Player player;
    private Stage currentStage;
    private final MenuHandler menuHandler;
    private final AbilityHandler abilityHandler;
    public Platformer(){
        requestFocus();
        window = new Window("Platformer", width, height, this);
        handler = new Handler();
        currentStage = new Stage();
        menuHandler = new MenuHandler();
        Platform platform = new Platform(320,200,500,10,currentStage);
        Platform platform2 = new Platform(120,250,100,10,currentStage);
        PlayerMovementBehaviour pmb = new PlayerMovementBehaviour();
        player = new Player(200,200, pmb,currentStage);
        abilityHandler = new AbilityHandler(new DashAbility(player));
        addKeyListener(abilityHandler);
        addKeyListener(new KeyAdapter(){
            @Override
            public void keyPressed(KeyEvent e){
                if(e.getKeyChar() == 'e'){
                    Enemy enemy = new Enemy(140,100,24,24,32,Color.red, new OnPlatformMovementBehaviour(platform,2),currentStage);
                    handler.addObject(enemy);
                    currentStage.addObject(enemy);
                }
            }
        });
        Enemy e = new Enemy(140,100,26,26,32,Color.red, new OnPlatformMovementBehaviour(platform,2),currentStage);
        e.setDirection("left");
        //Enemy e = new Enemy(100,100,32,32,32,Color.red, new LineMovementBehaviour(new LineFunction(0,50,new float[]{0,500},new float[]{-1,200}),2)/*new NoMovementBehaviour()*/,currentStage);
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
        MeleeObject o = new MeleeObject(1,1,25,32,0,null,new NoMovementBehaviour(),null, player);
        currentStage.addObject(o);
        handler.addObject(o);
        menuHandler.addViewable(new GUIViewable(player,o, menuHandler));
        //menuHandler.addViewable(new InventoryViewable(player.getItems(),menuHandler));
        menuHandler.addViewable(new GameOverViewable(menuHandler));
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
        if(menuHandler.getTopViewable() instanceof GUIViewable)currentStage.tick();
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
    public static Player getPlayer(){
        return player;
    }
    public void setStage(Stage stage){
        this.currentStage = stage;
    }
    public Stage getCurrentStage(){
        return currentStage;
    }
}
