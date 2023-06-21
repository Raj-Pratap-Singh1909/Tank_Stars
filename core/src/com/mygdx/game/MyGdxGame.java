package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.Screen.LoadingScreen;

public class MyGdxGame extends Game {
	public static final int V_WIDTH = 786;
	public static final int V_HEIGHT = 461;
	public SpriteBatch batch;
	public BitmapFont font;
	Texture img;

	public static OrthographicCamera gamecam;

	
	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("Untitled.png");

		font = new BitmapFont();
		gamecam = new OrthographicCamera();
		gamecam.setToOrtho(false, V_WIDTH, V_HEIGHT);
		img.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
		setScreen(new LoadingScreen(this));
	}

	@Override
	public void render () {
		super.render();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
		font.dispose();
	}
}
