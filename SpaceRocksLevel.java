// import Gdx class to get user input
import com.badlogic.gdx.Gdx;
// import constants that represent each key
import com.badlogic.gdx.Input.Keys;

// working with text
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.ui.Label;

// value-based animations
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.math.MathUtils;

//Sounds and musics
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
public class SpaceRocksLevel extends BaseScreen
{
    Spaceship ship;
    Sheild sheilds;

    youWin win;
    youLose lose;

    Label score;
    boolean complete = false;

    private float audioVolume;
    private Sound Laser;
    private Sound explosion;
    private Sound pwp;

    public void initialize()
    {
        new Space(0,0,mainStage);
        ship = new Spaceship(400,300,mainStage);
        sheilds = new Sheild(0,0,mainStage);
        sheilds.setSize(150,150);
        for(int n=0; n < SpaceRocksGame.rockCount; n++)
        {
            float x = MathUtils.random(0,800);
            float y = MathUtils.random(0,600);
            Rock rock = new Rock(x,y,mainStage);
            while(rock.distance(ship) < 200)
            {
                x = MathUtils.random(0,800);
                y = MathUtils.random(0,600);
                rock.setPosition(x,y);
            }

        }
        Label levelLabel = new Label("Level: " + SpaceRocksGame.level, BaseGame.labelStyle);
        mainStage.addActor(levelLabel);
        levelLabel.setPosition(350,500);
        levelLabel.addAction(
            Actions.sequence(
                Actions.delay(1),
                Actions.fadeOut(1),
                Actions.removeActor()
            )
        );

        //UI 
        //win = new youWin(400,300,mainStage);
        //win.setVisible(false);

        lose = new youLose(400,300,mainStage);
        lose.setVisible(false);

        score = new Label("Score: ?",BaseGame.labelStyle );
        score.setPosition(20,550);
        score.setColor(Color.WHITE);
        score.setFontScale(1.0f);
        mainStage.addActor(score);

        complete = false;
        
        //audio
        Laser = Gdx.audio.newSound(Gdx.files.internal("Assets/laser pew.ogg"));
        explosion = Gdx.audio.newSound(Gdx.files.internal("Assets/Explosion.ogg"));
        pwp = Gdx.audio.newSound(Gdx.files.internal("Assets/Item-Collect.wav"));
        audioVolume = 1.00f;
        
    }

    public void update(float deltaTime)
    {
        if ( Gdx.input.isKeyPressed( Keys.UP ) )
            ship.physics.accelerateAtAngle(ship.getRotation());
        if ( Gdx.input.isKeyPressed( Keys.LEFT ) )
            ship.rotateBy(180 * deltaTime);    
        if ( Gdx.input.isKeyPressed( Keys.RIGHT ) )
            ship.rotateBy(-180 * deltaTime);
        //implement the warp 
        if(Gdx.input.isKeyJustPressed(Keys.C ) )
        {
            ship.moveBy(MathUtils.random(800),MathUtils.random(600));
            Warp warp = new Warp(0,0,mainStage);
            warp.setScale(2 * ship.getScaleX() );
            warp.centerAtActor(ship);
            warp.toFront();

            Warp warp2 = new Warp(0,0,mainStage);
            warp2.centerAtActor(ship);
            warp2.toFront();
        }
        //keep and update the score
        score.setText("Score: " + SpaceRocksGame.sc);
        
        //if ship is on screen then you can press space
        if(ship.isOnStage() && Gdx.input.isKeyJustPressed(Keys.SPACE)&&BaseActor.getList(mainStage,"Laser").size() < 3)
        {
            Laser laser = new Laser(0,0,mainStage);                        
            laser.centerAtActor(ship);
            Laser.play(audioVolume);
            laser.setRotation(ship.getRotation());
            laser.physics.setMotionAngle(ship.getRotation());
            ship.toFront();
        
        }
    
        sheilds.centerAtActor(ship);
        sheilds.setRotation(ship.getRotation());
        //destroy rock on collision with laser
        for(BaseActor rock: BaseActor.getList(mainStage,"Rock"))
        {
            for(BaseActor laser: BaseActor.getList(mainStage,"Laser"))
            {
                if(laser.overlaps(rock))
                {
                    laser.remove();
                    rock.remove();
                    explosion.play(audioVolume);
                    //random chance of spawning a powerup
                    if(Math.random() < 0.25)
                    {
                        Powerup up = new Powerup(0,0,mainStage);
                        up.centerAtActor(rock);
                    }
                    Explosion explode = new Explosion(0,0,mainStage);
                    explode.setScale(2*explode.getScaleX());
                    explode.centerAtActor(rock);
                    SpaceRocksGame.sc += 100;
                    //only split if scale is 1 
                    if(rock.getScaleX() ==1)
                    {
                        Rock r1 = new Rock(0,0,mainStage);
                        Rock r2 = new Rock(0,0,mainStage);
                        r1.centerAtActor(rock);
                        r2.centerAtActor(rock);
                        r1.setScale(0.5f);
                        r2.setScale(0.5f);

               
                        r1.physics.setSpeed(2*rock.physics.getSpeed());
                        r2.physics.setSpeed(2*rock.physics.getSpeed());
                        //seco.nd rock should go in opposite direction of the first rock 
                        r2.physics.setMotionAngle(-r1.physics.getMotionAngle() );

                    }
                    if(rock.getScaleX() <1 && laser.overlaps(rock))                        
                    {
                        SpaceRocksGame.sc += 150;
                    }
                    explode.toFront();

                }

            }
        }
        ship.toFront();
        sheilds.toFront();
        for(BaseActor Powerup : BaseActor.getList(mainStage, "Powerup"))
            if(ship.overlaps(Powerup))
            {
                sheilds.addAction(
                    Actions.scaleBy(0.2f,0.2f,1)
                );
                pwp.play(audioVolume);
                Powerup.remove();
            }
        //check for rok-ship collision
        for(BaseActor rock : BaseActor.getList(mainStage, "Rock") )
        {
            if(sheilds.isOnStage() && rock.overlaps(sheilds))
            {
                Explosion explode = new Explosion(0,0,mainStage);
                explode.setScale(5);
                explode.centerAtActor(rock);
                rock.remove();
                sheilds.remove();
                // sheilds.addAction(
                // Actions.scaleBy(-0.2f,-0.2f,1)
                // );
            }
            if(ship.isOnStage() && rock.overlaps(ship))
            {
                Explosion explode = new Explosion(0,0,mainStage);
                explode.setScale(5);
                explode.centerAtActor(ship);
                ship.remove();
                lose.setVisible(true);
            }
        }
        //store code to be run at a later time. 
        Runnable nextLevel = () -> 
            {
                SpaceRocksGame.level+=1;
                SpaceRocksGame.rockCount +=2;
                SpaceRocksGame.rockSpeed +=25;
                //load new screen
                BaseGame.setActiveScreen(new SpaceRocksLevel() );
            };

        //level is comlete when no rocks are left 
        if(BaseActor.getList(mainStage, "Rock").size() == 0 && !complete)
        {
            complete = true;
            ship.addAction(
                Actions.sequence(
                    Actions.delay(3),
                    Actions.run(nextLevel)
                )
            );

            //create a "Level Complete" Label that fades in 
            Label levelComplete = new Label("Level Complete", BaseGame.labelStyle);
            mainStage.addActor(levelComplete);
            levelComplete.setPosition(350,300);
            levelComplete.setColor(new Color(1,1,1,0));
            levelComplete.addAction(
                Actions.fadeIn(1)
            );
        }
    }
}