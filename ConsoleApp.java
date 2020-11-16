package product;

//import com.flamexander.hibernate.PrepareDataApp;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;
import java.util.Scanner;

public class ConsoleApp {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("configs/hibernate.cfg.xml")
                .buildSessionFactory();

        Scanner sc = new Scanner(System.in);
        Session session = null;
        String[] commands;

        while (true) {
            System.out.println("Список команд:");
            String command = sc.nextLine();
            commands = command.split(" ", 3);
            session = factory.getCurrentSession();
            session.beginTransaction();
            if (commands[0].equals("get")) {
                if (commands[1].equals("cust")) {
                    List<Product> productList =
                            session.createQuery("SELECT s.id_product FROM CUSTOMERS_PRODUCTS s WHERE id_customer = :id").
                                    setParameter("id", commands[2]).
                                    getResultList();
                    System.out.println(productList);
                } else if (commands[1].equals("prod")) {
                    List<Customer> customers =
                            session.createQuery("SELECT s.id_customer FROM CUSTOMERS_PRODUCTS s WHERE id_product = :id").
                                    setParameter("id", commands[2]).
                                    getResultList();
                    System.out.println(customers);
                } else {
                    System.out.println("Неверная команда");
                }
            } else if (command.equals("delete")) {
                if (commands[1].equals("cust")) {

                } else if (commands[1].equals("prod")) {

                } else {
                    System.out.println("Неверная команда");
                }
            } else if (command.equals("exit")) {
                break;
            } else {
                System.out.println("Неверная команда");
            }
            session.getTransaction().commit();
        }
    }
}
