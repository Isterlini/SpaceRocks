import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.math.MathUtils;


public class youLose extends BaseActor
{
    public youLose(float x, float y, Stage s)
    {
        super(x, y, s);
        this.setAnimator( new Animator("images/message-lose.png") );
    }

    public void act(float deltaTime)
    {
        super.act(deltaTime);

    }
}