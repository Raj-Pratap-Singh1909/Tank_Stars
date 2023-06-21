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
import com.mygdx.game.Player;

import static com.badlogic.gdx.scenes.scene2d.actions.Actions.*;


public class Pause_Screen implements Screen {
	PlayGame prev_game;
	MyGdxGame game;
	private Texture texture1, texture2, texture4;
	private TextureRegion region;

	private OrthographicCamera gamecam;
	private Stage stage;
	private Viewport gamePort;
	private Player player1, player2;

	private Image sky2_image, resume_image, exit_image;

	public Pause_Screen(MyGdxGame game, Player tank1, Player tank2,PlayGame g1) {
		this.game = game;
		this.player1 = tank1;
		this.player2 = tank2;
		this.prev_game=g1;
		texture1 = new Texture("bg2.png");
		sky2_image = new Image(texture1);

		texture2 = new Texture("Resume.png");
		resume_image = new Image(texture2);


		texture4 = new Texture("EXIT_GAME.png");
		exit_image = new Image(texture4);

		region = new TextureRegion(texture1, 0, 0, 32, 32);
		gamecam = new OrthographicCamera();
		gamePort = new StretchViewport(1920, 1080, gamecam);
		stage = new Stage(gamePort);

		sky2_image.setPosition(0, 0);
		resume_image.setPosition(800, 800);
		exit_image.setPosition(800, 400);

		stage.addActor(sky2_image);
		stage.addActor(resume_image);
		stage.addActor(exit_image);


	}

	@Override
	public void show() {
		Gdx.input.setInputProcessor(stage);
		sky2_image.addAction(sequence(alpha(0), fadeIn(1.02f)));
		sky2_image.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
//				System.out.printf("CLICKED ON SKY");
//				game.setScreen(new PlayGame(game));
//				dispose();
			}
		});
		resume_image.addAction(sequence(alpha(0), fadeIn(1.02f)));
		resume_image.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				game.setScreen(prev_game);
//				dispose();
			}
		});

		exit_image.addAction(sequence(alpha(0), fadeIn(1.02f)));
		exit_image.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
//                System.out.printf("CLICKED ON EXIT GAME");
                game.setScreen(new MainMenuScreen(game));
            }
        });
	}

	@Override
	public void render(float delta) {
		// TODO Auto-generated method stub
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		game.batch.begin();
		game.batch.draw(texture1, 0, 0);
		game.batch.end();
		stage.act();
		stage.draw();
	}

	public void update(float delta) {
		stage.act(delta);
	}


	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub

	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub

	}

	@Override
	public void dispose() {
		texture1.dispose(); texture2.dispose(); texture4.dispose();
		stage.dispose();
	}
}