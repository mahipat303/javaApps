package Methods;

import Model.Book;
import org.hibernate.query.criteria.internal.expression.function.CurrentDateFunction;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Date;
import java.util.Scanner;

public class CreateBook {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("enter book name");
        String name = sc.next();

        System.out.println("enter book author");
        String authod = sc.next();
        System.out.println("enter book publication");
        String publication = sc.nextLine();

        System.out.println("enter book category");
        String category = sc.nextLine();
        System.out.println("enter book pages");
        int pages = sc.nextInt();
        System.out.println("enter book price");
        int price = sc.nextInt();

        String CurrentDateFunction = null;
        String date = CurrentDateFunction.toString();

        Book book = new Book(name, authod, publication, category, pages, price, date);
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Library");

        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        em.persist(book);

        em.getTransaction().commit();

        em.close();

        System.out.println("Book created successfully...");

    }

}
