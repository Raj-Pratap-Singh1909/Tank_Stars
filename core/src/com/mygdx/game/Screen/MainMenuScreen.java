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

public class MainMenuScreen implements Screen {

	MyGdxGame game;
	private Texture texture,texture2,texture4;
	private TextureRegion region;

	private OrthographicCamera gamecam;
	private Stage stage;
	private Viewport gamePort;

	private Texture gameplayscreen;
	private Image gameplayscreen_image,start_image, exit_image;
//	private OrthographicCamera gamecam;
//	public MainMenuScreen(MyGdxGame game) {
//		this.game = game;
//		System.out.printf("MainMenuScreen created");
//
//	}

public MainMenuScreen(MyGdxGame game) {
	this.game = game;
	texture = new Texture("gameplayscreen1.jpg");
	gameplayscreen_image = new Image(texture);

	texture2 = new Texture("new_game.png");
	start_image = new Image(texture2);

	texture4 = new Texture("exit.png");
	exit_image = new Image(texture4);

	region = new TextureRegion(texture, 0, 0, 32, 32);
	gamecam = new OrthographicCamera();
	gamePort = new StretchViewport(3840,2160, gamecam);
	stage = new Stage(gamePort);

	gameplayscreen_image.setPosition(0,0);
	start_image.setPosition(400,1500);
	exit_image.setPosition(400,1000);

	stage.addActor(gameplayscreen_image);
	stage.addActor(start_image);
	stage.addActor(exit_image);

//		gamePort = new FitViewport(MyGdxGame.V_WIDTH, MyGdxGame.V_HEIGHT, gamecam);
}

	@Override
	public void show() {
		Gdx.input.setInputProcessor(stage);
		gameplayscreen_image.addAction(sequence(alpha(0), fadeIn(2f)));
		gameplayscreen_image.addListener(
				new ClickListener() {

			@Override
			public void clicked(InputEvent event, float x, float y) {
//				System.out.printf("MainMenuScreen clicked 2.3");
//				game.setScreen(new MainMenuScreen(game));
			}
		});

        new_game();
		exit_game();

		exit_image.addAction(sequence(alpha(0), fadeIn(2f)));
		exit_image.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
//				System.out.printf("MainMenuScreen clicked 2.3 Exit");
				game.setScreen(new LoadingScreen(game));
			}
		});
	}

	private void new_game() {
		start_image.addAction(sequence(alpha(0), fadeIn(2f)));
		start_image.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
//				System.out.printf("MainMenuScreen clicked 2.3 New Game");
				game.setScreen(new Choose_Tank(game));
			}
		});
	}


	private void exit_game(){
		exit_image.addAction(sequence(alpha(0), fadeIn(2f)));
		exit_image.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				game.setScreen(new LoadingScreen(game));
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
		texture.dispose();
		stage.dispose();
	}
}
