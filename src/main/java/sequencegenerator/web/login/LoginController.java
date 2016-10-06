package sequencegenerator.web.login;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import sequencegenerator.model.User;
import sequencegenerator.service.PasswordService;
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

        //logger.info("Login submit -> loginInfo: '" + loginInfo.getUsername() + "' password: '" + loginInfo.getPassword() + "'");
        //logger.info("hasshed password: " + PasswordService.getPasswordHash(loginInfo.getPassword()));

        User u = new User();
        u.setId(1);
        u.setUsername("silva");
        u.setPassword("1234");
        service.save(u);

        //logger.info(" u: " + u.getId() + " username: " + u.getUsername() + " password: " + u.getPassword());
        //logger.info( "service.save(u): " + service.save(u) );
        logger.info("service.isValid::  " + service.isValid(u.getUsername(), u.getPassword()));
       // logger.info("prije ifa model.put  " + model.put("name",loginInfo.getUsername()));
        if(service.isValid(loginInfo.getUsername(), loginInfo.getPassword())){
            //model.put("name", loginInfo.getUsername());
            return "redirect:/sequence/list";}

        model.put("isWrongPassword", true);


        return showForm(model);
    }
}