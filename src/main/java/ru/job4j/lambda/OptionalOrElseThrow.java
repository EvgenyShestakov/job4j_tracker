package ru.job4j.lambda;

import java.util.List;
import java.util.Optional;

public class OptionalOrElseThrow {
    public static class User {

        private String login;

        public User(String login) {
            this.login = login;
        }

        public String getLogin() {
            return login;
        }
    }

    public static class UserNotFoundException extends RuntimeException {
    }

    public static User orElseThrow(List<User> list, String login) {
       Optional<User> optional = search(list, login);
        User user = null;
       if (optional.isPresent()) {
           user = optional.get();
       } else {
           Optional.empty().orElseThrow(UserNotFoundException::new);
       }
       return  user;
    }

    private static Optional<User> search(List<User> list, String login) {
        Optional<User> user = Optional.empty();
        for (User elem: list) {
            if (elem.getLogin().equals(login)) {
            user = Optional.of(elem);
            }
        }
        return user;
    }
}