package Aexteam.Game;

import java.util.*;

public class Worlds {
	private String worldDescription;
	private HashMap<String, Worlds> leave;

	public Worlds(String wd) {
		worldDescription = wd;
		leave = new HashMap<String, Worlds>();
	}

	public void exitWorld(String way, Worlds nxt) {
		leave.put(way, nxt);
		leave.put("ED", nxt); 
		leave.put("CC", nxt); 
		leave.put("TB",nxt);
		leave.put("AL", nxt); 
		
		
	}

	public String getWorldDesc() {
		return worldDescription;
	}

	public String getLWorldDesc() {
		return " \nWelcome to  " + worldDescription + "\n " + getExitWorld();
	}

	public String getExitWorld() {
		String leaveW = "Next world type move to travel to:";
		Set<String> keys = leave.keySet();
		for (String l : keys) {
			leaveW += " " + l;
		}
		return leaveW;
	}

	public Worlds leaveWorld(String way) {
		return leave.get(way);

	}

}
