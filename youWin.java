import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.math.MathUtils;


public class youWin extends BaseActor
{
    public youWin(float x, float y, Stage s)
    {
        super(x, y, s);
        this.setAnimator( new Animator("images/message-win.png") );
    }

    public void act(float deltaTime)
    {
        super.act(deltaTime);

    }
}