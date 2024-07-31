package kroryi.javafxboard.service;

import kroryi.javafxboard.dao.UserDAO;
import kroryi.javafxboard.dto.User;

public class UserServiceImpl implements kroryi.javafxboard.service.UserService {
    private UserDAO userDAO =new UserDAO();

    @Override
    public User select(String userid) {
        return userDAO.select(userid);
    }

    @Override
    public int insert(User user) {
        return userDAO.insert(user);
    }

    @Override
    public int update(User user) {
        return 0;
    }

    @Override
    public int delete(String userid) {
        return 0;
    }
}
