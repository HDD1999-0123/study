package service.impl;

import bean.Users;
import dao.UserDao;
import dao.impl.UserDaoImpl;
import service.UserService;

import java.util.List;

/**
 * @ClassName:
 * @Descripton:
 * @author: hedd
 */
public class UserServiceImpl implements UserService {
    UserDao userDao = new UserDaoImpl();
    @Override
    public List<Users> getUsersList(int pageIndex, int pageSize) {
        return userDao.getUsersList(pageIndex,pageSize);
    }

    @Override
    public int total() {
        return userDao.total();
    }
}
