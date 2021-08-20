/*
Class được tạo bởi @author Nguyễn Quang Hiếu vào 11/08/2021 4:33 PM 
*/
package com.facenet.chatappwebservice.service;

import com.facenet.chatappwebservice.entity.User;
import com.facenet.chatappwebservice.error.NotFoundException;
import com.facenet.chatappwebservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {

        List<User> user = userRepository.findAll();
        return user;
    }


    public void addUser(User user) {

        userRepository.save(user);
    }

    @Transactional
    public void updateUser(String id, User user) {

        Optional<User> checkUser = userRepository.findById(id);
        if(checkUser.isPresent()) {
            User userz = checkUser.get();
            userz.setHoten(user.getHoten());
            userz.setPassword(user.getPassword());
        }
        else throw new IllegalStateException("Không có user " + id);
    }

    public void deleteUser(String id) {

        if(userRepository.existsById(id)) userRepository.deleteById(id);
        else throw new NotFoundException("Không có user " + id);
    }

    /**
     * Kiểm tra xem tài khoản có trong database hay không
     *
     * @param user
     * @return
     */
    public boolean validateUser(User user) {

        return userRepository.getUserByUsernameAndPassword(user.getUsername(), user.getPassword()) != null;
    }
}
