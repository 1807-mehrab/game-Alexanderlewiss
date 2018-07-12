import java.util.*;

public class Worlds
{
    private String worldDescription; 
    private HashMap<String, Worlds> leave; 
    
    public Worlds(String wd)
    {
      worldDescription = wd; 
      leave = new HashMap<>(); 
      
    }
    
    public void exitWorld(String way, Worlds nxt)
    {
      leave.put(way, nxt); 
    }
    
    public String getWorldDesc()
    {
        return worldDescription; 
    }
    
    public String getLWorldDesc()
    {
        return " \nWelcome to  " + worldDescription + "\n " + getExitWorld();
    }
    
    public String getExitWorld()
    {
        String leaveW = "Leaving world:";
        Set<String> keys = leave.keySet(); 
        for(String l : keys)
        {
           leaveW += " " + leave; 
        }
        return leaveW; 
    }
    
    public Worlds leaveWorld(String way)
    {
       return leave.get(way); 
       
    }

}
