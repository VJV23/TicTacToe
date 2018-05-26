import com.badlogic.gdx.Game;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;

public class Main {
    public static void main (String[] args)
    {
        Game myGame = new TicTac();
        LwjglApplication launcher = new LwjglApplication( myGame, "TicTacToe", 800, 600 );
    }
}
