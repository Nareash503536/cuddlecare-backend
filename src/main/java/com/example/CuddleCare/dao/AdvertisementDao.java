package com.example.CuddleCare.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.CuddleCare.entity.Advertisement;
import org.springframework.stereotype.Repository;

@Repository
public interface AdvertisementDao extends JpaRepository<Advertisement, Long>{
}
