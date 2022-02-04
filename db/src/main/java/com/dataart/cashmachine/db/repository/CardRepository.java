package com.dataart.cashmachine.db.repository;

import com.dataart.cashmachine.db.entity.CardEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardRepository extends CrudRepository<CardEntity, Long>, JpaRepository<CardEntity, Long>, JpaSpecificationExecutor<CardEntity> {
}
