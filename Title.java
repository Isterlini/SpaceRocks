import com.badlogic.gdx.scenes.scene2d.Stage;
public class Title extends BaseActor
{
    public Title(float x, float y, Stage s)
    {
        super(x, y, s);
        setAnimator( new Animator("images/space-rocks-title.png") );
    }
}