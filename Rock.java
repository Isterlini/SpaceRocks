import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.math.MathUtils;


public class Rock extends BaseActor
{
    public Rock(float x, float y, Stage s)
    {
        super(x, y, s);
        this.setAnimator( new Animator("images/rock.png") );
        this.setBoundaryPolygon(8);
        this.setPhysics(new Physics(4000,50,0));
        this.physics.setSpeed(SpaceRocksGame.rockSpeed);
        this.physics.setMotionAngle(MathUtils.random(0,360));
    }

    public void act(float deltaTime)
    {
        super.act(deltaTime);
        this.wrapToScreen(800,600);
    }
}