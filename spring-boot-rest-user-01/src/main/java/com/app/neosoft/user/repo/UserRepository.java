package com.app.neosoft.user.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.app.neosoft.user.model.User;
@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	List<User> findByNameLike(@Param("value") String value);
//	List<User> findByPincodeLike(@Param("value") Integer value);

}
