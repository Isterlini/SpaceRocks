public class SpaceRocksGame extends BaseGame
{
    public static int rockCount;
    public static int level;
    public static int rockSpeed;
    public static int sc;
    public void create()
    {
        super.create();
        
        rockCount=2;
        level = 1;
        rockSpeed = 42;
        sc =0;
        // first screen to be loaded
        BaseGame.setActiveScreen( new MainMenu() );
    }
    
}