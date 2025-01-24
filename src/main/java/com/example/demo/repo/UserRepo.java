//UserRepo - This is an interface.

package com.example.demo.repo;

import com.example.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Integer> {
    //Using a type safety, type of Entity is User, and the type of Id is Integer. (can be seen in Entity)
}
