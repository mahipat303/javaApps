package SBIUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class SBIM {

    private static EntityManagerFactory emf;

    static {
        emf = Persistence.createEntityManagerFactory("accountUnit");
    }

    public static EntityManager provide() {
        return emf.createEntityManager();
    }


}
