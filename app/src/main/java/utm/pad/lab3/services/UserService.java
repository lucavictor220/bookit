package utm.pad.lab3.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import utm.pad.lab3.model.User;
import utm.pad.lab3.repository.UserRepository;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User insert(User user) {
        return userRepository.insert(user);
    }

    public User findById(String id) {
        return userRepository.findUserById(id);
    }

    public List<User> findbyFirstName(String firstName) {
        return userRepository.findAllByFirstname(firstName);
    }

    public List<User> findByLastName(String lastName) {
        return userRepository.findAllByLastname(lastName);
    }

    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public User findByPhoneNumber(Long msisdn) {
        return userRepository.findByPhone(msisdn);
    }

    public void update(User user) {
        userRepository.save(user);
    }

    public void delete(User  user) {
        userRepository.delete(user);
    }
}