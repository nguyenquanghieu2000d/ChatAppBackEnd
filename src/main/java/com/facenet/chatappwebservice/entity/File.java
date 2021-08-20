/*
Class được tạo bởi @author Nguyễn Quang Hiếu vào 23/07/2021 4:16 PM 
*/
package com.facenet.chatappwebservice.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class File implements Serializable {

    private String id;
    private String fkMessage;
    private String path;
    private String name;
    private Chat chatByFkMessage;


    public File() {
    }

    public File(String fkMessage, String path, String name) {

        this.fkMessage = fkMessage;
        this.path = path;
        this.name = name;
    }

    @Id
    @Column(name = "id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Id
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "fk_message", insertable=false, updatable = false)
    public String getFkMessage() {
        return fkMessage;
    }

    public void setFkMessage(String fkMessage) {
        this.fkMessage = fkMessage;
    }

    @Basic
    @Column(name = "path")
    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        File file = (File) o;

        if (!Objects.equals(id, file.id)) return false;
        if (!Objects.equals(fkMessage, file.fkMessage)) return false;
        if (!Objects.equals(name, file.name)) return false;
        if (!Objects.equals(path, file.path)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (fkMessage != null ? fkMessage.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (path != null ? path.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "fk_message", referencedColumnName = "id", nullable = false)
    public Chat getChatByFkMessage() {
        return chatByFkMessage;
    }

    @Override
    public String toString() {
        return "File{" +
                "id='" + id + '\'' +
                ", fkMessage='" + fkMessage + '\'' +
                ", path='" + path + '\'' +
                ", name='" + name + '\'' +
//                ", chatByFkMessage=" + chatByFkMessage +
                '}';
    }

    public void setChatByFkMessage(Chat chatByFkMessage) {
        this.chatByFkMessage = chatByFkMessage;
    }
}
