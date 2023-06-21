package com.mygdx.game;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

import static com.badlogic.gdx.scenes.scene2d.actions.Actions.*;

public class Tank extends Sprite implements Screen {
	 private Texture bomb;
	 private Body bullet;

	private Stage stage;

	private int health=100,fuel=200;

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public int getFuel() {
		return fuel;
	}

	public void setFuel(int fuel) {
		this.fuel = fuel;
	}

	private World universe;
	private Body tank_b;
	private Texture tankimage;
	private Image tankimage2,bombimage;
	private CircleShape fig;

	public Texture getBomb() {
		return bomb;
	}

	public void setBomb(Texture bomb) {
		this.bomb = bomb;
	}

	public Body getBullet() {
		return bullet;
	}

	public void setBullet(Body bullet) {
		this.bullet = bullet;
	}

	public Stage getStage() {
		return stage;
	}

	public void setStage(Stage stage) {
		this.stage = stage;
	}

	public World getUniverse() {
		return universe;
	}

	public void setUniverse(World universe) {
		this.universe = universe;
	}

	public Body getTank_b() {
		return tank_b;
	}

	public void setTank_b(Body tank_b) {
		this.tank_b = tank_b;
	}

	public Texture getTankimage() {
		return tankimage;
	}

	public void setTankimage(Texture tankimage) {
		this.tankimage = tankimage;
	}

	public Image getTankimage2() {
		return tankimage2;
	}

	public void setTankimage2(Image tankimage2) {
		this.tankimage2 = tankimage2;
	}

	public Image getBombimage() {
		return bombimage;
	}

	public void setBombimage(Image bombimage) {
		this.bombimage = bombimage;
	}

	public CircleShape getFig() {
		return fig;
	}

	public void setFig(CircleShape fig) {
		this.fig = fig;
	}

	public BodyDef getDef_b() {
		return def_b;
	}

	public void setDef_b(BodyDef def_b) {
		this.def_b = def_b;
	}

	private BodyDef def_b;

	public Tank(World w1,int var,Stage stage){
		this.universe=w1;
		this.stage=stage;
		def_b= new BodyDef();
//		maketank(int var);
		def_b.type= BodyDef.BodyType.DynamicBody;
		if(var==1){
			def_b.position.set(200, 300);
			tank_b=universe.createBody(def_b);
			FixtureDef fix= new FixtureDef();
			fig= new CircleShape();
//		fig.setPosition(Vector2(500,500));
			fig.setRadius(5);
			fix.shape= fig;
			tank_b.createFixture(fix);
//			System.out.println(tank_b.getPosition().x);
//			System.out.println(tank_b.getPosition().y);
		}
		else{
			def_b.position.set(1000, 300);
			tank_b=universe.createBody(def_b);
			FixtureDef fix= new FixtureDef();
			fig= new CircleShape();
//		fig.setPosition(Vector2(500,500));
			fig.setRadius(5);
			fix.shape= fig;
			tank_b.createFixture(fix);
//			System.out.println(tank_b.getPosition().x);
//			System.out.println(tank_b.getPosition().y);
		}
	}

	public void shoot(double angle,Stage stage,int opt){

		def_b.position.set(this.tank_b.getPosition().x,this.tank_b.getPosition().y);
//		System.out.printf("THIS IS SHOOT\n");
		bullet = universe.createBody(def_b);
		FixtureDef fix2= new FixtureDef();
		CircleShape fig2= new CircleShape();
		fig2.setRadius(1);
		fix2.shape=fig2;
		bullet.createFixture(fix2);
		double rad = Math.toRadians(angle);
		double x= Math.cos(rad);
		double y=Math.sin(rad);
		if(opt==1){
			bullet.setLinearVelocity((float)x*75,(float)y*75);
		}
		else{
			bullet.setLinearVelocity((float)x*(-90),(float)y*75);
		}
		bomb=new Texture("bomb.png");
		bombimage = new Image(bomb);
		bombimage.setSize(bomb.getWidth()/20,bomb.getHeight()/20);
		bombimage.setPosition((int)bullet.getPosition().x,(int)bullet.getPosition().y);
		stage.addActor(bombimage);
		bombimage.addAction(sequence(alpha(0), fadeIn(2f)));
		if (bullet.getPosition().x > 1150 || bullet.getPosition().x < 0 || bullet.getPosition().y > 600 || bullet.getPosition().y < 0) {
            universe.destroyBody(bullet);
            bombimage.remove();
        }
	}

	public void move(){
	}

	@Override
	public void show() {

	}

	@Override
	public void render(float delta) {
//		bomb.
//		System.out.println("HELLO");
	}

	@Override
	public void resize(int width, int height) {

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
