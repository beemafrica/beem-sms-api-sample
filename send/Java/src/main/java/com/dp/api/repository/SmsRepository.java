package com.dp.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dp.api.entity.SmsEntity;

/**
 * SmsRepository .
 * 
 * @author admin
 *
 */
@Repository
public interface SmsRepository extends JpaRepository<SmsEntity, Integer> {

}
