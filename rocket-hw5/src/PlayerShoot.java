import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class PlayerShoot implements Attack {

    public List<BulletPlayer> bulletPlayers;
    private Counter counter;


    public PlayerShoot() {
        this.bulletPlayers = new ArrayList<>();
        this.counter = new Counter(30);
    }

//    @Override
//    public void run(Player player) {
//        if (this.counter.run()) {
//            BulletPlayer bulletPlayer = new BulletPlayer();
//            bulletPlayer.position.set(player.position);
//            bulletPlayer.velocity.set(player.velocity.copy().multiply(1.5f));
//            this.bulletPlayers.add(bulletPlayer);
//            this.counter.reset();
//        }
//        this.bulletPlayers.forEach(bulletPlayer ->  bulletPlayer.run());
//
//    }

    @Override
    public void run(GameObject gameObject) {
        if (this.counter.run()) {
            BulletPlayer bulletPlayer = new BulletPlayer();
            bulletPlayer.position.set(((Player)gameObject).position);
            bulletPlayer.velocity.set(((Player)gameObject).velocity.copy().multiply(1.5f));
            this.bulletPlayers.add(bulletPlayer);
            this.counter.reset();
        }
        this.bulletPlayers.forEach(bulletPlayer ->  bulletPlayer.run());
    }

    @Override
    public void render(Graphics graphics) {
        this.bulletPlayers.forEach(bulletPlayer -> bulletPlayer.render(graphics));
    }
}
