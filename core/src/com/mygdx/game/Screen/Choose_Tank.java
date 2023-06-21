package com.mygdx.game.Screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
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
import com.mygdx.game.Tank;

import static com.badlogic.gdx.scenes.scene2d.actions.Actions.*;

public class Choose_Tank implements Screen {
	Tank t1,t2,t3;
	MyGdxGame game;
	private Texture texture1,texture2,texture3,texture4;
	private TextureRegion region;
	private OrthographicCamera gamecam;
	private Stage stage;
	private Viewport gamePort;
	private Image tank1_image,tank2_image,tank3_image,choose_image;

	private Choose_Tank tank_p1, tank_p2;
	int i=0;

	public Tank choose(){
		return t1;
	}


	public Choose_Tank(MyGdxGame game) {
		this.game = game;
		i=0;
		texture1 = new Texture("tank1.png");
		tank1_image = new Image(texture1);
		texture2 = new Texture("tank2.png");
		tank2_image = new Image(texture2);
		texture3 = new Texture("tank3.png");
		tank3_image = new Image(texture3);
		texture4 = new Texture("Choose.png");
		choose_image = new Image(texture4);

		region = new TextureRegion(texture1, 0, 0, 32, 32);
		gamecam = new OrthographicCamera();
		gamePort = new StretchViewport(1200,675, gamecam);
		stage = new Stage(gamePort);

		tank1_image.setPosition(0, 0);
		tank2_image.setPosition(0, 0);
		tank3_image.setPosition(0, 0);

//		stage.addActor(tank3_image);
//		stage.addActor(tank2_image);
//		stage.addActor(tank1_image);
//		stage.addActor(choose_image);
	}

	public Choose_Tank(MyGdxGame game,int i) {
		this.game = game;
		this.i = i;
		texture1 = new Texture("tank1.png");
		tank1_image = new Image(texture1);
		texture2 = new Texture("tank2.png");
		tank2_image = new Image(texture2);
		texture3 = new Texture("tank3.png");
		tank3_image = new Image(texture3);
		texture4 = new Texture("Choose.png");
		choose_image = new Image(texture4);

		region = new TextureRegion(texture1, 0, 0, 32, 32);
		gamecam = new OrthographicCamera();
		gamePort = new StretchViewport(1200,675, gamecam);
		stage = new Stage(gamePort);

		tank1_image.setPosition(0, 0);
		tank2_image.setPosition(0, 0);
		tank3_image.setPosition(0, 0);
	}

	@Override
	public void show() {
		Gdx.input.setInputProcessor(stage);
		Player p1 = new Player(tanks1());
//		System.out.printf("\np1: %d\n",	p1.getTank_ID());
//		game.setScreen(new NewGame(game,p1,p2));
//		int i = 0;
//		Player p1 = new Player();
//		Player p2 = new Player();

//		tank1_image.addAction(sequence(alpha(0), fadeIn(1f)));
//		tank1_image.addListener(new ClickListener(){
//			@Override
//			public void clicked(InputEvent event,float x,float y){
//				tanks2();
//			}
//		});
//		tank2_image.addAction(sequence(alpha(0), fadeIn(1f)));
//		tank3_image.addAction(sequence(alpha(0), fadeIn(1f)));
//		choose_image.addAction(sequence(alpha(0), fadeIn(1f)));
//		System.out.println("show 2.1");
//		choose_image.addAction(sequence(alpha(0), fadeIn(1f)));
//		while(!choose_image.addListener(new ClickListener(){
//			@Override
//			public void clicked(InputEvent event, float x, float y) {
//				System.out.println("show 2.2");
////				game.setScreen(new NewGame(game));
////				dispose();
//			}
//		})){
//			System.out.println("show ghfvbwe");
//		}
//		while (!choose_image.hasActions()) {
//			tank1_image.addAction(sequence(alpha(0), fadeIn(1f)));
////			tank2_image.addAction(sequence(alpha(0), fadeIn(1f)));
////			tank3_image.addAction(sequence(alpha(0), fadeIn(1f)));
//		}
//		load_games.addAction(sequence(alpha(0), fadeIn(2f)));
//		load_games.addListener(new ClickListener(){
//			@Override
//			public void clicked(InputEvent event, float x, float y) {
//				System.out.printf("Resume_Game clicked 2.3");
//				game.setScreen(new MainMenuScreen(game));
////				dispose();
//			}
//		});

	}

	private int tanks1() {
		stage.addActor(tank1_image);
		stage.addActor(choose_image);
		choose_image.setPosition(gamePort.getWorldWidth() - choose_image.getWidth(), 0);
		tank1_image.addAction(sequence(alpha(0), fadeIn(1f)));
		tank1_image.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				tank1_image.remove();
				choose_image.remove();
				tanks2();
				return;
			}
		});
		choose_image.addAction(sequence(alpha(0), fadeIn(1f)));
		choose_image.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				if (i == 0) {
//					System.out.printf("Tank 1 choosen by player 1\n");
					game.setScreen(new Choose_Tank(game, 1));
					return;
				} else {
//					System.out.printf("Tank 1 choosen by player 2\n");
//					tank1_image.remove();
//					choose_image.remove();
//					game.setScreen(new NewGame(game, new Player(1), new Player(1)));
//					game.setScreen(new StartGame(game, new Player(i), new Player(1)));
					game.setScreen(new PlayGame(game, new Player(i), new Player(1)));


					return;
				}
//				game.setScreen(new PlayGame(game));

//				System.out.printf("tanks1 2");
//				System.out.printf("TANK 1 SELECTED and it is %d\n", value[0]);
//				return;
//				game.setScreen(new NewGame(game));
//				dispose();
			}
		});
//		System.out.printf("olkbhjfdtcf 111111");
		return 1;
	}

	private int tanks2() {
		stage.addActor(tank2_image);
		stage.addActor(choose_image);
		choose_image.setPosition(gamePort.getWorldWidth() - choose_image.getWidth(), 0);
		tank2_image.addAction(sequence(alpha(0), fadeIn(1f)));
		tank2_image.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				tank2_image.remove();
				choose_image.remove();
				tanks3();
				return;
			}
		});
		choose_image.addAction(sequence(alpha(0), fadeIn(1f)));
		choose_image.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				if (i == 0) {
//					System.out.printf("Tank 2 choosen by player 1\n");
					game.setScreen(new Choose_Tank(game, 2));
					return;
				} else {
//					System.out.printf("Tank 2 choosen by player 2\n");
//					tank2_image.remove();
//					choose_image.remove();
					game.setScreen(new PlayGame(game, new Player(i), new Player(2)));
					return;
				}



//				System.out.printf("Tank 2 choosen\n");
//				game.setScreen(new PlayGame(game));

//				System.out.printf("TANK 2 SELECTED and it is %d\n", value[0]);
//				System.out.printf("tanks2 2");
//				System.out.printf("TANK SELECTED : ");
//				return;

//				game.setScreen(new NewGame(game));
//				dispose();
			}
		});
		return 2;
	}

	private int tanks3() {
		stage.addActor(tank3_image);
		stage.addActor(choose_image);
		choose_image.setPosition(gamePort.getWorldWidth() - choose_image.getWidth(), 0);
		tank3_image.addAction(sequence(alpha(0), fadeIn(1f)));
		tank3_image.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				tank3_image.remove();
				choose_image.remove();
				tanks1();
				return;
			}
		});
		choose_image.addAction(sequence(alpha(0), fadeIn(1f)));
		choose_image.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				if (i == 0) {
//					System.out.printf("Tank 3 choosen by player 1\n");
					game.setScreen(new Choose_Tank(game, 3));
					return;
				} else {
//					System.out.printf("Tank 3 choosen by player 2\n");
					game.setScreen(new PlayGame(game, new Player(i), new Player(3)));
					return;
				}

//				System.out.printf("tanks3 2\n");
//				System.out.printf("TANK 3 SELECTED and it is %d\n", value[0]);
//				return;
//				game.setScreen(new NewGame(game));
//				dispose();
			}
		});
		return 3;
	}


//	private void tanks2() {
//		stage.addActor(tank2_image);
//		stage.addActor(choose_image);
//		tank2_image.addAction(sequence(alpha(0), fadeIn(1f)));
////		System.out.printf("tanks2 1");
//		tank2_image.addListener(new ClickListener() {
//			@Override
//			public void clicked(InputEvent event, float x, float y) {
//				tanks3();
//			}
//		});
//	}
//	private void tanks3() {
//		stage.addActor(tank3_image);
//		stage.addActor(choose_image);
//		System.out.printf("tanks3 1");
//		tank3_image.addAction(sequence(alpha(0), fadeIn(1f)));
//		tank3_image.addListener(new ClickListener() {
//			@Override
//			public void clicked(InputEvent event, float x, float y) {
//				show();
////				choose_image.addAction(sequence(alpha(0), fadeIn(1f)));
////				choose_image.addListener(new ClickListener() {
////					@Override
////					public void clicked(InputEvent event, float x, float y) {
////						game.setScreen(new NewGame(game));
////						dispose();
////					}
////				});
//			}
//		});
//	}
	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(Gdx.gl.GL_COLOR_BUFFER_BIT);
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
		stage.dispose();
		texture1.dispose();
		texture2.dispose();
		texture3.dispose();
		texture4.dispose();

	}
}
