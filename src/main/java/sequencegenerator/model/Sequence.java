package sequencegenerator.model;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;


import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Created by silva on 26.09.16..
 */
public class Sequence {

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long seq;

    @NotEmpty(message = "Greška, krivi korisnik.")
    private String submittedBy;

    @NotEmpty(message = "Opis mora biti minimalno duljine jednog znaka")
    private String purpose;

    @DateTimeFormat(pattern = "MM FF yy, HH:mm:SS a")
    private Date date;

    public Sequence() {
    }

    public Sequence(String submittedBy, String purpose) {

        this.submittedBy = submittedBy;
        this.purpose = purpose;
    }

    public long getSeq() {
        return seq;
    }

    public void setSeq(long seq) {this.seq = seq;}

    public String getSubmittedBy() {
        return submittedBy;
    }

    public void setSubmittedBy(String submittedBy) {
        this.submittedBy = submittedBy;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) { this.purpose = purpose; }

    @Column
    public Date getDate() { return date; }

    public void setDate(Date date) { this.date = date; }

    @Override
    public String toString() {
        return String.format(
                "Sequence[id=%d, submittedBy='%s', purpose = '%s' date= 'MM FF yy, HH:mm:SS a' ]",
                seq, submittedBy , purpose, date);
    }
}

