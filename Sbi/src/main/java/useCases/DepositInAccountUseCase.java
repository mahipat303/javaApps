package useCases;

import Dao.StateBankDAO;
import Dao.StateBankDAOImpl;

import java.util.Scanner;

public class DepositInAccountUseCase {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter account id");
        int id = sc.nextInt();

        System.out.println("enter amount");
        double ammount = sc.nextDouble();

        StateBankDAO sbo = new StateBankDAOImpl();

        String msg = sbo.depositInAccount(ammount, id);

        System.out.println(msg);

    }
}
