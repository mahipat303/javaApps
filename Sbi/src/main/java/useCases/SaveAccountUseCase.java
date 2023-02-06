package useCases;

import Dao.StateBankDAO;
import Dao.StateBankDAOImpl;
import Model.Account;

import java.util.Scanner;

public class SaveAccountUseCase {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter  email");
        String email = sc.next();

        System.out.println("enter  address");
        String address = sc.next();

        System.out.println("enter  balance");
        double balance = sc.nextDouble();

        System.out.println("enter  date in yyyy-mm-dd format");
        String created_date = sc.next();

        Account account = new Account(email, address, balance, created_date);

        StateBankDAO sbo = new StateBankDAOImpl();


        String ans = sbo.saveAccount(account);

        System.out.println(ans);

    }

}
