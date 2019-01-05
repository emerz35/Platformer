package gameObjects.animations;

import java.awt.Graphics;


/**
 *
 * @author Charlie
 */
public class Animator {
    private final SpriteSheet spriteSheet;
    private int ticks = 0;
    private final int numFrames,ticksperframe;
    public Animator(SpriteSheet spriteSheet, int numFrames, int ticksperframe){
        this.spriteSheet = spriteSheet;
        this.numFrames = numFrames;
        this.ticksperframe = ticksperframe;
    }
    public void render(Graphics g, int x, int y, int width, int height){
        g.drawImage(spriteSheet.getSubImage((ticks/ticksperframe)%numFrames),x,y,width,height,null);
        ticks++;
    }
}
