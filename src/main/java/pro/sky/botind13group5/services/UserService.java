package pro.sky.botind13group5.services;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import pro.sky.botind13group5.enums.UserType;
import pro.sky.botind13group5.model.User;
import pro.sky.botind13group5.repository.UserRepository;

import java.util.List;

@Component
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User addUser(long telegramId, String nickName, UserType userType) {

        User newUser = new User(telegramId, nickName, userType);
        User user = userRepository.findByTelegramId(telegramId);
        if (user == null) {
            userRepository.save(newUser);
            return newUser;
        }
        return user;
    }

    @Transactional
    public User findUserByTelegramId(long telegramId) {
        return userRepository.findByTelegramId(telegramId);
    }

    public List<User> getAllUsers() {
        return userRepository.getAllUsers();
    }
}
