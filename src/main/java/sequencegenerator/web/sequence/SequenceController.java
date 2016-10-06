package sequencegenerator.web.sequence;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import sequencegenerator.model.Sequence;
import sequencegenerator.service.SequenceService;
import sequencegenerator.web.login.LoginDto;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@Controller
@RequestMapping("sequence")
public class SequenceController {

    private static final String LIST_VIEW = "sequence_list";
    private static final String CREATE_VIEW = "sequence_create";

    private static Logger logger = LoggerFactory.getLogger(SequenceController.class);

   //@Autowired
   // private SequenceService service;

    @RequestMapping(value = "list", method = RequestMethod.GET)
    public String list(LoginDto loginInfo, ModelMap model,
                       @CookieValue(value = "JSESSIONID", defaultValue = "0") String cookie,
                       HttpServletRequest request , HttpServletResponse response) {
        logger.info("Show sequence list");

        Cookie newCookie = new Cookie("cookie", cookie );

        HttpSession session = request.getSession(true);

        if (session != null) {
            String sessionId = session.getId();
            session.invalidate();
            Cookie[] cookies = request.getCookies();
            for (Cookie c : cookies) {
                if (sessionId.equalsIgnoreCase(c.getValue())) {
                    c.setMaxAge(0);
                    c.setValue(null);
                    c.setDomain(request.getServerName());
                    c.setPath(request.getServletContext().getContextPath() + "/");
                    c.setSecure(request.isSecure());
                    response.addCookie(c);
                    break;
                }
            }
        }
        response.addCookie(newCookie);
        
        return LIST_VIEW;
    }

    @RequestMapping(value = "create", method = RequestMethod.GET)
    public String showCreate(ModelMap model) {
        logger.info("Show create screen");

        //model.put("sequence", new Sequence());
        return CREATE_VIEW;
    }

    @RequestMapping(value="create", method=RequestMethod.POST, params="action=save")
    public String save(SequenceDto sequenceInfo, ModelMap model) {
        logger.info("Save sequence ");

        return LIST_VIEW;
    }

    @RequestMapping(value="create", method=RequestMethod.POST, params="action=cancel")
    public String cancel(SequenceDto sequenceInfo, ModelMap model) {
        logger.info("Cancel new sequence ");

        //boolean da = service.save(sequenceInfo.getSeq(),sequenceInfo.getSubmittedBy(), sequenceInfo.getPurpose(),sequenceInfo.getDate() ) ;

        return LIST_VIEW;
    }


}

