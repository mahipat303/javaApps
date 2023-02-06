package Methods;

import Model.Book;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Scanner;

public class GetBookDetailById {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("enter book Id");
        int id = sc.nextInt();

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Library");

        EntityManager em = emf.createEntityManager();

        Book book = em.find(Book.class, id);

        if (book != null) {
            System.out.println(book);
        } else {
            System.out.println("no book available with this Id...");
        }
        em.close();

    }


}
