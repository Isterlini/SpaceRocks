import com.badlogic.gdx.scenes.scene2d.Stage;

public class Who extends BaseActor
{
    public Who(float x, float y, Stage s)
    {
        super(x, y, s);
         setAnimator( new Animator("images/Who.png") );
    }
}