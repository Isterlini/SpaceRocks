import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.math.MathUtils;


public class Spaceship extends BaseActor
{
    public Spaceship(float x, float y, Stage s)
    {
        super(x, y, s);
        this.setAnimator( new Animator("images/spaceship-red.png") );
        this.setSize(50,50);
        this.setBoundaryPolygon(8);
        this.setPhysics(new Physics(400,200,0));
    }

    public void act(float deltaTime)
    {
         super.act(deltaTime);
         this.wrapToScreen(800,600);
    }
}