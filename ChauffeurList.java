import java.util.ArrayList;

public class ChauffeurList
{
   private ArrayList<Chauffeur> chauffeurs;   
   
    /**
    * the constructor initializes the ArrayList of chauffeur.
    */
   public ChauffeurList(){
      chauffeurs = new ArrayList<Chauffeur>();
   }
   
   
   /**
    * look for a chauffeur by id
    * @param id
    * @return chauffeur
    */
   public Chauffeur getChauffeur(int id){
      for(int i = 0; i < chauffeurs.size(); i++){
         if (chauffeurs.get(i).getId() == id)
         {
            return chauffeurs.get(i);
         }
      }
      return null;
   }
   
   
   /**
    * @return a string with all of the chauffeurs
    */
   public String toString(){
      String text = "Chauffeurs:\n";
      for (int i = 0; i < chauffeurs.size(); i++)
      {
        text += chauffeurs.get(i).getName() + "\n"; 
      }
      return text;
   }
}
