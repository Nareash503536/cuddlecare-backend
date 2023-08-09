package com.example.CuddleCare.dao;

import com.example.CuddleCare.entity.Parents;
import com.example.CuddleCare.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParentDao extends JpaRepository<Parents, Long> {
        Parents findByUser(User user);

        Parents findByParentID(Long parentId);

}
