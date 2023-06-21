package com.mygdx.game.Screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.mygdx.game.MyGdxGame;

import static com.badlogic.gdx.scenes.scene2d.actions.Actions.*;
import static com.mygdx.game.MyGdxGame.gamecam;

public class P2_wins implements Screen {
    MyGdxGame game;
    private Texture t1;
    private TextureRegion region;
    private Stage stage;
    private Image p2_win;
    private OrthographicCamera camera;

    public P2_wins(MyGdxGame game) {
        this.game = game;
        t1=new Texture("p2_wins.png");
        p2_win=new Image(t1);
        region = new TextureRegion(t1, 0, 0, 32, 32);
        camera = new OrthographicCamera();
        stage = new Stage(new StretchViewport(1200, 630, camera));
        p2_win.setPosition(0,0);
        stage.addActor(p2_win);
    }


    @Override
    public void show() {
        Gdx.input.setInputProcessor(stage);
        p2_win.addAction((sequence(alpha(0),fadeIn(1f))));
        p2_win.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                dispose();
                game.setScreen(new LoadingScreen(game));
            }
        });
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        game.batch.setProjectionMatrix(gamecam.combined);
        update(delta);
        stage.draw();
        game.batch.begin();
        game.batch.end();
    }

    private void update(float delta) {
        stage.act(delta);
    }

    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width, height, true);
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        t1.dispose();
        stage.dispose();
    }
}

