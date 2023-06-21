package com.mygdx.game.Screen;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.MyGdxGame;

import java.util.ArrayList;

import static com.badlogic.gdx.scenes.scene2d.actions.Actions.*;
import static com.mygdx.game.MyGdxGame.gamecam;


import static java.lang.Thread.sleep;

public class LoadingScreen implements Screen {

	MyGdxGame game;
	private Texture texture,texture2,play_button_active,play_button_inactive,exit_button_active,exit_button_inactive;
	private TextureRegion region;
	Rectangle Tanks;
	ArrayList<Rectangle> Weapons;

	private Viewport gamePort;

	private Stage stage;

	private Image play_button_active_image,tankstars_loading_image;

	private OrthographicCamera camera;



	public LoadingScreen(MyGdxGame game) {
		this.game = game;
		texture = new Texture("Untitled.gif");
		tankstars_loading_image = new Image(texture);

		texture2 = new Texture("Tankstars.png");
		play_button_active = new Texture("play_button_active.png");

		play_button_inactive = new Texture("play_button_inactive.png");
		play_button_active_image = new Image(play_button_active);
		exit_button_active = new Texture("exit_button_active.png");
		exit_button_inactive = new Texture("exit_button_inactive.png");
		region = new TextureRegion(texture, 0, 0, 32, 32);
		gamecam = new OrthographicCamera();
//		stage = new Stage(new StretchViewport(MyGdxGame.V_WIDTH, MyGdxGame.V_HEIGHT, gamecam));
		stage = new Stage(new StretchViewport(1200, 630, gamecam));

		tankstars_loading_image.setPosition(0,0);
//		play_button_active_image.setPosition(0, 0);

		stage.addActor(tankstars_loading_image);
//		stage.addActor(play_button_active_image);
//



//		gamePort = new FitViewport(MyGdxGame.V_WIDTH, MyGdxGame.V_HEIGHT, gamecam);
	}

	@Override
	public void show() {
		Gdx.input.setInputProcessor(stage);
//		System.out.println("show 1.1");
//		System.out.printf("show 1.2");
		tankstars_loading_image.addAction((sequence(alpha(0),fadeIn(1f))));
		tankstars_loading_image.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				dispose();
				game.setScreen(new MainMenuScreen(game));
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

	@Override
	public void resize(int width, int height) {
		stage.getViewport().update(width, height, true);
	}

	private void update(float delta) {
		stage.act(delta);
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
		texture2.dispose();
		play_button_active.dispose();
		play_button_inactive.dispose();
		exit_button_active.dispose();
		exit_button_inactive.dispose();
		stage.dispose();
	}
}
