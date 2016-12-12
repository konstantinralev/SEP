import java.util.ArrayList;

public class ChauffeurList
{
   private ArrayList<Chauffeur> chauffeurs;   
   
    /**
    * the constructor initializes an ArrayList of chauffeurs.
    */
   public ChauffeurList(){
      chauffeurs = new ArrayList<Chauffeur>();
   }
   
   /**
    * 
    * @return a list with all chauffeurs
    */
   public ArrayList<Chauffeur> getAllChauffeurs(){
	   return chauffeurs;
   }
   
   
   /**
    * 
    * @param chauffeur
    */
   public void addChauffeur(Chauffeur chauffeur){
	   chauffeurs.add(chauffeur);
   }
   
   /**
    * 
    * @param id
    */
	public void removeChauffeur(Chauffeur chauffeur) {
		chauffeurs.remove(chauffeur);
   }
   
   
   /**
    * look for a chauffeur by id
    * @param id
    * @return chauffeur with the matching id
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
    * look for a chauffeur by name
    * @param name
    * @return chauffeurs with the matching name
    */
   public ArrayList<Chauffeur> getChauffeur(String name){
      ArrayList<Chauffeur> sameName = new ArrayList<Chauffeur>();
	   for(int i = 0; i < chauffeurs.size(); i++){
         if (chauffeurs.get(i).getName().equals(name))
         {
            sameName.add(chauffeurs.get(i));
         }
      }
      return sameName;
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
