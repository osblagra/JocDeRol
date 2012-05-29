package joc;

public class Item {

	/** ATRIBUTS  **/
	private String name;
	private int attackBonus;
	private int defenseBonus;
	private Player owner;
	
	/** METODES **/
	public int getAttackBonus() {return this.attackBonus;}
	public int getDefenseBonus() {return this.defenseBonus;}
	public String getName() {return this.name;}
	public String str() {return (this.name + " " + this.attackBonus +"/"+ this.defenseBonus);}
	public Player getOwner() {return this.owner;}
	
	/** CONSTRUCTORS **/
	public Item(String name, int attackBonus, int defenseBonus) {
		this.name = name;
		this.attackBonus = attackBonus;
		this.defenseBonus = defenseBonus;
	}
}
