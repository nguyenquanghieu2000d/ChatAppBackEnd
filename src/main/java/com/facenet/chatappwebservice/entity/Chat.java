/*
Class được tạo bởi @author Nguyễn Quang Hiếu vào 23/07/2021 4:14 PM 
*/
package com.facenet.chatappwebservice.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Chat {
    private String id;
    private String fromacc;
    private String toacc;
    private String message;
    private Timestamp date;
    private Collection<File> filesById;

    public Chat() {
    }

    public Chat(String id, String fromacc, String toacc, String message, Timestamp date) {
        this.id = id;
        this.fromacc = fromacc;
        this.toacc = toacc;
        this.message = message;
        this.date = date;
    }

    @Id
    @Column(name = "id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "fromacc")
    public String getFromacc() {
        return fromacc;
    }

    public void setFromacc(String fromacc) {
        this.fromacc = fromacc;
    }

    @Basic
    @Column(name = "toacc")
    public String getToacc() {
        return toacc;
    }

    public void setToacc(String toacc) {
        this.toacc = toacc;
    }

    @Basic
    @Column(name = "message")
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Basic
    @Column(name = "date")
    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Chat chat = (Chat) o;

        if (!Objects.equals(id, chat.id)) return false;
        if (!Objects.equals(fromacc, chat.fromacc)) return false;
        if (!Objects.equals(toacc, chat.toacc)) return false;
        if (!Objects.equals(message, chat.message)) return false;
        return Objects.equals(date, chat.date);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (fromacc != null ? fromacc.hashCode() : 0);
        result = 31 * result + (toacc != null ? toacc.hashCode() : 0);
        result = 31 * result + (message != null ? message.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Chat{" +
                "id='" + id + '\'' +
                ", fromacc='" + fromacc + '\'' +
                ", toacc='" + toacc + '\'' +
                ", message='" + message + '\'' +
                ", date=" + date +
                ", filesById=" + filesById +
                '}';
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "chatByFkMessage")
    public Collection<File> getFilesById() {
        return filesById;
    }

    public void setFilesById(Collection<File> filesById) {
        this.filesById = filesById;
    }

}
