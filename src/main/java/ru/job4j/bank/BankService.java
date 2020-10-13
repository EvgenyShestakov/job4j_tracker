package ru.job4j.bank;

import java.util.*;
import java.util.stream.Stream;

public class BankService {
    private Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<Account>());
    }

    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
            List<Account> accounts = users.get(user);
            if (!accounts.contains(account)) {
                accounts.add(account);
            }
    }

    public User findByPassport(String passport) {
        User userFind = null;
        Optional<User> optional = users.keySet().stream()
                .filter(user -> user.getPassport().equals(passport)).findAny();
        if (optional.isPresent()) {
            userFind = optional.get();
        } else {
            System.out.println("Passport number not found");
        }
        return userFind;
    }

    public Account findByRequisite(String passport, String requisite) {
        Account account = null;
        User user = findByPassport(passport);
            List<Account> accounts = users.get(user);
         Optional<Account> optional = accounts.stream().
                 filter(account1 -> account1.getRequisite().equals(requisite)).findAny();
         if (optional.isPresent()) {
             account = optional.get();
         } else {
             System.out.println("Requisites not found");
         }

        return account;
    }

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Account accountSrc = findByRequisite(srcPassport, srcRequisite);
        Account accountDest = findByRequisite(destPassport, destRequisite);
        if (accountSrc != null && accountDest != null && accountSrc.getBalance() >= amount) {
            accountSrc.setBalance(accountSrc.getBalance() - amount);
            accountDest.setBalance(accountDest.getBalance() + amount);
            rsl = true;
        }
        return rsl;
    }
}
