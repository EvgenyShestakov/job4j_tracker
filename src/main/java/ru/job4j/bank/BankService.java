package ru.job4j.bank;

import java.util.*;

public class BankService {
    private Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<Account>());
    }

    public void addAccount(String passport, Account account) {
        Optional<User> any = findByPassport(passport);
        if (any.isPresent()) {
            List<Account> accounts = users.get(any.get());
            if (!accounts.contains(account)) {
                accounts.add(account);
            }
        }  else {
            System.out.println("User not found.");
        }
    }

    public Optional<User> findByPassport(String passport) {
        Optional<User> any = users.keySet().stream().
                filter(user -> user.getPassport().equals(passport)).findAny();
        return any;
    }

    public Optional<Account> findByRequisite(String passport, String requisite) {
        Optional<User> any = findByPassport(passport);
        Optional<Account> optional = Optional.empty();
        if (any.isPresent()) {
            List<Account> accounts = users.get(any.get());
            optional = accounts.stream().
                    filter(account1 -> account1.getRequisite().equals(requisite)).findAny();
        }  else {
            System.out.println("User not found.");
        }
        return optional;
    }

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Optional<Account> accountSrc = findByRequisite(srcPassport, srcRequisite);
        Optional<Account> accountDest = findByRequisite(destPassport, destRequisite);
        if (accountSrc.isPresent() && accountDest.isPresent()) {
            if (accountSrc.get().getBalance() >= amount) {
                accountSrc.get().setBalance(accountSrc.get().getBalance() - amount);
                accountDest.get().setBalance(accountDest.get().getBalance() + amount);
                rsl = true;
            }
        } else {
            System.out.println("Account not found.");
        }
        return rsl;
    }
}
