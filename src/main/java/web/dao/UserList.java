package web.dao;

import org.springframework.stereotype.Component;
import web.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserList {

    private final List<User> list;

    {
        list = new ArrayList<>();
        list.add(new User(1L, "Toyota", "2010", (byte) 100));
        list.add(new User(2L, "Ford", "2012", (byte) 14));
        list.add(new User(3L, "Bugatti", "2015", (byte) 25));
        list.add(new User(4L, "Ferrari", "2011", (byte) 18));
        list.add(new User(5L, "Lamborghini", "2010", (byte) 19));
    }

    public List<User> select(String count){
        if (count == null) {
            return list;
        } else {
            return list.stream()
                    .limit(Integer.parseInt(count))
                    .collect(Collectors.toList());
        }
    }
}
