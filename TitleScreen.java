import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TitleScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TitleScreen extends World
{
    Label titleLabel;
    /**
     * Constructor for objects of class TitleScreen.
     * 
     */
    public TitleScreen()
    {
        super(600, 400, 1);
        titleLabel = new Label("Brick Breaker", 60);
        addObject(titleLabel, getWidth() / 2, 100);
        prepare();
    }

    private void prepare()
    {
        showText("Use ← and → arrow keys to move the paddle", getWidth() / 2, 180);
        showText("Break all the bricks to advance to next level", getWidth() / 2, 200);
        showText("Press SPACE to start", getWidth() / 2, 260);
        showText("Move paddle with ←/→. Don't lose all your balls.", getWidth() / 2, 330);
    }

    public void act()
    {
        if (Greenfoot.isKeyDown("space")) {
            Greenfoot.setWorld(new MyWorld());
        }
    }
}



