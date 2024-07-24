package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import web.models.User;
import web.repositories.UsersRepositories;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class UserService {

    private final UsersRepositories usersRepositories;

    @Autowired
    public UserService(UsersRepositories usersRepositories) {
        this.usersRepositories = usersRepositories;
    }

    public List<User> findAll() {
        return usersRepositories.findAll();
    }

    public User findOne(int id) {
        Optional<User> foundPerson = usersRepositories.findById(id);
        return foundPerson.orElse(null);
    }

    @Transactional
    public void save(User user) {
        usersRepositories.save(user);
    }

    @Transactional
    public void update(int id, User updatedUser) {
        updatedUser.setId(id);
        usersRepositories.save(updatedUser);
    }

    @Transactional
    public void delete(int id) {
        usersRepositories.deleteById(id);
    }
}