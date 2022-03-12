import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.math.MathUtils;


public class Sheild extends BaseActor
{
    public Sheild(float x, float y, Stage s)
    {
        super(x, y, s);
        this.setAnimator( new Animator("images/shields.png") );
        this.setScale(0.5f);
        this.setBoundaryPolygon(8);
    }

    public void act(float deltaTime)
    {
        super.act(deltaTime);

    }
}