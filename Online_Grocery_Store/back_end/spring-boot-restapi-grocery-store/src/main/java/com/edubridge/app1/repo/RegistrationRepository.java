package com.edubridge.app1.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.edubridge.app1.model.User;

@Repository
public interface RegistrationRepository extends JpaRepository<User,Integer> {
   public User findByEmailId(String emailId);
   public User findByEmailIdAndPassword(String emailId, String password);
}
