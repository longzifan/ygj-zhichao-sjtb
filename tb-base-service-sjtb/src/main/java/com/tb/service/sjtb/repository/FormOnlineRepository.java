package com.tb.service.sjtb.repository;

import com.tb.service.sjtb.entity.FormOnline;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface FormOnlineRepository extends JpaRepository<FormOnline, String>, JpaSpecificationExecutor<FormOnline> {

    void deleteByIdEquals(String id);

    List<FormOnline> findAllByTableNameEqualsAndDbSourceEquals(String tableName, String dbSource);

    FormOnline getByIdEquals(String id);

}

