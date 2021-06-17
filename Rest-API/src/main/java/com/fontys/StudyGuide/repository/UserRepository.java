package com.fontys.StudyGuide.repository;

import com.fontys.StudyGuide.models.Users.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User,Integer> {
    User findByPcn(int pcn);
}
