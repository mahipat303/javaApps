package useCases;

import Dao.StateBankDAO;
import Dao.StateBankDAOImpl;
import Model.Account;

import java.util.Scanner;

public class DeleteAccountByIdUseCase {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter account id");
        int id = sc.nextInt();
        StateBankDAO sbo = new StateBankDAOImpl();

        String msg = sbo.deleteAccountById(id);

        System.out.println(msg);

    }
}
