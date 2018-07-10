package game.player;

import base.GameObject;
import base.GameObjectManager;
import base.Vector2D;
import game.enemy.BulletEnemy;
import game.enemy.Enemy;
import physic.BoxCollider;
import physic.Collider;
import renderer.ImageRenderer;

public class BulletPlayer extends GameObject implements Collider {

    public Vector2D velocity;
    public BoxCollider boxCollider;

    public BulletPlayer() {
        this.velocity = new Vector2D();
        this.renderer = new ImageRenderer("resources/images/circle.png", 8, 8);
        this.boxCollider = new BoxCollider(8,8);
    }

    @Override
    public void run() {
        super.run();
        this.position.addUp(this.velocity);
        this.boxCollider.position.set(this.position.x - 4, this.position.y - 4);
        Enemy enemy = GameObjectManager.instance.checkCollsion(this);
        if(enemy != null){
            //dang va cham
            enemy.isAlive = false;
            this.isAlive = false;
        }
    }

    @Override
    public void hit(GameObject gameObject) {
        if (gameObject instanceof Enemy || gameObject instanceof BulletEnemy)
            this.isAlive =false;
    }

    @Override
    public BoxCollider getBoxCollider() {
        return this.boxCollider;
    }
}
