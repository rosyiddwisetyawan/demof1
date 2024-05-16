package com.example.demof1.repository;

import com.example.demof1.model.TbRider;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TbRiderRepository extends JpaRepository<TbRider, Integer> {
    @Override
    boolean existsById(Integer integer);
}