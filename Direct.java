public class Direct 
{
    private String dWord; 
    private String fWord; 
    
    public Direct(String fWord, String sWord)
    {
       dWord = fWord; 
       fWord = sWord; 
       
    }
    
    public String obtainDWord()
    {
        return dWord; 
    }
    
    public String obtainFWord ()
    {
       return fWord; 
       
    }
    
    public boolean doesNotKnow()
    {
       return (dWord == null);
    }
    
    public boolean knowsFWord()
    {
      return (fWord != null); 
    }
    
    
    
}