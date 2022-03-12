import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.graphics.Color;

public class Powerup extends BaseActor
{
    public Powerup(float x, float y, Stage s)
    {
        super(x, y, s);
        this.setAnimator( new Animator("images/shields.png") );
        this.setSize(50,50);
        this.setColor(Color.GREEN);
        this.addAction(
        Actions.sequence(
        Actions.delay(5),
        Actions.fadeOut(1),
        Actions.removeActor()
        )
        );
        this.setBoundaryPolygon(8);
    }

    public void act(float deltaTime)
    {
        super.act(deltaTime);

    }
}