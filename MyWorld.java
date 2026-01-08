import greenfoot.*;

public class MyWorld extends World {
    private Paddle paddle;
    private Ball ball;
    public MyWorld() {
        super(600, 400, 1);
        // add paddle
        paddle = new Paddle();
        addObject(paddle, 300, 350);
        
        ball = new Ball();
        addObject(ball, 300, 335);

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 7; j++) {
                int x = Greenfoot.getRandomNumber(12);
                
                if(x==1)
                {
                    TNT_Block block1 = new TNT_Block();
                    addObject(block1, 45 + j * 85, 50 + i * 85);
                }
                else if(x==2)
                {
                    Extra_Ball_Block block2 = new Extra_Ball_Block();
                    addObject(block2, 45 + j * 85, 50 + i * 85);
                }
                else
                {
                    Block block3 = new Block();
                    addObject(block3, 45 + j * 85, 50 + i * 85);
                }
            }
        }
    }
    // make game reset when ball touches ground
    
}
