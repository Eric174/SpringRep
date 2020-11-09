import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BadUserRepository implements UserRepository {

    @Override
    public List<User> findAllUsers() {
        throw new UnsupportedOperationException("findAllUsers");
    }

    @Override
    public List<User> getUsers() {
        return null;
    }

    @Override
    public void addUser(User user) {
        throw new UnsupportedOperationException("addUser");
    }

    @Override
    public void deleteUser(int id) {
        throw new UnsupportedOperationException("deleteUser");
    }

    @Override
    public User findUser(String name) {
        return null;
    }
}
