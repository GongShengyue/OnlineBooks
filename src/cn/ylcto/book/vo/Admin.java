package cn.ylcto.book.vo;

import java.sql.Timestamp;
import java.util.Date;

/**
 * @Authour:gsy
 * @Description:
 * @Date: 11:24 AM 2019/7/4
 */
public class Admin {

    private String aid;

    private String password;

    private Timestamp lastdate;

    private int flag;

    private int status;

    public String getAid() {
        return aid;
    }

    public void setAid(String aid) {
        this.aid = aid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Timestamp getLastdate() {
        return lastdate;
    }

    public void setLastdate(Timestamp lastdate) {
        this.lastdate = lastdate;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
