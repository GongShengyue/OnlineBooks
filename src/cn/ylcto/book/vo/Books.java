package cn.ylcto.book.vo;

import java.awt.print.Book;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Books implements Serializable{
    private Integer iid;
    private String name;
    private Date credate;
    private String note;
    private Integer status;
    private Item item;//表示一本书属于一个类别 iid
    private Admin admin;//表示图书由谁增加，aid

    public Integer getIid() {
        return iid;
    }

    public void setIid(Integer iid) {
        this.iid = iid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCredate() {
        return credate;
    }

    public void setCredate(Date credate) {
        this.credate = credate;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }
}
