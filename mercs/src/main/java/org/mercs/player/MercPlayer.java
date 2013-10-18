package org.mercs.player;

import org.mercs.merc.IMerc;
import org.mercs.merc.Merc;
import java.util.List;
import java.util.LinkedList;
import java.util.ArrayList;

public class MercPlayer {

	private String name;
	private String playerid;
	private int gold;
	private int cash;
	private int squCount = 0;
	private IMerc[] sqwad = new Merc[4];
	private List<IMerc> playerMercs = new LinkedList<IMerc>();
	
	MercPlayer(String _playerid, String _name){
		name = _name;
		playerid = _playerid;
		sqwad[0] = null;
		sqwad[1] = null;
		sqwad[2] = null;
		sqwad[3] = null;
		playerMercs = new LinkedList<IMerc>();
	}
	
	public void addMerc(IMerc merc){
		synchronized(playerMercs){
			this.playerMercs.add(merc);
		}
	}
	
	public List getMercList(){
		return this.playerMercs;
	}
	
	public void removeMerc(IMerc merc){
		synchronized(playerMercs){
			if(!this.playerMercs.isEmpty() && this.playerMercs.contains(merc)){
				IMerc[] lmerc = playerMercs.toArray(new IMerc[playerMercs.size()]);
				for(int i =0 ; i < lmerc.length; ++i){
					if(lmerc[i].getID() == merc.getID()){
						this.playerMercs.remove(i);
						break;
					}
				}
				lmerc = null;
			}
		}
	}
	
	private void updatesqucount(){
		this.squCount = squCount >= Integer.MAX_VALUE || squCount <= 0 ? 0 : Math.abs(squCount+1);
	}
	
	private void minussqucount(){
		this.squCount = squCount >= Integer.MAX_VALUE || squCount <= 0 ? 0 : Math.abs(squCount-1);
	}
	
	public void addMercToSq(IMerc merc) throws Exception{
		if(!this.playerMercs.isEmpty() && this.playerMercs.contains(merc) && !alreadyInSqwad(merc)){
			this.sqwad[squCount % 4] = merc;
			updatesqucount();
		} else {
			throw new ArrayIndexOutOfBoundsException("Merc Does Not Exist in List");
		}
	}
	
	public void removeMercFromSq(IMerc merc){
		if(!this.playerMercs.isEmpty() && this.playerMercs.contains(merc) && alreadyInSqwad(merc)){
			for(int i = 0; i < 4 && !this.playerMercs.isEmpty() ; ++i){
				if(sqwad[i] != null && sqwad[i].getID() == merc.getID()){
					sqwad[i] = null;
					minussqucount();
				}
			}
		}
	}
	
	private boolean alreadyInSqwad(IMerc merc){
		
		for(int i = 0; i < 4 && !this.playerMercs.isEmpty() ; ++i){
			if(sqwad[i] != null && sqwad[i].getID() == merc.getID()){
				return true;
			}
		}
		
		return false;
		
	}
	
}
