package org.example.task4;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import java.util.Arrays;
import java.util.List;

@ComponentScan(basePackages = "org.example.task4")
public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Main.class);
        System.out.println(Arrays.asList(context.getBeanDefinitionNames()));
        UserService userService = context.getBean(UserService.class);

        System.out.println("------Part1: addUser--------" );
        userService.addUser("Alex8");
        userService.addUser("Leon9");
        userService.addUser("Moly10");

        System.out.println("------Part2: getAll--------" );
        List<User> users = userService.getAll();
        if(users != null)
            for (User u: users) {
                System.out.print(u.getId()+" "+u.getUsername()+"; ");
            }
        System.out.println();

        System.out.println("------Part3: delete--------" );
        userService.delete(12);
        userService.delete(13);

        System.out.println("------Part4: getAll--------" );
        users = userService.getAll();
        for (User u: users) {
            System.out.print(u.getId()+" "+u.getUsername()+"; ");
        }
        System.out.println();

        System.out.println("------Part5: getByUsername--------" );
        User user1 = userService.getByUsername("Alex8");
        if(user1 != null) System.out.println(user1.getId()+" "+user1.getUsername());
        User user2 = userService.getByUsername("Moly9");
        if(user2 != null) System.out.println(user2.getId()+" "+user2.getUsername());




    }
}
