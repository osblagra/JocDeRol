package joc;

import ee.Put;

	public class Human extends Player{
	
		/** METODES	**/
		void maxVida() {this.life = 100;}
		static int maxVida1(int life) {if(life > 100) return 100; else return life;}
		/**	CONSTRUCTOR	**/
		public Human() {
			super(); //Modificar
			if(this.life > 100)
				maxVida();
			Put.ln("He creat un Human.");
		}
		
		public Human(String name, int aP, int dP, int life) {
			super(name, aP, dP, maxVida1(life));
			Put.ln("He creat un Human.");
		}
	}
