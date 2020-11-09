import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class UserService {
    private UserRepository userRepository;

    @Autowired
    public void setInMemoryUserRepository(@Qualifier(value = "memoryUserRepository")UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void printAllUsers() {
        List<User> users = userRepository.findAllUsers();
        for (User u : users) {
            System.out.println(u);
        }
    }

    public void deleteAllUsers() {
        userRepository.getUsers().clear();
    }
}