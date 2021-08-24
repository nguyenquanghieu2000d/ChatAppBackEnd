package com.facenet.chatappwebservice.repository;

import com.facenet.chatappwebservice.entity.Chat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChatRepository extends JpaRepository<Chat, String> {

    @Query("SELECT s FROM Chat s WHERE (s.fromacc = ?1 AND s.toacc = ?2) OR (s.fromacc = ?2 AND s.toacc = ?1) ORDER BY s.date ASC")
    List<Chat> getChatFrom2User(String user1, String user2);
}
