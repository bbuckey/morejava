package org.mercs.merc;

import org.mercs.merc.IMerc;

public class Merc implements IMerc {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2990239236664430771L;

	private String name;
	private int hp;
	private int atk;
	private int def;
	private String wep;
	private long id;
	
	/**
	 * this is the base class for a merc
	 * @param _id the id for the merc
	 * @param _hp total hp of merc
	 * @param _atk total attack of merc
	 * @param _def total def of merc
	 * @param _name name of merc
	 */
	Merc(long _id, int _hp, int _atk, int _def, String _name){
		hp = _hp;
	atk = _atk;
	def = _def;
	id = _id;
	name = _name;
	}
	
	public long getMercID(){
		return id;
	}
	
	public void setName(String _name){
		this.name = _name;
	}
	
	public String getName(){
		return this.name;
	}
	
	public void setWep(String _name){
		this.wep = _name;
	}
	
	public String getWep(){
		return this.wep;
	}
	
	
	public void setAtk(int _name){
		this.atk = _name;
	}
	
	public int getAtk(){
		return this.atk;
	}
	
	
	public void setHP(int _name){
		this.hp = _name;
	}
	
	public int getHP(){
		return this.hp;
	}
	
	
	public void setDef(int _name){
		this.def = _name;
	}
	
	public int getDef(){
		return this.def;
	}
	
}
