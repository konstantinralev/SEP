import java.util.Date;


public class Customer
{
   private String address;
   private String phoneNumber;
   private Date birthday;
   private String name;
   private String email;
   
   /**
    * set the name, address and phoneNumber for each customer.
    * @param name
    * @param address
    * @param phoneNumber
    */
   public Customer(String name, String address, String phoneNumber){
      this.name  = name;
      this.address = address;
      this.phoneNumber = phoneNumber;
      
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
    * @param birthday to set the birthday
    */
   public void setBirthday(Date birthday)
   {
      this.birthday = birthday;
   }


   /**
    * @return the birthday
    */
   public Date getBirthday()
   {
      return birthday;
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
    * @return a string with a customer's information
    */
   public String toString(){
      String text = "Customer name: " + name + "\nAddress: " + address + "\nPhone number" + phoneNumber  + "\n";
      if(email != null){
         text += "Email:" + email + "\n";
      }
      if(birthday != null){
         text += "Birthday: " + birthday + "\n";
      }
      return text;
      }
}
