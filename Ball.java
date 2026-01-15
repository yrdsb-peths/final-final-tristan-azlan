import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
import java.util.ArrayList;

/**
 * Write a description of class Ball here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ball extends Actor
{
    /**
     * Act - do whatever the Ball wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    // add ball
    private Ball ball;
    // initial speed
    private int x = 3;
    private int y = -3;
    
    private int scoreCount = 0;
    private int breakCount = 0;
    
    public void act()
    {
        resetBalls();
        moveBall();
        bounceWalls();
        bouncePaddle();
        breakAndBounceBlock();
        checkBottom();
    }
    
    
    private void moveBall()
    {
        setLocation(getX() + x, getY() + y); 
    }
    
    private void fallBall()
    {
        setLocation(getX() + x, getY() + y); 
    }
    
    private void bounceWalls()
    {
        // reverse left/right movement
        if (getX() <= 0 || getX() >= getWorld().getWidth() - 1)
        x = -x;  
        // reverse vertical movement
        if (getY() <= 0)
        y = -y;  
    }
    // make ball bounce off paddle
    private void bouncePaddle()
    {
        if (isTouching(Paddle.class))
        {
            y = -Math.abs(y);
            setLocation(getX(), getY() - 0); // Move ball slightly up
        }
    }
    
    
    private void breakAndBounceBlock()
    {       
        Block brokenBlock1 = (Block) getOneIntersectingObject(Block.class);
        Actor block1 = getOneIntersectingObject(Block.class);
        if(block1 != null)
        {
            int brokenBlock1X = brokenBlock1.getX();
            int brokenBlock1Y = brokenBlock1.getY();
            getWorld().removeObject(block1);
            
            int newDirection1 = brokenBlock1Y + 40;
            int newDirection2 = brokenBlock1Y - 40;
            int newDirection3 = brokenBlock1X + 40;
            int newDirection4 = brokenBlock1X - 40;
            
            if(getY()<newDirection1)
            {
                y = -y;
            }
            
            if(getY()>newDirection2)
            {
                y = -y;
            }
            
            if(getX()<newDirection3)
            {
                x = -x;
            }
            
            if(getX()>newDirection4)
            {
                x = -x;
            }
            
            scoreCount = scoreCount + 100;
            breakCount += 1;
            Greenfoot.playSound("bounce-8111.mp3");
        }
        
        
        
        TNT_Block tnt = (TNT_Block) getOneIntersectingObject(TNT_Block.class);
        if (tnt != null) {
            int tntX = tnt.getX();
            int tntY = tnt.getY();
        
            getWorld().addObject(new Explosion(200, 200), tntX, tntY);
        
            getWorld().removeObject(tnt);
        
            y = -y; 
            scoreCount += 100;
            breakCount += 1;
            Greenfoot.playSound("explosion-fx-343683.mp3");
        }
    }
    
    public void addExplosionScore(int amount) {
        
        scoreCount += (amount * 100); 
        
        breakCount += amount; 
        
        System.out.println("Explosion broke " + amount + " blocks!");
    }
    
    public void resetBalls()
    {   
        if (breakCount == 21)
        {
            Actor paddle = getOneIntersectingObject(Paddle.class);
            if (paddle != null) {       
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 7; j++) {
                        int x = Greenfoot.getRandomNumber(12);
            
                        if (x == 1) {
                            getWorld().addObject(new TNT_Block(), 45 + j * 85, 50 + i * 85);
                        }
                        else 
                        {
                            getWorld().addObject(new Block(), 45 + j * 85, 50 + i * 85);
                        }
                    }
                }
                breakCount = 0;
            }
        }
    }
    private void checkBottom()
    {
        if(getY() >= getWorld().getHeight() - 1)
        {
            Greenfoot.setWorld(new EndScreen(0));
        }
    }
}
