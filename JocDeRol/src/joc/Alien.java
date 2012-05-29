package joc;

import ee.Put;

public class Alien extends Player {

	/**	METODES	**/
	public void attack(Player p) {
		if(this.getLife() < 0){ Put.ln("Estàs fora de combat"); return; }
		if(p.getLife() < 0){ Put.ln("No pots atacar un jugador fora de combat!!"); return; }
		if(p.name.equals(this.name)){ Put.ln("No pots atacar-te a tu mateix!!"); return; }
		if(this.life > 20){
			Put.ln(this.str() + " ataca a " + p.str());
			this.defensePoints = this.defensePoints/3;
			this.hit(p.attackPoints);
			p.hit(this.attackPoints*3);
			Put.ln("Resultat de l'atac: " + this.str() + "\\|/" + p.str() + "\n");
			this.defensePoints = this.defensePoints*3;
		}else{
			super.attack(p);
		}
	}
	
	/**	CONSTRUCTOR	**/
	public Alien() {
		super();
		Put.ln("He creat un Alien.");
	}
	
	public Alien(String name, int aP, int dP, int life) {
		super(name, aP, dP, life);
		Put.ln("He creat un Alien.");
	}
}
