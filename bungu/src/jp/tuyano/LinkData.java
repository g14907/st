package jp.tuyano;
 
import java.util.Date;
 
import javax.jdo.annotations.*;
 
@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class LinkData {
    @PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
    private Long id;
     
    @Persistent
    private String st; //注文した全部の商品
    
    @Persistent
    private String goukei;
    
    @Persistent
    private Date datetime;

    public LinkData(String st, String goukei,Date datetime) {
        super();
        this.st = st;
        this.goukei = goukei;
        this.datetime = datetime;
    }
    public Long getId() {
        return id;
    }
	public void setId(Long id) {
		this.id = id;
	}
 
    public String getSt() {
        return st;
    }
 
    public void setSt(String st) {
        this.st = st;
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
