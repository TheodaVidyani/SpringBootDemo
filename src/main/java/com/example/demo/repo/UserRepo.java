//UserRepo - This is an interface.

package com.example.demo.repo;

import com.example.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepo extends JpaRepository<User, Integer> {
    //Using a type safety, type of Entity is User, and the type of Id is Integer. (can be seen in Entity)


    //We write Queries in Repository layer
    @Query(value = "SELECT * FROM USER WHERE ID = ?1", nativeQuery = true)
 User getUserByUserID(String userId);

    @Query(value = "SELECT * FROM USER WHERE ID = ?1 AND ADDRESS = ?2", nativeQuery = true) //ADDRESS = ?@ - 2nd Argument
    User getUserByUserIDAddress(String userId, String address);

}
