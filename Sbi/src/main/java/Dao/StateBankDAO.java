package Dao;

import Model.Account;

public interface StateBankDAO {

    public Account findAccountById(int id);

    public String saveAccount(Account account);

    public String deleteAccountById(int id);

    public String withdrawFromAccount(double amount, int accountId);

    public String depositInAccount(double amount, int accountId);
}
