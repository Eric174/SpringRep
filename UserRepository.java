import java.util.List;

public interface UserRepository {
    List<User> findAllUsers();
    List<User> getUsers();
    void addUser(User user);
    void deleteUser(int id);
    User findUser(String name);
}
