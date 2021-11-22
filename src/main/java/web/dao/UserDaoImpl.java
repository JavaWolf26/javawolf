package web.dao;

import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext(unitName = "entityManagerFactory")
    private EntityManager entityManager;

    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery("select u from User u", User.class).getResultList();
    }

    @Override
    public User getUserById(int id) {
        TypedQuery<User> tq = entityManager.createQuery("select u from User u where u.id = :id", User.class);
        tq.setParameter("id", id);
        return tq.getResultList().stream().findAny().orElse(null);
    }

    @Override
    public void saveUser(User user) {
        Query query = entityManager.createNativeQuery("insert into users (firstName, lastName, age, email) " +
                "values (?, ?, ?, ?)");
        query.setParameter(1, user.getFirstName());
        query.setParameter(2, user.getLastName());
        query.setParameter(3, user.getAge());
        query.setParameter(4, user.getEmail());
        query.executeUpdate();
    }

    @Override
    public void updateUser(int id, User updateUser) {
        String query= "update users set firstName = ?, lastName=?, age=?, email=? where id = ?";
        Query nativeQuery = entityManager.createNativeQuery(query);
        nativeQuery.setParameter(1, updateUser.getFirstName());
        nativeQuery.setParameter(2, updateUser.getLastName());
        nativeQuery.setParameter(3, updateUser.getAge());
        nativeQuery.setParameter(4, updateUser.getEmail());
        nativeQuery.setParameter(5, id);
        nativeQuery.executeUpdate();
    }

    @Override
    public void deleteUser(int id) {
        Query query = entityManager.createNativeQuery("delete from users where id=?");
        query.setParameter(1, id);
        query.executeUpdate();
    }
}
