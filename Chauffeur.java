public class Chauffeur
{
   private String name;
   private static int uniqueId = 11111;
   private int id;
   private String phoneNumber;
   private String address;
   private String wishes;
   private String email;
   
    /**
    * sets the name, address, email and phoneNumber for each chauffeur
    * @param name
    * @param id
    * @param address
    * @param email
    * @param phoneNumber
    */
   public Chauffeur(String name, String address, String email, String phoneNumber){
      this.name = name;
      if(String.valueOf(uniqueId).length()==5){
          this.id = uniqueId;
          uniqueId++;
      }
      this.address = address;
      this.phoneNumber = phoneNumber;
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
    * 
    * @return a String with the chauffeur's information
    */
   public String toString(){
	  String info = "Name: " + name + "\nEmployee ID: " + id + "\nAddress: " + address +
               "\nPhone number: " + phoneNumber + "\nE-mail: " + email;
      if(wishes!=null){
         info += "\nWishes: " + wishes;
      }
      return info;
   }
}
