package com.mygdx.game;

import com.mygdx.game.Screen.Choose_Tank;

public class Player {
	Choose_Tank tanks;
	Tank play_tank;
	int Tank_ID;

	public int getTank_ID() {
		return Tank_ID;
	}

	public Player(){
		Tank play_tank = tanks.choose();
	}

	public Player(int tanks1) {
		Tank_ID = tanks1;
	}
}

class Player1 extends Player{
	public Player1(){
		Tank p1_tank = tanks.choose();
	}
}

class Player2 extends Player{
	public Player2() {
		Tank p2_tank=tanks.choose();
	}
}


