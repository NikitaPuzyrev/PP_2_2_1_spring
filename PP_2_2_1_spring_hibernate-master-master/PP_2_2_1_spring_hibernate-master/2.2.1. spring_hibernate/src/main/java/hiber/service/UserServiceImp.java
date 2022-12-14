package hiber.service;
import hiber.dao.UserDao;
import hiber.model.Car;
import hiber.model.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;


@Service
public class UserServiceImp implements UserService {
   private final UserDao userDao;
   public UserServiceImp(UserDao userDao) {
      this.userDao = userDao;
   }
   @Transactional
   @Override
   public void add(User user, Car car) {
      userDao.add(user, car);
   }
   @Transactional(readOnly = true)
   @Override
   public List<User> listUsers() {
      return userDao.listUsers();
   }
   @Override
   @Transactional
   public User userCar(String model, double series) {
      return userDao.userCar(model, series);
   }
}

