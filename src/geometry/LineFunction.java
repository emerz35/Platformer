package geometry;

import platformer.Platformer;

/**
 *
 * @author Charlie Hands
 */
public class LineFunction {
    private final float gradient;
    private final float yIntercept;
    private final float[] xbounds;
    private final float[] ybounds;
    public LineFunction(float gradient, float yIntercept, float[] xbounds, float[] ybounds){
        this.gradient = gradient;
        this.yIntercept = yIntercept;
        this.xbounds = xbounds;
        this.ybounds = ybounds;
    }
    
    public float f(float x){
        Platformer.clamp(x,xbounds[0],xbounds[1]);
        return Platformer.clamp((gradient * x) + yIntercept,ybounds[0],ybounds[1]);
    }
    public float[] getXBounds(){
        return xbounds;
    }
    public float[] getYBounds(){
        return ybounds;
    }
}
