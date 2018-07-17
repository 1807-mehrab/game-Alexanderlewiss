package com.alex.gaamee;

import java.util.*;

public class Worlds {
	private String worldDescription;
	private HashMap<String, Worlds> leave; // Creates hashmap 

	public Worlds(String wd) {
		worldDescription = wd;
		leave = new HashMap<String, Worlds>();
	}
  // Puts the game worlds in the hash map 
	public void exitWorld(String way, Worlds nxt) {
		leave.put(way, nxt);
		leave.put("ED", nxt); 
		leave.put("CC", nxt); 
		leave.put("TB",nxt);
		leave.put("AL", nxt); 
		
		
	}
     // Gets the world description 
	public String getWorldDesc() {
		return worldDescription;
	}
       // Returns the next world description 
	public String getLWorldDesc() {
		return " \nWelcome to  " + worldDescription + "\n " + getExitWorld();
	}

	// Iterates though the hashmap and gets the next world.
	// Also sets keys for the hash map. 
	public String getExitWorld() {
		String leaveW = "Next world type move to travel to:";
		Set<String> keys = leave.keySet();
		for (String l : keys) {
			leaveW += " " + l;
		}
		return leaveW;
	}

	// Gets the world that you are leaving from the hashmap without the key.
	public Worlds leaveWorld(String way) {
		return leave.get(way);

	}

}
