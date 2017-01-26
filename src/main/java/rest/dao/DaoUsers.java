package rest.dao;

import java.util.List;
import java.util.ArrayList;
import rest.model.User;

public class DaoUsers {

   private static ArrayList<User> db = new ArrayList<User>();

   // public static User save(User user){
   //    return user;
   // }

   public static ArrayList<User> findAll(){
      return db;
   }

   public static User find(int id) throws IndexOutOfBoundsException{
      return db.get(id);
   }

   // public static User update(User user){
   //    return user;
   // }
   //
   // public static boolean delete(int id){
   //
   // }



}
