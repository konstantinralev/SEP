import java.util.Date;


public class Customer
{
   private String address;
   private String phoneNumber;
   private Date birthday;
   private String name;
   private String email;
   
   public Customer(String name, String address, String phoneNumber){
      this.name  = name;
      this.address = address;
      this.phoneNumber = phoneNumber;
      
   }

   /**
    * @return the address
    */
   public String getAddress()
   {
      return address;
   }



   /**
    * @param address the address to set
    */
   public void setAddress(String address)
   {
      this.address = address;
   }



   /**
    * @return the phoneNumber
    */
   public String getPhoneNumber()
   {
      return phoneNumber;
   }



   /**
    * @param phoneNumber the phoneNumber to set
    */
   public void setPhoneNumber(String phoneNumber)
   {
      this.phoneNumber = phoneNumber;
   }



   /**
    * @return the birthday
    */
   public Date getBirthday()
   {
      return birthday;
   }



   /**
    * @param birthday the birthday to set
    */
   public void setBirthday(Date birthday)
   {
      this.birthday = birthday;
   }



   /**
    * @return the name
    */
   public String getName()
   {
      return name;
   }



   /**
    * @param name the name to set
    */
   public void setName(String name)
   {
      this.name = name;
   }



   /**
    * @return the email
    */
   public String getEmail()
   {
      return email;
   }



   /**
    * @param email the email to set
    */
   public void setEmail(String email)
   {
      this.email = email;
   }

   /**
    * @return a string with a customer's information
    */
   public String toString(){
      String message = "Customer name: " + name + "\nAddress: " + address + "\nPhone number" + phoneNumber;
      if(email != null){
         message += "\nEmail:" + email;
      }
      if(birthday != null){
         message += "\nBirthday: " + birthday;
      }
      return message;
      }
}
