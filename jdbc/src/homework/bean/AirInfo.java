package homework.bean;

import java.util.Date;

/**
 * @ClassName:
 * @Descripton:
 * @author: hedd
 */
public class AirInfo {
    private Integer id;
    private String airNum;
    private String destination;
    private Date airDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAirNum() {
        return airNum;
    }

    public void setAirNum(String airNum) {
        this.airNum = airNum;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Date getAirDate() {
        return airDate;
    }

    public void setAirDate(Date airDate) {
        this.airDate = airDate;
    }
}
