package cn.ylcto.book.vo;

import java.io.Serializable;
import java.util.Date;

public class Lenbook implements Serializable {
    private Integer leid;
    private Books books;//表示图书编号
    private Member member;//表示用户id
    private Date credate;//借书日期

    public Integer getLeid() {
        return leid;
    }

    public void setLeid(Integer leid) {
        this.leid = leid;
    }

    public Books getBooks() {
        return books;
    }

    public void setBooks(Books books) {
        this.books = books;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member menmber) {
        this.member = menmber;
    }

    public Date getCredate() {
        return credate;
    }

    public void setCredate(Date credate) {
        this.credate = credate;
    }

    public Date getRedate() {
        return redate;
    }

    public void setRedate(Date redate) {
        this.redate = redate;
    }

    private Date redate;//归还日期
}
