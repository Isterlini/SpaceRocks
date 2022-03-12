import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.math.MathUtils;


public class Warp extends BaseActor
{
    public Warp(float x, float y, Stage s)
    {
        super(x, y, s);
        this.setAnimator( new Animator("images/warp.png",4,8,1/20f,false) );
        this.setBoundaryPolygon(8);
    }

    public void act(float deltaTime)
    {
        super.act(deltaTime);
        //animation is finished
        if(this.animator.isAnimationFinished())
        this.remove();
    }
}