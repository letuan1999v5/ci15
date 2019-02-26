package Game1;

import tklibs.SpriteUtils;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Player {
    BufferedImage image;
    BufferedImage bulletType2Image;

    Vector2D position;
    //    BufferedImage bulletImage;
//    //  Vector2D[] bulletPositions;
//    ArrayList<Vector2D> bulletPositions;
    ArrayList<PlayerBullet> bullets;
    ArrayList<Rocket> rockets;
    ArrayList<SpecialBullet> specials;
    int fireCount, fireCount1, fireCount2;

    public Player() {
        image = SpriteUtils.loadImage("assets/images/players/straight/2.png");
        position = new Vector2D(200, 500);
//        bulletImage = SpriteUtils.loadImage("assets/images/player-bullets/a/1.png");
//        bulletPositions = new ArrayList<>();
        bullets = new ArrayList<>();
        rockets = new ArrayList<>();
        specials = new ArrayList<>();
        bulletType2Image = SpriteUtils.loadImage("assets/images/player-bullets/bullet3.png");
        fireCount = 0;
        fireCount1 = 0;
        fireCount2 = 0;
    }

    public void render(Graphics g) {
        g.drawImage(image,
                (int) position.x,
                (int) position.y,
                null);
//        for (int i = 0; i < bulletPositions.size(); i++) {
//            Vector2D bulletPosition = bulletPositions.get(i);
//            g.drawImage(
//                    bulletImage,
//                    (int) bulletPosition.x,
//                    (int) bulletPosition.y,
//                    null);
//        }

        for (int i = 0; i < bullets.size(); i++) {
            PlayerBullet bullet = bullets.get(i);
            bullet.render(g);
        }
        for (int j = 0; j < rockets.size(); j++) {
            Rocket rocket = rockets.get(j);
            rocket.render(g);
        }
        for (int k = 0; k < specials.size(); k++) {
            SpecialBullet special = specials.get(k);
            special.render(g);
        }
    }

    private void playerMove() {
        if (GameWindow.isUpPress) {
            position.y -= 2;
        }
        if (GameWindow.isDownPress) {
            position.y += 2;
        }
        if (GameWindow.isLeftPress) {
            position.x -= 2;
        }
        if (GameWindow.isRightPress) {
            position.x += 2;
        }
    }

    private void bulletsRun() {
//        for (int i = 0; i < bulletPositions.size(); i++) {
//            Vector2D bulletPosition = bulletPositions.get(i);
//            bulletPosition.y -= 4;
//        }
        for (int j = 0; j < bullets.size(); j++) {
            PlayerBullet bullet = bullets.get(j);
            bullet.run();
        }
    }

    private void rocketsRun() {
        for (int k = 0; k < rockets.size(); k++) {
            Rocket rocket = rockets.get(k);
            rocket.run();
        }
    }

    private void specialsRun() {
        for (int l = 0; l < specials.size(); l++) {
            SpecialBullet special = specials.get(l);
            special.run();
        }
    }

    public void run() {
        playerMove();
        playerLimit();
        playerFire();
        bulletsRun();
        rocketsRun();
        specialsRun();
    }

    private void playerFire() {
        fireCount++;
        fireCount1++;
        fireCount2++;
        if (GameWindow.isFirePress && fireCount > 20) {
//            Vector2D bulletPosition = new Vector2D(position.x, position.y);
//            bulletPositions.add(bulletPosition);
            PlayerBullet bullet = new PlayerBullet();
            bullet.position.set(this.position.x, this.position.y);
            bullet.velocity.setAngle(-Math.PI * 0.5);
            bullets.add(bullet);

            PlayerBullet bullet2 = new PlayerBullet();
            bullet2.position.set(this.position.x, this.position.y);
            bullet2.velocity.setAngle(-Math.PI * 0.4);
            bullets.add(bullet2);

            PlayerBullet bullet3 = new PlayerBullet();
            bullet3.position.set(this.position.x, this.position.y);
            bullet3.velocity.setAngle(-Math.PI * 0.6);
            bullets.add(bullet3);

            PlayerBullet bullet4 = new PlayerBullet();
            bullet4.image = bulletType2Image;
            bullet4.position.set(this.position.x, this.position.y);
            bullet4.velocity.setAngle(-Math.PI * 0.55);
            bullets.add(bullet4);

            PlayerBullet bullet5 = new PlayerBullet();
            bullet5.image = bulletType2Image;
            bullet5.position.set(this.position.x, this.position.y);
            bullet5.velocity.setAngle(-Math.PI * 0.45);
            bullets.add(bullet5);

            PlayerBullet bullet7 = new PlayerBullet();
            bullet7.image = bulletType2Image;
            bullet7.position.set(this.position.x, this.position.y);
            bullet7.velocity.setAngle(-Math.PI * 0.35);
            bullets.add(bullet7);

            PlayerBullet bullet9 = new PlayerBullet();
            bullet9.image = bulletType2Image;
            bullet9.position.set(this.position.x, this.position.y);
            bullet9.velocity.setAngle(-Math.PI * 0.65);
            bullets.add(bullet9);

            PlayerBullet bullet6 = new PlayerBullet();
            bullet6.position.set(this.position.x, this.position.y);
            bullet6.velocity.setAngle(-Math.PI * 0.7);
            bullets.add(bullet6);

            PlayerBullet bullet8 = new PlayerBullet();
            bullet8.position.set(this.position.x, this.position.y);
            bullet8.velocity.setAngle(-Math.PI * 0.3);
            bullets.add(bullet8);

            fireCount = 0;
        }
        if (GameWindow.isRocketPress && fireCount1 > 200) {
            Rocket rocket = new Rocket();
            rocket.position.set(this.position.x, this.position.y);
            rocket.velocity.setAngle(-Math.PI * 0.5);
            rockets.add(rocket);
            fireCount1 = 0;
        }

        if (GameWindow.isSpecialPress && fireCount2 > 500) {
            SpecialBullet special = new SpecialBullet();
            special.position.set(-170,600);
            special.velocity.setAngle(-Math.PI * 0.5);
            specials.add(special);
            fireCount2 = 0;

            SpecialBullet special2 = new SpecialBullet();
            special2.position.set(-20, 600);
            special2.velocity.setAngle(-Math.PI * 0.5);
            specials.add(special2);
            fireCount2 = 0;

            SpecialBullet special3 = new SpecialBullet();
            special3.position.set(130, 600);
            special3.velocity.setAngle(-Math.PI * 0.5);
            specials.add(special3);
            fireCount2 = 0;
        }
    }

    private void playerLimit() {
        if (position.x <= 0) {
            position.x = 0;
        }
        if (position.x >= 384 - 32) {
            position.x = 384 - 32;
        }
        if (position.y <= 0) {
            position.y = 0;
        }
        if (position.y >= 600 - 48) {
            position.y = 600 - 48;
        }
    }
}
