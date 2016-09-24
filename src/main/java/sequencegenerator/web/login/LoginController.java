package sequencegenerator.web.login;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import sequencegenerator.model.User;
import sequencegenerator.service.UserService;

/**
 * Created by silva on 20.09.16..
 */
@Controller
@RequestMapping("login")
public class LoginController {

    private static final String LOGIN_VIEW = "login";

    private static Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private UserService service;

    @RequestMapping(method = RequestMethod.GET)
    public String showForm(ModelMap model) {
        logger.info("showForm");
        model.put("user", new User());
        return LOGIN_VIEW;
    }

    @RequestMapping(method = RequestMethod.POST)
    public String submit(LoginDto loginInfo, ModelMap model) {

        logger.info("Login submit -> loginInfo: '" + loginInfo.getUsername() + "' password: '" + loginInfo.getPassword() + "'");

        if(service.isValid(loginInfo.getUsername(), loginInfo.getPassword()))
            return "redirect:/sequence/list";

        model.put("isWrongPassword", true);
        return showForm(model);
    }
}