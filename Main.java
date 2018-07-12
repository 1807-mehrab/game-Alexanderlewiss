public class Main
{
     private Parser p; 
     private Worlds cWorld;
 
      public static void main(String[] args)
     {
     
         Main game = new Main(); 
         game.start(); 
     }
  
      public Main()
      {
            createWorlds();
            p = new Parser(); 
      }
  
     public void createWorlds()
   {
   
     Worlds enchantedDominion, castleCornelia, toyBox, alantica;
     enchantedDominion = new Worlds("Oh no! Maleficent has Stolen Aurora's heart! Please help save her! ");
     castleCornelia = new Worlds("7 warriors of light touch the crystals as they begin their journey ");
     toyBox = new Worlds("Andy is missing! Help Woody and Buz find their friend.  ");
     alantica = new Worlds("Ursula has stolen king Triton's triton. Help Arial get it back from Ursula. ");
     
     enchantedDominion.exitWorld("Castle Cornelia ", castleCornelia );
     castleCornelia.exitWorld("Toy Box", toyBox );
     toyBox.exitWorld("Atlantica", alantica );
     alantica.exitWorld("Castle Cornelia",castleCornelia ); 
     
     cWorld = enchantedDominion; 
     
   }
  
     public void start()
   {
      System.out.println();
      System.out.println("Myra: Hello pure hearted child welcome to this realm");
      System.out.println("Child: This place is beautiful I want to stay here forever. ");
      System.out.println("Myra: Yes it is! But dont be fooled darkness is every where...");
      System.out.println("Myra: Dont let it consume your heart ");
      System.out.println("Child: I wont give into the darkness. Never.. ");
      System.out.println("Myra: Okay well, step right though this portal to go on your first mission! ");
      System.out.println("Myra: Type move and you will step into the portal. ");
      
      System.out.println(cWorld.getLWorldDesc()); 
      
         boolean done = false; 
         while(!done)
         {
           Direct d = p.getCommand(); 
         }
   }
  
        private boolean commandProcessor(Direct direction)
        {
           boolean quits = false; 
     
           if(direction.doesNotKnow())
           {
                System.out.println("Unknown command try again.");
                return false; 
           }
     
             String dWord = direction.obtainDWord(); 
     
              if(dWord.equals("Move"))
             {
                  travleWorlds(direction); 
             }
        //else if(dWord.equals("Fight"))
        //{
          
        //}
                else if(dWord.equals("Help"))
               {
                    System.out.println("Here are the Commands: go, move, fight, and quit"); 
                   System.out.println("Type them in and make sure you are spelling them correctly"); 
               } 
                   else if(dWord.equals("quit"))
                  {
                     quits = quit(direction); 
                  }
     
                 return quits; 
         }  
  
        private void travleWorlds(Direct direction)
        {
           if(!direction.knowsFWord())
           {
               System.out.println("Unknown command"); 
               
           }    
     
          String d = direction.obtainDWord(); 
          Worlds nWorld = cWorld.leaveWorld(d); 
     
            if(nWorld == null)
            {
              System.out.println("No world to go too"); 
             }
              else
              {
                cWorld = nWorld; 
                System.out.println(cWorld.getLWorldDesc()); 
              }
        }

             private boolean quit(Direct direction)
             {
    
                 if(direction.knowsFWord())
                 {
                      System.out.println("Invalid command");
                      return false; 
                 }
                      else
                     {
                          return true; 
                     }
             }


}

