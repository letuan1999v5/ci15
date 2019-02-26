package Game1;

import tklibs.SpriteUtils;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.nio.Buffer;

public class Enemy {
    BufferedImage image;
    Vector2D position;
    Vector2D velocity;
    public Enemy(){
        image = SpriteUtils.loadImage("assets/images/enemies/level0/blue/0.png");
        position = new Vector2D(-50,-50);
        velocity = new Vector2D(4,4);
        velocity.setAngle(Math.PI/18);
    }
    public void render(Graphics g){
        g.drawImage(
                image,
                (int) position.x,
                (int) position.y,
                null
        );
    }
    public void run(){
        position.add(velocity.x,velocity.y);
        changeVelocity();
    }

    private void changeVelocity() {
        if(position.x>384-32&&velocity.x>0){
            velocity.set(-velocity.x,velocity.y);
        }
        if(position.x<0&&velocity.x<0){
            velocity.set(-velocity.x,velocity.y);
        }
        if(position.y>600-32&&velocity.y>0){
            velocity.set(velocity.x,-velocity.y);
        }
        if(position.y<0&&velocity.y<0){
            velocity.set(velocity.x,-velocity.y);
        }
    }
}
