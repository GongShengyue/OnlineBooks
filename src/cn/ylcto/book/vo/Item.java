package cn.ylcto.book.vo;

import java.io.Serializable;

public class Item implements Serializable{
    private Integer iid;
    private String name;
    private String note;

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

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
