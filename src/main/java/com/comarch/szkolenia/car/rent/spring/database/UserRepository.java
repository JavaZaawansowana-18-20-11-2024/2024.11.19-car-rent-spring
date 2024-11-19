package com.comarch.szkolenia.car.rent.spring.database;

import com.comarch.szkolenia.car.rent.spring.model.User;
import com.comarch.szkolenia.car.rent.spring.services.IIdSequence;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class UserRepository implements IUserRepository {
    private final List<User> users = new ArrayList<>();
    private final IIdSequence idSequence;

    public UserRepository(IIdSequence idSequence) {
        this.idSequence = idSequence;
        System.out.println("UserRepository: " + System.identityHashCode(this.idSequence));
        this.users.add(new User(this.idSequence.getNextId(), "admin", "admin"));
        this.users.add(new User(this.idSequence.getNextId(), "janusz", "janusz"));
        this.users.add(new User(this.idSequence.getNextId(), "mateusz", "mateusz"));
    }

    @Override
    public List<User> findAll() {
        return this.users;
    }

    @Override
    public Optional<User> findById(final int id) {
        /*Optional<User> userBox = Optional.of(new User());
        Optional<User> userBox2 = Optional.empty();

        if(userBox.isPresent()) {
            User u = userBox.get();
        }
        userBox.orElse(new User(0, "default", "default"));
        userBox.ifPresent(System.out::println);
        userBox.ifPresentOrElse(
                u -> System.out.println(u.getId()),
                () -> System.out.println("Nie ma usera"));
        Optional<String> s = userBox.map(u -> u.getLogin());
        User user = userBox.orElseThrow(() -> new NullPointerException());
        userBox.orElseGet(() -> new User(0, "default", "default"));*/

        return this.users.stream()
                .filter(u -> u.getId() == id)
                .findFirst();
    }

    @Override
    public void persist(User user) {
        user.setId(this.idSequence.getNextId());
        this.users.add(user);
    }
}
