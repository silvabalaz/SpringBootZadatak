package sequencegenerator.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sequencegenerator.model.User;
import sequencegenerator.repository.UserRepository;

import java.util.List;

@Service
public class UserService {

    private static Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserRepository repository;

    public boolean isValid(String username, String password) {

        boolean isValid = false;

        if (username != null &&
            !username.isEmpty() &&
            password != null &&
            !password.isEmpty()) {

            final String hashedPassword = PasswordService.getPasswordHash(password);

            List<User> users = repository.findByUsername(username);
            for (User user : users) {
                if (hashedPassword.equals(user.getPassword())) {
                    isValid = true;
                    break;
                }
            }
        }

        logger.info("isValid: "+isValid+ " username:'" + username + "' password: '" + password + "'");
        return isValid;
    }
}
