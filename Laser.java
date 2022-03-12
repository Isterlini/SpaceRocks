import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.math.MathUtils;


public class Laser extends BaseActor
{
    public Laser(float x, float y, Stage s)
    {
        super(x, y, s);
        this.setAnimator( new Animator("images/laser-red.png") );
        this.setPhysics(new Physics(4000,400,0));
        this.physics.setSpeed(400);
        this.addAction(
            Actions.sequence(
                Actions.delay(0.5f),
                Actions.fadeOut(1.0f),
                Actions.removeActor()));
    }

    public void act(float deltaTime)
    {
        super.act(deltaTime);
        this.wrapToScreen(800,600);
    }
}