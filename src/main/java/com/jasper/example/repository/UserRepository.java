package com.jasper.example.repository;

import com.jasper.example.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by artyov.igor on 17.07.2016.
 */
@Repository
public interface UserRepository extends JpaRepository<Users,Integer> {
}
