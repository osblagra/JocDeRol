package joc;

import java.util.ArrayList;
import java.util.Iterator;
import ee.Put;

public class Team {

	/**	ATRIBUTS	**/
	private String name;
	private ArrayList <Player> players = new ArrayList <Player>(1);
	
	/** METODES		**/
	public Player get(int i) {return this.players.get(i); }
	public ArrayList <Player> getTeam() {return this.players;}
	public String getName()	{return this.name;};
	public void add(Player p) {if(!this.checkMembers(p)){players.add(p); p.addTeam(this);}} /** Afig un jugador a la llista de l'equip **/
	public void remove(Player p){if(this.checkMembers(p)){players.remove(p); p.removeTeam(this);}} /** Elimina un jugador de la llista de l'equip **/
	public boolean checkMembers(Player p) {return players.contains(p);} /** Comprova si l'equip conté el membre	**/
	public String str() {
		String temp = "Team " + this.name + "(";
		if(this.players.isEmpty())
			return temp += "No conté jugadors)";
		else{
			Iterator <Player> i = players.iterator();
			while(i.hasNext()){
				temp += i.next().str();
				if(i.hasNext())
					temp += ", ";
			}
			return temp += ")";
		}
	}
	public void getMembers() {
		Iterator <Player> i = players.iterator();
		while(i.hasNext()){
			Put.noln(i.next().str());
			if(i.hasNext())
				Put.noln("||");
		}
	} /** Mostra els integrants de l'equip **/
	
	/**	CONSTRUCTORS	**/
	public Team(String name) {
		this.name = name;
	}
}
