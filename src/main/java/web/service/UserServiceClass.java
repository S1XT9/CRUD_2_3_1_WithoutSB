package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.dao.UserRepository;
import web.model.User;

import java.util.List;

@Service
public class UserServiceClass implements UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserServiceClass(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void create(User user) {
        userRepository.create(user);

    }

    @Override
    public User read(Long id) {
        return userRepository.read(id);
    }

    @Override
    public void update(User user) {
        userRepository.update(user);
    }

    @Override
    public void delete(Long id) {
        userRepository.delete(id);
    }

    @Override
    public List<User> allUsers() {
        return userRepository.allUsers();
    }
}
