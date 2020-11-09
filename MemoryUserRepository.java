import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Repository
public class MemoryUserRepository implements UserRepository {
    private List<User> users;

    @PostConstruct
    public void init() {
        this.users = new ArrayList<>();
        this.users.add(new User(10, "Eric"));
        this.users.add(new User(20, "Kenny"));
    }

    @Override
    public List<User> findAllUsers() {
        return Collections.unmodifiableList(users);
    }

    @Override
    public List<User> getUsers() {
        return users;
    }

    @Override
    public void addUser(User user) {
        users.add(user);
    }

    @Override
    public void deleteUser(int id) {
        for (User u : users) {
            if (u.getId() == id) {
                users.remove(u);
                break;
            }
        }
    }

    @Override
    public User findUser(String name) {
        for (User u : users) {
            if (u.getName().equals(name)) {
                return u;
            }
        }
        return null;
    }
}
