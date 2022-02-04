package com.dataart.cashmachine.db.repository;

import com.dataart.cashmachine.db.entity.OperationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OperationRepository extends CrudRepository<OperationEntity, Integer>, JpaRepository<OperationEntity, Integer>, JpaSpecificationExecutor<OperationEntity> {
}
