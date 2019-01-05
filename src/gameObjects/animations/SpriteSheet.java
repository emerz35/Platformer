package gameObjects.animations;

import java.awt.image.BufferedImage;

/**
 *
 * @author Charlie
 */
public class SpriteSheet {
    private final BufferedImage image;
    private final int numx,numy,subwidth,subheight;
    public SpriteSheet(BufferedImage image, int numx, int numy, int subwidth, int subheight){
        this.numx = numx;
        this.numy = numy;
        this.image = image;
        this.subwidth = subwidth;
        this.subheight = subheight;
    }
    public BufferedImage getSubImage(int x, int y){
        return image.getSubimage(x*numx, y*numy, subwidth, subheight);
    }
    public BufferedImage getSubImage(int num){
        return image.getSubimage((num-1) % numx, (num-1)/numy,subwidth,subheight);
    }
}
