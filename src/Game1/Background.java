package Game1;

import tklibs.SpriteUtils;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Background {
    BufferedImage image;
    Vector2D position;
    public Background() {
        image = SpriteUtils.loadImage("assets/images/background/0.png");
        position = new Vector2D(0, 600 - 3109);
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
         //background move
        if (position.y <= 0) {
            position.y += 2;
        }
        if (position.y>0){
            position.y=600-3109;
        }
    }
}
