package joc;

import java.util.ArrayList;
import java.util.Iterator;

import ee.Put;
import ee.Read;

public class Player {

	/** ATRIBUTS	**/
	String name;
	protected int life, defensePoints, attackPoints;
	private ArrayList <Team> teams = new ArrayList <Team> (1);
	private ArrayList <Item> items = new ArrayList <Item> (1);
	
	/**	METODES	**/
	public void setLife() {this.life = 100;}
	public void addTeam(Team t) {if(!this.checkTeams(t)){teams.add(t); t.add(this);}} /** Afig un equip a la llista del jugador **/
	public void removeTeam(Team t) {if(this.checkTeams(t)){teams.remove(t); t.remove(this);}} /** Elimina un equip de la llista del jugador **/
	public void addItem(Item i) {if(!this.checkItems(i)) items.add(i);}	/** Afig un objecte al jugador **/
	public void removeItem(Item i) {if(this.checkItems(i)) items.remove(i);} /** Elimina l'objecte de la llista del jugador **/
	public boolean checkItems(Item i) {return items.contains(i);} /** Comprova si el jugador ja te assignat l'objecte **/
	public boolean checkTeams(Team t) {return teams.contains(t);} /** Comprova si l'equip passat com a paràmetre es a la llista del jugador **/
	public String getName() {return this.name;} /** Retorna el nom **/
	public int getAttackPoints() {return this.attackPoints;} /** Retorna punts d'atac **/
	public int getDefensePoints() {return this.defensePoints;} /** Retorna punts de defensa **/
	public int getLife() {return this.life;} /** Retorna punts de vida **/
	public String str() {return(this.name + ":" + this.attackPoints + "/" + this.defensePoints + "/" + this.life) + "(" + (this.teams.size()) + ")" + (this.getItemsInfo());} /** Retorna la cadena d'estat **/
	

	public void attack(Player p) {
		if((p.getClass().getSimpleName().equals("Alien"))) {
			p.attack(this);
		}else{		
			if(this.getLife() < 0){ Put.ln("Estàs fora de combat"); return; }
			if(p.getLife() < 0){ Put.ln("No pots atacar un jugador fora de combat!!"); return; }
			if(p.name.equals(this.name)){ Put.ln("No pots atacar-te a tu mateix!!"); return; }
			Put.ln(this.str() + " ataca a " + p.str());
			this.hit(p.attackPoints);
			p.hit(this.attackPoints);
			Put.ln("Resultat de l'atac: " + this.str() + " \\|/ " + p.str() + "\n");
		}
	} /** Funció d'atac **/
	
	protected void hit(int attackPoints) {
		if(this.defensePoints > attackPoints){
			Put.noln(this.str() +" és atacat amb "+ attackPoints +" i es defén amb "+ this.defensePoints + ". Vides: " + this.life + "- 1 = ");
			this.life = this.life - 1;
			if(this.life < 0)
				this.life = 0;
			Put.noln(this.life + "\n");
		}else{
			Put.noln(this.str() +" és atacat amb "+ attackPoints +" i es defén amb "+ this.defensePoints + ". Vides: " + this.life + "-" + (attackPoints - this.defensePoints) + " = ");
			this.life = this.life - (attackPoints - this.defensePoints);
			if(this.life < 0)
				this.life = 0;
			Put.noln(this.life + "\n");
		}
		
	} /** Funció de colpejar **/
	protected String getItemsInfo() {
		String temp = " amb ";
		if(this.items.isEmpty())
			return "";
		else{
			Iterator <Item> i = items.iterator();
			while(i.hasNext()){
				temp += i.next().str();
				if(i.hasNext())
					temp += " ,";
			}
			return temp;
		}
	}
	
	/**	CONSTRUCTOR	**/
	protected Player() {
		this.attackPoints = 50;
		this.defensePoints = 50;
		this.life = 100;
		Put.noln("Nom del personatge:\t");this.name = Read.Cad();
	}
	
	protected Player(String name, int attackPoints, int defensePoints, int life) {
		this.attackPoints = attackPoints;
		this.defensePoints = defensePoints;
		this.life = life;
		this.name = name;
	}
}
