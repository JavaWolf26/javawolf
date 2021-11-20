package web.dao;

import org.springframework.stereotype.Component;
import web.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
public class UserList {

    private int COUNT;
    private final List<User> list;

    {
        list = new ArrayList<>();
        list.add(new User(++COUNT, "Toyota"/*, "2010", "100"*/));
        list.add(new User(++COUNT, "Ford"/*, "2012", "14"*/));
        list.add(new User(++COUNT, "Bugatti"/*, "2015", "25"*/));
        list.add(new User(++COUNT, "Ferrari"/*, "2011", "18"*/));
        list.add(new User(++COUNT, "Lamborghini"/*, "2010", "19"*/));
    }

    public List<User> getAllUsers() {
        return list;
    }

    public User getUserById(int id){
        return list.stream().filter(user -> Objects.equals(user.getId(), id)).findAny().orElse(null);
    }

    public void save(User user){
        user.setId(++COUNT);
        list.add(user);
    }

    public void update(int id, User updateUser){
        User userUpdated = getUserById(id);
        userUpdated.setFirstName(updateUser.getFirstName());
    }

    public void delete(int id){
        list.removeIf(p -> p.getId() == id);
    }
}
