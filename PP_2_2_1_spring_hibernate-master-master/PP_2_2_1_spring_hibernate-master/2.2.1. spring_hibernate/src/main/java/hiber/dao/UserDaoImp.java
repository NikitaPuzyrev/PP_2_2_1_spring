package hiber.dao;

import hiber.model.Car;
import hiber.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;


@Repository
public class UserDaoImp implements UserDao {
    private final SessionFactory sessionFactory;

    public UserDaoImp(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void add(User user, Car car) {
        Session session = sessionFactory.getCurrentSession();
        user.setUsCar(car);
        session.save(user);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> listUsers() {
        TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("from User");
        return query.getResultList();
    }

    @Override
    public User userCar(String model, double series) {
        Car car = new Car(model, series);
        Query query = sessionFactory.getCurrentSession().createQuery("from User");
        List<User> list = query.getResultList();
        return list.stream().filter(user -> user.getUsCar().equals(car)).findAny().orElse(null);
    }
/*    @Override
    public List<User> userCar(String model, double series) {
        List<User> users = new ArrayList<>();
        Query query = sessionFactory.getCurrentSession()
                .createQuery("from Car car  where (car.series = :seriesParam) and (car.model = :paramModel)");
        query.setParameter("seriesParam", series).
                setParameter("paramModel", model);

        List<Car> cars = query.getResultList();
        for (Car car : cars) {
         //   System.out.println(car.getCarUser());
          //  users.add(car.getCarUser());
        }
        return users;
    }*/
}
