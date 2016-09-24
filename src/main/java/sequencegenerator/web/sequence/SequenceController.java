package sequencegenerator.web.sequence;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("sequence")
public class SequenceController {

    private static final String LIST_VIEW = "sequence_list";
    private static final String CREATE_VIEW = "sequence_create";

    private static Logger logger = LoggerFactory.getLogger(SequenceController.class);

    @RequestMapping(value = "list", method = RequestMethod.GET)
    public String list(ModelMap model) {
        logger.info("Show sequence list");
        //TODO
        return LIST_VIEW;
    }

    @RequestMapping(value = "create", method = RequestMethod.GET)
    public String showCreate(ModelMap model) {
        logger.info("Show create screen");
        //TODO
        return CREATE_VIEW;
    }

    @RequestMapping(value = "create", method = RequestMethod.POST)
    public String createSequence(ModelMap model) {
        logger.info("Show create sequence screen");
        //TODO
        return CREATE_VIEW;
    }
}
