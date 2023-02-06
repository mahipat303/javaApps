package Dao;

import Model.Account;
import SBIUtil.SBIM;

import javax.persistence.EntityManager;

public class StateBankDAOImpl implements StateBankDAO {


    @Override
    public Account findAccountById(int id) {

        EntityManager emf = SBIM.provide();

        Account account1 = emf.find(Account.class, id);

        emf.close();

        return account1;

    }

    @Override
    public String saveAccount(Account account) {

        String message = null;

        EntityManager em = SBIM.provide();


        em.getTransaction().begin();

        em.persist(account);

        em.getTransaction().commit();

        message = "account created...";
        em.close();

        return message;
    }

    @Override
    public String deleteAccountById(int id) {
        String msg = null;
        EntityManager em = SBIM.provide();

        Account account = em.find(Account.class, id);

        if (account == null) {
            msg = "no account available with this id";
        } else {
            em.getTransaction().begin();

            em.remove(account);

            em.getTransaction().commit();

            msg = "deleted successfully";
        }

        em.close();

        return msg;
    }

    @Override
    public String withdrawFromAccount(double amount, int accountId) {
        String msg = null;
        EntityManager em = SBIM.provide();

        Account account = em.find(Account.class, accountId);

        if (account == null) {
            msg = "no account available with this id";
        } else {

            if (amount >= account.getBalance()) {
                msg = "insufficient balance";
            } else {
                em.getTransaction().begin();

                account.setBalance(account.getBalance() - amount);

                em.getTransaction().commit();

                msg = "withdraw successfully";
            }

        }
        em.close();

        return msg;
    }

    @Override
    public String depositInAccount(double amount, int accountId) {
        String msg = null;
        EntityManager em = SBIM.provide();

        Account account = em.find(Account.class, accountId);

        if (account == null) {
            msg = "no account available with this id";
        } else {

            em.getTransaction().begin();

            account.setBalance(account.getBalance() + amount);

            em.getTransaction().commit();

            msg = "deposit successfully";

        }
        em.close();

        return msg;
    }
}
