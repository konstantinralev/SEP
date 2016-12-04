
public class Chauffeur
{
   private String name;
   private int id;
   private String phoneNumber;
   private String address;
   private String wishes;
   private String email;
   
    /**
    * sets the name, id, address, wishes, email and phoneNumber for each chauffeur
    * @param name
    * @param id
    * @param address
    * @param wishes
    * @param email
    * @param phoneNumber
    */
   public Chauffeur(String name, int id, String address, String wishes, String email, String phoneNumber){
      this.name = name;
      this.id = id;
      this.address = address;
      this.phoneNumber = phoneNumber;
      this.wishes = wishes;
      this.email = email;
   }
   

   /**
    * @param name to set the name
    */
   public void setName(String name)
   {
      this.name = name;
   }

   
   /**
    * @return the name
    */
   public String getName()
   {
      return name;
   }

   
   /**
    * @param id to set the id
    */
   public void setId(int id)
   {
      this.id = id;
   }


   /**
    * @return the id
    */
   public int getId()
   {
      return id;
   }

   
   /**
    * @param phoneNumber to set the phoneNumber
    */
   public void setPhoneNumber(String phoneNumber)
   {
      this.phoneNumber = phoneNumber;
   }


   /**
    * @return the phoneNumber
    */
   public String getPhoneNumber()
   {
      return phoneNumber;
   }


   
   /**
    * @param address to set the address
    */
   public void setAddress(String address)
   {
      this.address = address;
   }


   
   /**
    * @return the address
    */
   public String getAddress()
   {
      return address;
   }


   /**
    * @param wishes to set the wishes
    */
   public void setWishes(String wishes)
   {
      this.wishes = wishes;
   }


   /**
    * @return the wishes
    */
   public String getWishes()
   {
      return wishes;
   }


   /**
    * @param email to set the email
    */
   public void setEmail(String email)
   {
      this.email = email;
   }
   
   
   /**
    * @return the email
    */
   public String getEmail()
   {
      return email;
   }


   /**
    * @return a String with information about the chauffeur
    */
   public String toString(){
      String text = "Name: " + name + "\nEmployee ID: " + id + "\nAddress: " + address +
               "\nPhone number: " + phoneNumber + "\nE-mail: " + email;
      if(wishes!=null){
         text += "\nWishes: " + wishes;
      }
      return text;
   }
}
