package com.Service.User.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.Service.User.Entity.UserEntity;

@Repository
public interface userRepository extends JpaRepository<UserEntity, Long> {

	
	@Query("select u from UserEntity u where u.email =:emailId")
	public UserEntity findByEmail(String emailId);
}
