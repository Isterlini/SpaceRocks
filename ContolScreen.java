// import Gdx class to get user input
import com.badlogic.gdx.Gdx;
// import constants that represent each key
import com.badlogic.gdx.Input.Keys;

// working with text
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.ui.Label;

// value-based animations
import com.badlogic.gdx.scenes.scene2d.actions.Actions;


public class ContolScreen extends BaseScreen
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
        //tells the user how to move
        Label control = new Label("Use the UP and DOWN key \n to move while" +
        " using the RIGHT and LEFT keys \n to turn",BaseGame.labelStyle);
        mainStage.addActor(control);
        control.setPosition(0,150);
        control.setFontScale(0.5f);
        control.addAction(
            Actions.forever(
                Actions.sequence(
                    Actions.color(Color.RED,1),
                    Actions.color(Color.BLUE,1)
                )
            )
        );
        //have the ship rotate
        Spaceship SSP = new Spaceship(500,150,mainStage);
        SSP.addAction(
        Actions.forever(
        Actions.rotateBy(5)));
        //tells the user how to move and give them a goal in mind
        Label goal = new Label("Goal:Destroy the rocks on screen to advance to "
        +"next screen",BaseGame.labelStyle);
        mainStage.addActor(goal);
        goal.setPosition(0,100);
        goal.setFontScale(0.5f);
        goal.addAction(
            Actions.forever(
                Actions.sequence(
                    Actions.color(Color.RED,1),
                    Actions.color(Color.BLUE,1)
                )
            )
        );                   
        new Rock(500,100,mainStage);
        new Laser(450,100,mainStage);
    }

    public void update(float deltaTime)
    {
         if ( Gdx.input.isKeyPressed( Keys.SPACE ) )
            BaseGame.setActiveScreen( new SpaceRocksLevel() );

    }
}