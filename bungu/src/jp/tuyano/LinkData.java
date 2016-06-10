package jp.tuyano;
 
import java.util.Date;
 
import javax.jdo.annotations.*;
 
@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class LinkData {
    @PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
    private Long id;
     
    @Persistent
    private String myform;
    
    @Persistent
    private String goukei;
    
    @Persistent
    private Date datetime;

    public LinkData(String myform, String goukei,Date datetime) {
        super();
        this.myform = myform;
        this.datetime = datetime;
    }
 
    public Long getMyform() {
        return id;
    }
 
    public void setMyform(String myform) {
        this.myform = myform;
    }
 
    public String getGoukei() {
        return goukei;
    }
 
    public void setGoukei(String goukei) {
        this.goukei = goukei;
    }
 
 
    public Date getDatetime() {
        return datetime;
    }
 
    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }
}
