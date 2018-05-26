import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class MenuScreen extends BaseScreen
{
    public void initialize()
    {
        BaseActor background = new BaseActor(0,0, mainStage);
        background.loadTexture( "images/neonbackground.png" );
        background.setSize(800,600);
        background.setTouchable(Touchable.enabled);

        background.addListener(new ClickListener(){
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                System.out.println("jh");
                event.handle();//the Stage will stop trying to handle this event
                return true; //the inputmultiplexer will stop trying to handle this touch
            }
        });

        BaseActor title = new BaseActor(0,0, mainStage);
        title.loadTexture( "images/coollogo_com-4995743.png" );
        title.centerAtPosition(400,300);
        title.moveBy(0,100);

        BaseActor start = new BaseActor(0,0, mainStage);
        start.loadTexture( "images/message-start.png" );
        start.centerAtPosition(400,300);
        start.moveBy(0,-100);

    }

    public void update(float dt)
    {
        if (Gdx.input.isKeyPressed(Keys.S))
            TicTac.setActiveScreen( new LevelScreen() );
    }
}