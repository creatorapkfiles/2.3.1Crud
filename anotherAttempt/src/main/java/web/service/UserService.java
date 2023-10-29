package web.service;

import web.model.User;

import java.util.List;

public interface UserService {
    public List<User> showAll();
    public void add(User user);
    public void update(User user);
    public void delete(Long id);
    public User getUser(Long id);

}
