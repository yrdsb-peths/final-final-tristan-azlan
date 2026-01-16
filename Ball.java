import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
import java.util.ArrayList;


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
    
    // The act method helps with movement of the ball and functions and
    // reactions with other objects
    public void act()
    {
        resetBalls();
        moveBall();
        bounceWalls();
        bouncePaddle();
        breakAndBounceBlock();
    }
    
    // This method created the movement for the ball on th x-axis
    private void moveBall()
    {
        setLocation(getX() + x, getY() + y); 
    }
    
    // This method created the movement for the ball on th y-axis
    private void fallBall()
    {
        setLocation(getX() + x, getY() + y); 
    }
    
    // This method allows the ball to bounce from the outer rim walls of the
    // game screen
    private void bounceWalls()
    {
        // reverse left/right movement
        if (getX() <= 0 || getX() >= getWorld().getWidth() - 1)
        x = -x;  
        // reverse vertical movement
        if (getY() <= 0)
        y = -y;  
    }
    
    // This method makes the ball bounce off the paddle
    private void bouncePaddle()
    {
        if (isTouching(Paddle.class))
        {
            y = -Math.abs(y);
            setLocation(getX(), getY() - 0); // Move ball slightly up
        }
    }
    
    // This method breaks blocks that the ball touches and changes the ball's
    // direction based on the part of the block it touched while playing a
    // sound as well as helping keep track of score and blocks broken
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
    
    // This method keeps track of the score and breakcount in more detail
    public void addExplosionScore(int amount) {
        
        scoreCount += (amount * 100); 
        
        breakCount += amount; 
        
    }
    
    // This method allows the blocks to reset after clearing them all at the
    // point the ball touches the paddle again
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
}
