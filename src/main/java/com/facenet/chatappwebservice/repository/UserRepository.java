/*
Class được tạo bởi @author Nguyễn Quang Hiếu vào 11/08/2021 5:10 PM 
*/
package com.facenet.chatappwebservice.repository;

import com.facenet.chatappwebservice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

    User getUserByUsernameAndPassword(String username, String password);
}
