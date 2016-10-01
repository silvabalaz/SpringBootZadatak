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

    public boolean save(User user){

        boolean saved= false;
        User u = repository.save(user);

        logger.info("Saved prije: " + saved + "User:" + u.getUsername() + " " + u.getPassword() );
        if(u != null) {
            return saved=true;

        }
        logger.info("Saved poslije if-a : " + saved + "User:" + u.getUsername() + " " + u.getPassword() );
        return saved;


    }

    public boolean isValid(String username, String password) {

        boolean isValid = false;

        if (username != null &&
            !username.isEmpty() &&
            password != null &&
            !password.isEmpty()) {

            final String hashedPassword = PasswordService.getPasswordHash(password);
            logger.info("hasshed password inside isValid: ------------------------->" + hashedPassword);
            List<User> users = repository.findByUsername("silva");
            logger.info(" is valid metoda: repository.findByUsername(username) " + username + "  silva " + repository.findByUsername("silva"));
            logger.info(" repository.findAll(): " + repository.findAll());
            logger.info("isValid: "+isValid+ " users " + users.size() );

            for (User user : users) {
                logger.info("for: isValid: "+isValid+ " user:'" + user.getUsername() + "' password: '" + user.getPassword() + "'");
                if (hashedPassword.equals(user.getPassword())) {
                  //if(password.equals(user.getPassword())){
                    isValid = true;
                    break;
                }
            }
        }

        logger.info("isValid: "+isValid+ " username:'" + username + "' password: '" + password + "'");
        return isValid;
    }
}
