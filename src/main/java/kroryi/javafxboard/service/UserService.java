package kroryi.javafxboard.service;

import kroryi.javafxboard.dto.User;

public interface UserService {
    User select(String userid);
    int insert(User user);
    int update(User user);
    int delete(String userid);
}
