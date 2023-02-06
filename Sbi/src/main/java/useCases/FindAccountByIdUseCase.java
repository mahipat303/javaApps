package useCases;

import Dao.StateBankDAO;
import Dao.StateBankDAOImpl;
import Model.Account;

import java.util.Scanner;

public class FindAccountByIdUseCase {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter account id");
        int id = sc.nextInt();
        StateBankDAO sbo = new StateBankDAOImpl();

        Account account = sbo.findAccountById(id);

        if (account == null) {
            System.out.println("no account available with this id...");
        } else {
            System.out.println(account);
        }

    }

}
