import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TitleScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TitleScreen extends World
{
    // Label used to display game title
    Label titleLabel = new Label ("Brick Breaker", 60);
    /**
     * Constructor for objects of class TitleScreen.
     * 
     */
    public TitleScreen()
    {
        //create world with width 600, height 400, cell size 1
        super(600, 400, 1);

        //display instructions and prompts
        prepare();

    }

    private void prepare()
    {
        // explain how to use the paddle
        showText("Use ← and → arrow keys to move the paddle", getWidth() / 2, 180);
        // explain main goal of game
        showText("Break all the bricks to advance to the next level", getWidth() / 2, 200);
        // press space to start game
        showText("Press SPACE to start", getWidth() / 2, 260);
        // tells them how to acess extra info
        showText("Press H for help/instructions", getWidth() / 2, 300);
    }

    public void act()
    {
        // start game when space is pressed
        if (Greenfoot.isKeyDown("space")) {
            Greenfoot.setWorld(new MyWorld());
        }
        // show additional instrcutions if h is pressed
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

