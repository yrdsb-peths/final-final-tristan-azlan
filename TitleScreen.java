import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TitleScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TitleScreen extends MyWorld
{
    Label titleLabel = new Label ("Brick Breaker", 60);
    /**
     * Constructor for objects of class TitleScreen.
     * 
     */
    public TitleScreen()
    {
        super(600, 400, 1);
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
        showText("Move paddle with ←/→. Don't let the ball drop 3 times.", getWidth() / 2, 330);
    }
}

