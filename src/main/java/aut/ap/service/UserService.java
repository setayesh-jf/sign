package aut.ap.service;


import aut.ap.framework.SingletonSessionFactory;
import aut.ap.model.User;
import java.util.List;



public class UserService {


    public static void persist(String firstname, String lastname, int age, String email, String password) {
        SingletonSessionFactory.get().inTransaction(session -> {
            User existingUser = session.createQuery("from User where email = :email", User.class)
                    .setParameter("email", email)
                    .uniqueResult();

            if (existingUser != null) {
                System.out.println("An account with this email already exists.");
                return;
            }

            if (password.length() < 8) {
                System.out.println("Weak password");
                return;
            }

            User newUser = new User(firstname, lastname, age, email, password);
            session.persist(newUser);
        });
    }


    public static User login(String email, String password) {
        return SingletonSessionFactory.get().fromTransaction(session -> {
            User user = session.createQuery("from User where email = :email and password = :password", User.class)
                    .setParameter("email", email)
                    .setParameter("password", password)
                    .uniqueResult();

            if (user == null) {
                System.out.println("Invalid email or password.");
                return null;
            }

            System.out.println("Welcome, " + user.getFirstname() + " " + user.getLastname() + "!");
            return user;
        });
    }

    public static List<User> getAllUsers() {
        return SingletonSessionFactory.get()
                .fromTransaction(session -> session.createQuery("from User", User.class).getResultList());
    }
}