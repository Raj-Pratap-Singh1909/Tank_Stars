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
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.MyGdxGame;

import static com.badlogic.gdx.scenes.scene2d.actions.Actions.*;

public class Resume_Game implements Screen{
	MyGdxGame game;
	private Texture bgimg;
	private TextureRegion region;
	private OrthographicCamera gamecam;
	private Stage stage;
	private Viewport gamePort;
	private Image load_games;

	public Resume_Game(MyGdxGame game){
		this.game = game;
		bgimg = new Texture("savedgames.png");
//		System.out.printf("Resume_Game created");
		load_games = new Image(bgimg);
//		System.out.println("MainMenuScreen created 2");
		region = new TextureRegion(bgimg, 0, 0, 32, 32);
		gamecam = new OrthographicCamera();
		gamePort = new StretchViewport(1120,630, gamecam);
		stage = new Stage(gamePort);
		load_games.setPosition(0,0);
		stage.addActor(load_games);
	}

	@Override
	public void show() {
		Gdx.input.setInputProcessor(stage);
//		System.out.println("show 2.1");
		load_games.addAction(sequence(alpha(0), fadeIn(2f)));
		load_games.addListener(new ClickListener(){
			@Override
			public void clicked(InputEvent event, float x, float y) {
				System.out.printf("Resume_Game clicked 2.3");
				game.setScreen(new MainMenuScreen(game));
//				dispose();
			}
		});
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		game.batch.setProjectionMatrix(gamecam.combined);
		update(delta);
		stage.draw();
		game.batch.begin();
		game.batch.end();
	}

	public void update(float delta){
		stage.act(delta);
//		stage.draw();
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
		bgimg.dispose();
		stage.dispose();
	}
}
