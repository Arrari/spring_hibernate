package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      userService.add(new User("User5", "Lastname1", "user1@mail.ru", new Car("Model1", 1111)));
      userService.add(new User("User6", "Lastname2", "user2@mail.ru", new Car("Model2", 2222)));
      userService.add(new User("User7", "Lastname3", "user3@mail.ru", new Car("Model3", 3333)));
      userService.add(new User("User8", "Lastname4", "user4@mail.ru", new Car("Model4", 4444)));

      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         System.out.println();
      }
      System.out.println(userService.getUserByModelandSeries("Model1", 1111));

      context.close();
   }
}
