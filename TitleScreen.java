import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TitleScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TitleScreen extends World
{
    Label titleLabel = new Label ("Brick Breaker", 60);
    /**
     * Constructor for objects of class TitleScreen.
     * 
     */
    public TitleScreen()
    {
<<<<<<< HEAD
        super(600,400,1);
=======
        super(600, 400, 1);
>>>>>>> 1d7e4f41028e4c642acab4e3d59054afa1a62576
        prepare();
    }

    private void prepare()
    {
        showText("Use ← and → arrow keys to move the paddle", getWidth() / 2, 180);
        showText("Break all the bricks to advance to next level", getWidth() / 2, 200);
        showText("Press SPACE to start", getWidth() / 2, 260);
        showText("Press H for help/instructions", getWidth() / 2, 300);
    }

    public void act()
    {
        if (Greenfoot.isKeyDown("space")) {
            Greenfoot.setWorld(new MyWorld());
        }
        if (Greenfoot.isKeyDown("h")) {
            showInstructions();
        }
    }

    private void showInstructions()
    {
        // explanation
        showText("Move paddle with ←/→. Don't let all the balls drop.", getWidth() / 2, 330);
    }
}

