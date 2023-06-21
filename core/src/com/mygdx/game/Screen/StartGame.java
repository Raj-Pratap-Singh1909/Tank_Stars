package com.mygdx.game.Screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.Player;
import com.badlogic.gdx.Input.Keys;
//class Input implements
public class StartGame implements Screen {
	private World world;
	private Box2DDebugRenderer dbg_reder;
	private OrthographicCamera gamecam;
	private MyGdxGame game;
	public StartGame(MyGdxGame game, Player player, Player player1) {
		this.game = game;

	}

	@Override
	public void show() {
		world = new World(new Vector2(0,-9.81f),true);
		dbg_reder = new Box2DDebugRenderer();
		gamecam = new OrthographicCamera(Gdx.graphics.getWidth()/10,Gdx.graphics.getHeight()/10);

        Gdx.input.setInputProcessor(new Input() {
			@Override
			public boolean keyDown(int keyinput) {
				if (keyinput == Keys.ESCAPE) {
					((MyGdxGame) Gdx.app.getApplicationListener()).setScreen(new MainMenuScreen((game)));
				}
				return true;
			}

			@Override
			public boolean keyUp(int keycode) {
				return false;
			}

			@Override
			public boolean keyTyped(char character) {
				return false;
			}

			@Override
			public boolean touchDown(int screenX, int screenY, int pointer, int button) {
				return false;
			}

			@Override
			public boolean touchUp(int screenX, int screenY, int pointer, int button) {
				return false;
			}

			@Override
			public boolean touchDragged(int screenX, int screenY, int pointer) {
				return false;
			}

			@Override
			public boolean mouseMoved(int screenX, int screenY) {
				return false;
			}

//			@Override
//			public boolean scrolled(int amount) {
//				return false;
//			}
		});

		/////////////////TANKS/////////////////////
		//BODY
		BodyDef bodyDef = new BodyDef();
		bodyDef.type = BodyDef.BodyType.DynamicBody;
		bodyDef.position.set(0,10);


		//SHAPE
		PolygonShape Tank = new PolygonShape();
		Tank.setAsBox(2,2);

//		CircleShape circle = new CircleShape();
//		circle.setRadius(1);
//		circle.setPosition(new Vector2(0,2));

//		Tank.setPosition(new Vector2(5,5));
//		Tank.setRadius(0.5f);

		//FIXTURE
		FixtureDef fixtureDef = new FixtureDef();
		fixtureDef.shape = Tank;
		fixtureDef.density = 1f;
		fixtureDef.friction = 0.5f;
		fixtureDef.restitution = 0.5f;

		world.createBody(bodyDef).createFixture(fixtureDef);
		Tank.dispose();

		/////////////////GROUND/////////////////////
		//BODY
//		BodyDef bodyDef1 = new BodyDef();
		bodyDef.type = BodyDef.BodyType.StaticBody;
		bodyDef.position.set(0,0);

		//SHAPE
		ChainShape ground = new ChainShape();
		ground.createChain(new Vector2[] {new Vector2(-10,0),new Vector2(10,0)});

		//FIXTURE
		fixtureDef.shape = ground;
		fixtureDef.density = 1f;
		fixtureDef.friction = 0.5f;
		fixtureDef.restitution = 0f;

		world.createBody(bodyDef).createFixture(fixtureDef);

}



	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0,0,0,1);
		Gdx.gl.glClear(Gdx.gl.GL_COLOR_BUFFER_BIT);
		dbg_reder.render(world,gamecam.combined);
		world.step(1/60f,6,2);

	}

	public void update(float delta) {
		gamecam.update();
	}

	@Override
	public void resize(int width, int height) {
		gamecam.viewportWidth = width/10;
		gamecam.viewportHeight = height/10;
		gamecam.update();
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

	}
}
