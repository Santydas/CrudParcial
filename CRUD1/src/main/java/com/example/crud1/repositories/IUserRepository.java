package com.example.crud1.repositories;

import com.example.crud1.models.userModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends JpaRepository<userModel, Long> {


}
