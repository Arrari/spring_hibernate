package hiber.dao;

import hiber.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void add(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> listUsers() {
        TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("from User");
        return query.getResultList();
    }

    @Override
    public List<User> getUserByModelAndSeries(String model, int series) {
        List<User> usersList = sessionFactory.getCurrentSession()
                .createQuery("SELECT u FROM User u JOIN FETCH u.car c WHERE c.model = :mod and c.series = :ser", User.class)
                .setParameter("mod", model)
                .setParameter("ser", series)
                .list();
        return usersList;
    }
}
