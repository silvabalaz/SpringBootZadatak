package sequencegenerator.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import sequencegenerator.model.Sequence;


import java.util.Date;


/**
 * Created by silva on 27.09.16..
 */


public class SequenceService {


    private static Logger logger = LoggerFactory.getLogger(SequenceService.class);

   // @Autowired
   // private SequenceRepository repository;

    public boolean save(long seq, String submittedBy, String purpose, Date date){

        boolean saved = false;
/*
        Sequence savedSequence = new Sequence();
        savedSequence.setSeq(seq);
        savedSequence.setSubmittedBy(submittedBy);
        savedSequence.setPurpose(purpose);
        //Date date = new Date();
        savedSequence.setDate(date);

        //Sequence sec = repository.save(savedSequence);


        logger.info("Saved prije: " + saved + "Sequence:" + savedSequence.getSubmittedBy() + " " + savedSequence.getPurpose() );

        if(savedSequence != null) {

            return saved = true;

        }
        logger.info("Saved poslije if-a : " + saved + "Sequence:" + savedSequence.getSubmittedBy() + " " + savedSequence.getPurpose());
*/
        return saved;

    }


}
