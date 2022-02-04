package com.dataart.cashmachine.db.repository;

import com.dataart.cashmachine.db.entity.OperationsHistoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OperationsHistoryRepository extends CrudRepository<OperationsHistoryEntity, Integer>, JpaRepository<OperationsHistoryEntity, Integer>, JpaSpecificationExecutor<OperationsHistoryEntity> {
}
