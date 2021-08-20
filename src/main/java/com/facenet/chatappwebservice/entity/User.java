/*
Class được tạo bởi @author Nguyễn Quang Hiếu vào 23/07/2021 4:16 PM 
*/
package com.facenet.chatappwebservice.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
// lombok
//@Data
//@Getter
//@Setter
public class User {

    /**
     * Validation đọc thêm chúng ta không cần phải code validation chỉ cần add annotatopn vào là đc
     */
    @NotBlank(message = "Please username not blank")
    @NotNull(message = "Please username not null")
//    @Length
//    @Size
//    @Email
    private String username;

    @NotBlank(message = "Please password not blank")
    @NotNull(message = "Please password not null")
    private String password;

    private String hoten;

    public User() {
    }

    public User(String username) {
        this.username = username;
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User(String username, String password, String hoten) {
        this.username = username;
        this.password = password;
        this.hoten = hoten;
    }

    @Id
    @Column(name = "username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "hoten")
    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (!Objects.equals(username, user.username)) return false;
        if (!Objects.equals(password, user.password)) return false;
        return Objects.equals(hoten, user.hoten);
    }

    @Override
    public int hashCode() {
        int result = username != null ? username.hashCode() : 0;
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (hoten != null ? hoten.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", hoten='" + hoten + '\'' +
                '}';
    }
}
