import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;

public class Symbol extends BaseActor
{
    public boolean collected;

    public Symbol(String symbol, float x, float y, Stage s)
    {
        super(x,y,s);

        loadTexture("images/"+symbol+".png");

      //  Action spin = Actions.rotateBy(30, 1);
        // this.addAction( Actions.forever(spin) );
        setBoundaryPolygon(8);
        setSize(50,50);
        collected = false;
    }



}