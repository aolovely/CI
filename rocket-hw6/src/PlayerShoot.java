public class PlayerShoot implements GameObjectAttributes<Player> {

    private FrameCounter frameCounter;


    public PlayerShoot() {
        this.frameCounter = new FrameCounter(30);
    }

    @Override
    public void run(Player player) {
        if (this.frameCounter.run()) {
            BulletPlayer bulletPlayer = new BulletPlayer();
            bulletPlayer.position.set(player.position);
            bulletPlayer.velocity.set(player.playMove.velocity.copy().multiply(1.5f));
            GameObjectManager.instance.add(bulletPlayer);
            this.frameCounter.reset();
        }
    }
}
