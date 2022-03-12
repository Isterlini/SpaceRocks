// import Gdx class to get user input
import com.badlogic.gdx.Gdx;
// import constants that represent each key
import com.badlogic.gdx.Input.Keys;

// working with text
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.ui.Label;

// value-based animations
import com.badlogic.gdx.scenes.scene2d.actions.Actions;

public class MainMenu extends BaseScreen
{

    public void initialize()
    {
        new Space(0,0,mainStage);
        Label start = new Label("Press 'SPACE' to start",BaseGame.labelStyle);
        mainStage.addActor(start);
        start.setPosition(100,20);
        
        start.addAction(
            Actions.forever(
                Actions.sequence(
                    Actions.color(Color.WHITE,1),
                    Actions.color(Color.BLACK,1)
                )
            )
        );
        
        Label next = new Label("Press 'C' for controls",BaseGame.labelStyle);
        mainStage.addActor(next);
        next.setPosition(50,100);
        
        next.addAction(
            Actions.forever(
                Actions.sequence(
                    Actions.color(Color.WHITE,1),
                    Actions.color(Color.BLACK,1)
                )
            )
        );
        
        Title title = new Title(100,500,mainStage);
        title.addAction(
           Actions.forever(
           Actions.sequence(
           Actions.scaleTo(1.1f,1.1f,0.5f),
           Actions.scaleTo(0.9f,0.9f,0.5f)
             )
           )
        );
        
       Who create = new Who(100,350,mainStage);
        create.addAction(
           Actions.forever(
           Actions.sequence(
           Actions.scaleTo(1.1f,1.1f,0.5f),
           Actions.scaleTo(0.9f,0.9f,0.5f)
             )
           )
        );  
    }

    public void update(float deltaTime)
    {
         if ( Gdx.input.isKeyPressed( Keys.SPACE ) )
            BaseGame.setActiveScreen( new SpaceRocksLevel() );
         if(Gdx.input.isKeyPressed(Keys.C) )
         BaseGame.setActiveScreen(new ContolScreen() );
    }
}