package sequencegenerator.web.sequence;

import java.util.Date;

/**
 * Created by silva on 26.09.16..
 */

public class SequenceDto {

    private String purpose;

    private String submittedBy;

    private long seq;

    private Date date;

    public long getSeq() {
        return seq;
    }

    public void setSeq(long seq) {
        this.seq = seq;
    }

    public String getSubmittedBy() {
        return submittedBy;
    }

    public void setSubmittedBy(String submittedBy) { this.submittedBy = submittedBy; }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(final String purpose) {
        this.purpose = purpose;
    }

    public Date getDate() { return date; }

    public void setDate(Date date) { this.date = date; }


}
