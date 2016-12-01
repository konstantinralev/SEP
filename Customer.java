
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

   public void setAddress(String address)
   {
      this.address = address;
   }

   public void setPhoneNumber(String phoneNumber)
   {
      this.phoneNumber = phoneNumber;
   }

   public void setBirthday(Date birthday)
   {
      this.birthday = birthday;
   }

   public void setName(String name)
   {
      this.name = name;
   }

   public void setEmail(String email)
   {
      this.email = email;
   }

   public String getAddress()
   {
      return address;
   }

   public String getPhoneNumber()
   {
      return phoneNumber;
   }

   public Date getBirthday()
   {
      return birthday;
   }

   public String getName()
   {
      return name;
   }

   public String getEmail()
   {
      return email;
   }
   
   public String toString(){
      String message = "";
      if(email != null && birthday != null){
         message = "Customer name: " + name + "\n" + "Address: " + address + "\n" + "Phone number" + phoneNumber + "\n" + "Email:" + email + "\n" + "Birthday: " + birthday;
      }else if (email == null && birthday == null){
         message = "Customer name: " + name + "\n" + "Address: " + address + "\n" + "Phone number" + phoneNumber;
      }else if (email != null && birthday == null){
         message = "Customer name: " + name + "\n" + "Address: " + address + "\n" + "Phone number" + phoneNumber + "\n" + "Birthday: " + birthday;
      }else if (email == null && birthday != null){
         message = "Customer name: " + name + "\n" + "Address: " + address + "\n" + "Phone number" + phoneNumber + "\n" + "Email: " + email;
      }
      return message;
      
   }

}
