package ru.netology.repository;

import org.springframework.stereotype.Repository;
import ru.netology.model.User;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import static ru.netology.repository.Authorities.*;

@Repository
public class UserRepository {
    private final List<User> users;

    public UserRepository() {
        users = new CopyOnWriteArrayList<>();
        users.add(new User("Ivan", "0000", Arrays.asList(READ, WRITE, DELETE)));
        users.add(new User("Max", "11111", Arrays.asList(READ, WRITE)));
        users.add(new User("Lena", "222", Arrays.asList(READ, DELETE)));
        users.add(new User("Fedor", "3333", List.of(DELETE)));
        users.add(new User("Ignat", "1234", Arrays.asList(WRITE, DELETE)));
        users.forEach(System.out::println);
    }

    public List<Authorities> getUserAuthorities(String user, String password) {
        List<Authorities> authorities = Collections.emptyList();
        for (User p : users) {
            if (p.getUser().equals(user) && p.getPassword().equals(password))
                authorities = p.getAuthoritiesList();
        }
        return authorities;
    }
}