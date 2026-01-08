import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

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
    private int breakCount = 0;
    public void act()
    {
        
        moveBall();
        bounceWalls();
        bouncePaddle();
        breakAndBounceBlock();
        resetBalls();
    }
    
    private void moveBall()
    {
        setLocation(getX() + x, getY() + y); 
    }
    // make ball bounce off walls
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
            
            breakCount = breakCount + 1;
        }
        
        Extra_Ball_Block brokenBlock2 = (Extra_Ball_Block) getOneIntersectingObject(Extra_Ball_Block.class);
        Actor block2 = getOneIntersectingObject(Extra_Ball_Block.class);
        if(block2 != null)
        {
            int brokenBlock2X = brokenBlock2.getX();
            int brokenBlock2Y = brokenBlock2.getY();
            getWorld().removeObject(block2);
            
            ball = new Ball();
            getWorld().addObject(ball, brokenBlock2X, brokenBlock2Y);
            
            int newDirection5 = brokenBlock2Y + 40;
            int newDirection6 = brokenBlock2Y - 40;
            int newDirection7 = brokenBlock2X + 40;
            int newDirection8 = brokenBlock2X - 40;
            
            if(getY()<newDirection5)
            {
                y = -y;
            }
            
            if(getY()>newDirection6)
            {
                y = -y;
            }
            
            if(getX()<newDirection7)
            {
                x = -x;
            }
            
            if(getX()>newDirection8)
            {
                x = -x;
            }
            
            breakCount = breakCount + 1;
        }
        
        TNT_Block brokenBlock3 = (TNT_Block) getOneIntersectingObject(TNT_Block.class);
        Actor block3 = getOneIntersectingObject(TNT_Block.class);
        if(block3 != null)
        {
            int brokenBlock3X = brokenBlock3.getX();
            int brokenBlock3Y = brokenBlock3.getY();
            getWorld().removeObject(block3);
            
            int newDirection9 = brokenBlock3Y + 40;
            int newDirection10 = brokenBlock3Y - 40;
            int newDirection11 = brokenBlock3X + 40;
            int newDirection12 = brokenBlock3X - 40;
            
            if(getY()<newDirection9)
            {
                y = -y;
            }
            
            if(getY()>newDirection10)
            {
                y = -y;
            }
            
            if(getX()<newDirection11)
            {
                x = -x;
            }
            
            if(getX()>newDirection12)
            {
                x = -x;
            }
            
            breakCount = breakCount + 1;
        }
    }
    
    private void resetBalls()
    {
        if(breakCount == 21)
        {
            Paddle finalBall = (Paddle) getOneIntersectingObject(Paddle.class);
            Actor paddle = getOneIntersectingObject(Paddle.class);
            if(paddle != null)
            {
                
            }
        }
    }
}
