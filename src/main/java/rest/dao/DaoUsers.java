package rest.dao;

import java.util.Map;
import java.util.HashMap;
import rest.model.User;

public class DaoUsers {

   //private static ArrayList<User> db = new ArrayList<User>();
   private static Map<Integer, User> map = new HashMap<Integer, User>();
    private static int increment = 1;


   public static User save(User user){
      user.setId(increment++);
      map.put(user.getId(), user);
      return user;
   }

   public static Map<Integer, User> findAll(){
      return map;
   }

   public static User find(int id)  throws ClassCastException, NullPointerException{
      return map.get(id);
   }

   public static User update(User user, int id){
      if(map.containsKey(id)){
         map.remove(id);
         user.setId(id);
         map.put(user.getId(), user);
         return user;
      }else {
         return null;
      }

   }

   public static boolean delete(int id){
      if( map.remove(id) != null) return true;
      else return false;
   }



}
