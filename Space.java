import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.math.MathUtils;


public class Space extends BaseActor
{
    public Space(float x, float y, Stage s)
    {
        super(x, y, s);
        this.setAnimator( new Animator("images/space.png") );
    }

    public void act(float deltaTime)
    {
        super.act(deltaTime);

    }
}