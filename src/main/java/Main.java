import com.fangzhe.entity.Player;

public class Main {
    public static void main(String[] args) {
            Player player = new Player();

            player.startGame();
            player.parachute();

            player.move("left");
            player.postureChange(Player.RUN);

    }
}
