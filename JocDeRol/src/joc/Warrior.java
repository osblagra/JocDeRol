package joc;

import ee.Put;

public class Warrior extends Human {

	/** METODES	**/
	protected void hit(int attackPoints) {
		if(this.defensePoints > attackPoints){
			Put.ln(this.name + " ha esquivat l'atac!!");
		}else{
			Put.noln(this.str() +" és atacat amb "+ attackPoints +" i es defén amb "+ this.defensePoints + ". ");
			if(attackPoints - this.defensePoints <= 5){
				Put.ln(this.name + " ha esquivat l'atac!!");
			}else{
				this.life = this.life - (attackPoints - this.defensePoints);
				if(this.life < 0)
					this.life = 0;
				Put.ln("Vides: " + this.life + "-" + (attackPoints - this.defensePoints) + " = " + this.life);
			}
		}
	}
	
	/**	CONSTRUCTOR	**/
	public Warrior() {
		super();
		Put.ln("He creat un Warrior.");
	}
	
	public Warrior(String name, int aP, int dP, int life) {
		super(name, aP, dP, life);
		Put.ln("He creat un warrior.");
	}
}
