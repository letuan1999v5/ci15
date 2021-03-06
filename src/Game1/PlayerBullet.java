package Game1;

import tklibs.SpriteUtils;

import java.awt.*;
import java.awt.image.BufferedImage;

public class PlayerBullet {
    BufferedImage image;
    Vector2D position;
    Vector2D velocity;

    public PlayerBullet() {
        image = SpriteUtils.loadImage("assets/images/player-bullets/52803602_249133272633254_17764607506513920_n.png");
        position = new Vector2D();
        velocity = new Vector2D(4, 4);
    }


    public void render(Graphics g) {
        g.drawImage(image,
                (int) position.x,
                (int) position.y,
                null);
    }

    public void run() {
        this.position.add(velocity.x, velocity.y);
    }
}
