package inici;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import joc.Alien;
import joc.Human;
import joc.Item;
import joc.Player;
import joc.Team;
import joc.Warrior;
import ee.Put;
import ee.Read;

public class JocDeRol {

	static final int LIFE = 100;
	static ArrayList <Team> teams = new ArrayList <Team> (1);
	static ArrayList <Item> items =  new ArrayList <Item> (1);
	static ArrayList <Player> players = new ArrayList <Player> (1);
	
	public static void main(String[] args) {
		menuJoc();	
	}

	////////////////////////////////////////////////////////
	////			FUCIONS MOSTRA DE MENU				////
	////////////////////////////////////////////////////////
	/**			MENU PRINCIPAL			**/
	private static void menuJoc() {
		do{
			Put.ln("_______________");
			Put.ln("|  JOC DE ROL |");
			Put.ln("¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯");
			Put.ln("1. Configuració.\n2. Iniciar joc.\n3. Eixir.");
			switch(Read.Int()){
			case 1:
				confJoc();
				break;
			case 2:
				iniciJoc();
				break;
			case 3:
				System.exit(0);
			default:
				Put.ln("Opció no vàlida.");
			}
		}while(true);
	}
	
	/**		MENU DE CONFIGURACIO DEL JOC	**/
	private static void confJoc() {
		while(true){
			Put.ln("_____________\nConfiguració del joc\n¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯");
			Put.ln("1. Gestió de jugadors.\n2. Gestió d'equips.\n3. Gestió d'objectes.\n4. Eixir.");
			switch(Read.Int()){
			case 1:
				confJugadors();
				break;
			case 2:
				confEquips();
				break;
			case 3:
				confItems();
				break;
			case 4:
				menuJoc();
				break;
			default:
				Put.ln("Opció no vàlida.");
			}
		}
	}
	
	/**				MENU INICIAR JOC			**/
	private static void iniciJoc() {
		while(true){
			Put.ln("_____________\n   Inici   \n¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯");
			Put.ln("1. 1 vs 1.\n2. Equip vs Equip.\n3. Eixir");
			while(true){
				switch(Read.Int()){
				case 1:
					pCombat();
				break;
				case 2:
					tCombat();
				break;
				}
			}
		}
	}
	
	/**		MENU DE CONFIGURACIO DE JUGADORS	**/
	private static void confJugadors() {
		while(true){
			String player, team, item;
			Put.ln("_____________\n   Jugadors   \n¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯");
			Put.ln("1. Crear jugador.\n2. Mostrar jugadors.\n3. Esborrar jugador.\n4. Assignar jugador a equip.\n5. Assignar objecte a jugador.\n6. Eixir");
			switch(Read.Int()){
			case 1:
				Put.noln("Selecciona tipus de jugador:\t 1.Alien  2.Huma  3.Guerrer.");
				crearJugador(Read.Int());
				break;
			case 2:
				displayPlayers();
				break;
			case 3:
				Put.noln("Nom del jugador a esborrar:\t");
				deletePlayer(Read.Cad());
				break;
			case 4:
				Put.noln("Nom del jugador:\t"); player = Read.Cad();
				Put.noln("Nom de l'equip:\t"); team = Read.Cad();
				setTeam(player, team);
				break;
			case 5:
				Put.noln("Nom del jugador:\t"); player = Read.Cad();
				Put.noln("Nom de l'objecte:\t"); item = Read.Cad();
				giveItem(player, item);
				break;
			case 6:
				confJoc();
			}
		}
	}
	
	/**		MENU CONFIGURACIO EQUIPS		**/
	private static void confEquips() {
		while(true){
			String player, team;
			Put.ln("_____________\n   Equips   \n¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯");
			Put.ln("1. Crear equip.\n2. Mostrar equips.\n3. Esborrar equip.\n4. Assignar jugador a equip.\n5. Eixir");
			switch(Read.Int()){
			case 1:
				Put.noln("Nom de l'equip:\t");
				Team temp = new Team(Read.Cad());
				teams.add(temp);
				break;
			case 2:
				displayTeams();
				break;
			case 3:
				Put.noln("Nom de l'equip a esborrar:\t");
				deleteTeam(Read.Cad());
				break;
			case 4:
				Put.noln("Nom del jugador:\t"); player = Read.Cad();
				Put.noln("Nom de l'equip:\t"); team = Read.Cad();
				setPlayer(player, team);
				break;
			case 5:
				confJoc();
			default:
				Put.ln("Opció no vàlida.");
			}
		}
	}
	
	/**				MENU CONFIGURACIO OBJECTES			**/
	private static void confItems() {
		while(true){
			String player, item;
			Put.ln("_____________\n   Objectes \n¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯");
			Put.ln("1. Crear objecte.\n2. Mostrar objectes.\n3. Esborrar objecte.\n4. Assignar objecte a jugador.\n5. Eixir");
			switch(Read.Int()){
			case 1:
				Put.noln("Nom de l'objecte:\t"); String n = Read.Cad();
				Put.noln("Bonus d'atac:\t"); int aP = Read.Int();
				Put.noln("Bonus de defensa:\t"); int dP = Read.Int();
				Item temp = new Item(n, aP, dP);
				items.add(temp);
				break;
			case 2:
				displayItems();
				break;
			case 3:
				Put.noln("Nom de l'objecte a esborrar:\t");
				deleteItem(Read.Cad());
				break;
			case 4:
				Put.noln("Nom del jugador:\t"); player = Read.Cad();
				Put.noln("Nom de l'objecte:\t"); item = Read.Cad();
				setItem(player, item);
				break;
			case 5:
				confJoc();
			default:
				Put.ln("Opció no vàlida.");
			}
		}
	}
	///////////////////////////////////////////////////////////////////
	
	/////////////////////////////////////////////////////
	/////			FUNCIONS JUGADORS				/////
	/////////////////////////////////////////////////////
	/**				FUNCION PER A CREAR JUGADORS		**/
	private static void crearJugador(int n) {
		int aP = 0, dP = 0;	
		String name;
		do{
			Put.noln("Nom del pj:\t"); name = Read.Cad();
		}while(checkName(name));
		do{
			aP = dP = 0;
			Put.ln("Recorda que la suma del punts d'atac i defensa ha de ser igual a 100");
			Put.noln("Puns d'atac:\t"); aP = Read.Int();
			Put.noln("Puns de defensa:\t"); dP = Read.Int();
		}while((aP + dP) != 100);
		switch(n){
		case 1:
			Alien tempA = new Alien(name, aP, dP, LIFE);
			players.add(tempA);
			break;
		case 2:
			Human tempH = new Human(name, aP, dP, LIFE);
			players.add(tempH);
			break;
		case 3:
			Warrior tempW = new Warrior(name, aP, dP, LIFE);
			players.add(tempW);
			break;
		default:
			Put.ln("Opció no vàlida.");
			confJugadors();
		}		
	}
	
	/** 		FUNCIO PER A COMPROVAR NOM DEL JUGADOR		**/
	private static boolean checkName(String name) {
		Iterator <Player> i = players.iterator();
		while(i.hasNext()){
			Player p = i.next();
			if(p.getName().equals(name))
				return true;
		}
		
		return false;
	}
	
	/**			FUNCIO PER A MOSTRAR TOTS ELS JUGADORS		**/
	private static void displayPlayers() {
		Iterator <Player> p = players.iterator();
		while(p.hasNext())
			Put.ln(p.next().str());
	}
	
	/**			FUNCIO PER A ESBORRAR JUGADORS				**/
	private static void deletePlayer(String player) {
		Player p = getPlayer(player);
		Iterator <Team> i = teams.iterator();
		while(i.hasNext()){
			Team t = i.next();
			if(t.checkMembers(p))
				p.removeTeam(t);
		}
		players.remove(p);
		players.trimToSize();
	}
	
	/**			FUNCIO PER A ASSIGNAR OBJECTES				**/
	private static void giveItem(String player, String item) {
		Player p = getPlayer(player);
		Item i = getItem(item);
		p.addItem(i);
	}
	
	/**			FUNCIO PER A ASSIGNAR EQUIPS				**/
	public static void setTeam(String player, String team) {
		Player p = getPlayer(player);
		Team t = getTeam(team);
		if(players.contains(p) && teams.contains(t))
			p.addTeam(t);
	}
	
	/**			FUNCIO PER A OBTINDRE UN JUGADOR			**/
	private static Player getPlayer(String player) {
		player.toLowerCase();
		Iterator <Player> i = players.iterator();
		while(i.hasNext()){
			Player p = i.next();
			if((p.getName()).toLowerCase().equals(player))
				return p;
		}
		return null;
	}

	/////////////////////////////////////////////////////
	/////			FUNCIONS EQUIPS					/////
	/////////////////////////////////////////////////////
	/**			FUNCIO PER A OBTINDRE UN EQUIPS				**/
	private static Team getTeam(String team) {
		team.toLowerCase();
		Iterator <Team> i = teams.iterator();
		while(i.hasNext()){
			Team t = i.next();
			if((t.getName()).toLowerCase().equals(team))
				return t;
		}
		return null;
	}
	
	/**				FUNCIO PER A MOSTRAR EQUIPS				**/
	private static void displayTeams() {
		Iterator <Team> i = teams.iterator();
		while(i.hasNext())
			Put.ln(i.next().str());
	}
	
	/**				FUNCIO PER A ASSIGANAR EQUIP			**/
	public static void setPlayer(String player, String team) {
		Player p = getPlayer(player);
		Team t = getTeam(team);
		if(players.contains(p) && teams.contains(t))
			t.add(p);
	}
	
	/**				FUNCIO PER A ESBORRAR EQUIPS			**/
	private static void deleteTeam(String team) {
		Team t = getTeam(team);
		Iterator <Player> i = players.iterator();
		while(i.hasNext()){
			Player p = i.next();
			if(p.checkTeams(t))
				t.remove(p);
		}
		teams.remove(getTeam(team));
		teams.trimToSize();
	}
	
	/////////////////////////////////////////////////////
	/////			FUNCIONS OBJECTES				/////
	/////////////////////////////////////////////////////
	/**			FUNCIO PER A OBTINDRE UN ITEM				**/
	private static Item getItem(String item) {
		item.toLowerCase();
		Iterator <Item> i = items.iterator();
		while(i.hasNext()){
			Item t = i.next();
			if((t.getName()).toLowerCase().equals(item))
			return t;
		}
		return null;
	}
	
	/**				FUNCIO PER A LLISTAR ITEMS				**/
	private static void displayItems() {
		Iterator <Item> i = items.iterator();
		while(i.hasNext())
			Put.ln(i.next().str());
	}
	
	/**				FUNCIO PER A ESBORRAR ITEMS			**/
	private static void deleteItem(String item) {
		Item i = getItem(item);
		i.getOwner().removeItem(i);
		items.remove(i);
		items.trimToSize();
	}
	
	/**			FUNCIO PER A ASSIGANAR A UN JUGADOR		**/
	public static void setItem(String player, String item) {
		Player p = getPlayer(player);
		Item i = getItem(item);
		if(items.contains(i) && players.contains(p))
			p.addItem(i);
	}
	
	/////////////////////////////////////////////////////
	/////			FUNCIONS COMBAT					/////
	/////////////////////////////////////////////////////
	/**			FUNCIO COMBAT 1VS1			**/
	public static void pCombat(){
		Random torn = new Random(100);
		Player p1, p2;
		Put.ln("Selecciona dos jugadors:");
		displayPlayers();
		Put.noln("Jugador 1:\t"); p1 = getPlayer(Read.Cad());
		Put.noln("Jugador 2:\t"); p2 = getPlayer(Read.Cad());
		while((p1.getLife() > 0 && p2.getLife() > 0)){
			if(torn.nextInt() < 50)
				p1.attack(p2);
			else
				p2.attack(p1);
		}
		
		if(p1.getLife() == 0)
			Put.ln(p1.getName() + " ha guanyat.");
		else
			Put.ln(p2.getName() + " ha guanyat.");
		
		p1.setLife(); p2.setLife();
		iniciJoc();
	}
	
	/**			FUNCIO COMBAT EQUIPS			**/
	public static void tCombat(){
		boolean atac = true;
		int e1Deaths = 0, e2Deaths = 0;;
		Team t1, t2;
		Random target = new Random();		
		Put.ln("Selecciona dos equips:");
		displayTeams();
		Put.noln("Equip 1:\t"); t1 = getTeam(Read.Cad());
		Put.noln("Equip 2:\t"); t2 = getTeam(Read.Cad());
		Put.ln(t1.get(target.nextInt(t1.getTeam().size())).str());
		
		while(true){
			if(atac){
				t1.get(target.nextInt(t1.getTeam().size())).attack(t2.get(target.nextInt(t2.getTeam().size())));
			}else{
				t2.get(target.nextInt(t2.getTeam().size())).attack(t1.get(target.nextInt(t1.getTeam().size())));
			}
			
			
			atac = !atac;
		}
	
	/**				FUNCIONS ESPECIALS			**/
	}
}
	///////////////////////////////////////////////////////////////////////
	/***************			FI DEL PROGRAMA			******************/
	///////////////////////////////////////////////////////////////////////
