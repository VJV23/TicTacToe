import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class LevelScreen extends BaseScreen
{
//    private Turtle turtle;
    private boolean win;
    private BaseActor board;
    private String symbol;
    private String[] grid;
    int[][] winCombo;
    private boolean winDisplayed;

    public void initialize()
    {
        Gdx.input.setInputProcessor(mainStage);
        board = new BaseActor(0,0, mainStage);
        board.loadTexture( "images/board.jpg" );
        board.setSize(800,600);
        board.setTouchable(Touchable.enabled);
        BaseActor.setWorldBounds(board);
        symbol = "X";
        winDisplayed = false;
        grid = new String[9];
        for (int i = 0; i < 9; i++) {
            grid[i] = "";
        }
        winCombo = new int[][]{
                {0,1,2},
                {3,4,5},
                {6,7,8},
                {0,3,6},
                {1,4,7},
                {2,5,8},
                {2,4,6},
                {0,4,8}
        };
        board.addListener(new ClickListener(){
            public void clicked (InputEvent event, float x, float y) {
                if(!win) {
                    int pos = 0;
                    boolean placed = false;
                    if (x < 290 && y < 220) {
                        pos = 0;
                        if (grid[pos].equals("")) {
                            placed = true;
                            new Symbol(symbol, 150, 120, mainStage);
                        }
                    } else if (x < 290 && y < 375) {
                        pos = 1;
                        if (grid[pos].equals("")) {
                            placed = true;
                            new Symbol(symbol, 150, 275, mainStage);
                        }
                    } else if (x < 290) {
                        pos = 2;
                        if (grid[pos].equals("")) {
                            placed = true;
                            new Symbol(symbol, 150, 445, mainStage);
                        }
                    } else if (x < 510 && y < 220) {
                        pos = 3;
                        if (grid[pos].equals("")) {
                            placed = true;
                            new Symbol(symbol, 370, 120, mainStage);
                        }
                    } else if (x < 510 && y < 375) {
                        pos = 4;
                        if (grid[pos].equals("")) {
                            placed = true;
                            new Symbol(symbol, 370, 275, mainStage);
                        }
                    } else if (x < 510) {
                        pos = 5;
                        if (grid[pos].equals("")) {
                            placed = true;
                            new Symbol(symbol, 370, 445, mainStage);
                        }
                    } else if (y < 220) {
                        pos = 6;
                        if (grid[pos].equals("")) {
                            placed = true;
                            new Symbol(symbol, 600, 120, mainStage);
                        }
                    } else if (y < 375) {
                        pos = 7;
                        if (grid[pos].equals("")) {
                            placed = true;
                            new Symbol(symbol, 600, 275, mainStage);
                        }
                    } else {
                        pos = 8;
                        if (grid[pos].equals("")) {
                            placed = true;
                            new Symbol(symbol, 600, 445, mainStage);
                        }
                    }
                    if (placed) {
                        grid[pos] = symbol;
                        switchSymbol();
                        checkWin();
                    }
                }
            }
        });
        win = false;
    }

    private void switchSymbol(){
        if (symbol.equals("X")) {
            symbol = "O";
        } else {
            symbol = "X";
        }
    }

    public void checkWin(){
        for (int i = 0; i < 8; i++) {
            if(grid[winCombo[i][0]].equals("X") && grid[winCombo[i][1]].equals("X") && grid[winCombo[i][2]].equals("X")){
                System.out.println("X WIN");
                win = true;
            }
            if(grid[winCombo[i][0]].equals("O") && grid[winCombo[i][1]].equals("O") && grid[winCombo[i][2]].equals("O")){
                System.out.println("O WIN");
                win = true;
            }
        }
    }

    public void update(float dt)
    {
//        board.act(dt);
       if (win && !winDisplayed)
        {
            winDisplayed = true;
            switchSymbol();
            BaseActor youWinMessage = new BaseActor(0,0,uiStage);
            youWinMessage.loadTexture("images/"+symbol+"Win.png");
            youWinMessage.centerAtPosition(400,300);
            youWinMessage.setOpacity(0);
            youWinMessage.addAction( Actions.delay(0));
            youWinMessage.addAction( Actions.after( Actions.fadeIn(1f) ) );
        }
    }
}