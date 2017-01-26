package rest.model;

public class User  {
   private String name;
   private String mail;
   private int id;

   public User(){
   }

   public User(int id, String name, String mail){
      this.id = id;
      this.name = name;
      this.mail = mail;

   }

   public void setName(String name){
      this.name = name;
   }

   public String getName(){
      return name;
   }

   public void setMail(String mail){
      this.mail = mail;
   }

   public String getMail(){
      return mail;
   }

   public void setId(int id){
      this.id = id;
   }

   public int getId(){
      return id;
   }
}
