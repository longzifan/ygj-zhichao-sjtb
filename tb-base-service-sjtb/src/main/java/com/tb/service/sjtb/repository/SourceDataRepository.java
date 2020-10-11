package com.tb.service.sjtb.repository;

import com.tb.service.sjtb.entity.SourceData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Repository
@Transactional
public interface SourceDataRepository extends JpaRepository<SourceData, String>, JpaSpecificationExecutor<SourceData> {

//    @Override
    @Query(nativeQuery = true, value = "SELECT \"Sid\" as \"checkDataId\",\"StCode\" as \"siteCode\",\"WeiTime\" as \"checkTime\",\"CarId\" as \"vehicleNo\",\"ImagePath\" as \"fileName\" FROM \"ytzc_fhadmin\".\"SourceData\"  where \"WeiTime\" >= :startTime and \"WeiTime\" < :endTime ")
    List<Map<String,Object>> sendUploadWeighPicInfo(Date startTime, Date endTime);
    @Query(nativeQuery = true, value = "select \"Sid\" as  \"uniqueId\",\"StName\" as \"siteName\", \"StCode\" as \"siteCode\", \"stationID\" as \"equipCode\", \"WeiTime\" as \"checkTime\", \"CarId\" as \"vehicleNo\", \"CarId\" as \"plateColor\", \"AllWei\" as \"total\", \"ZhouNum\" as \"axles\", \"LimitWei\" as \"limitWeight\", \"OverWei\" as \"overWeight\", \"OverCount\" as \"overRate\" from \"ytzc_fhadmin\".\"SourceData\" where \"WeiTime\" >= :startTime and \"WeiTime\" < :endTime ")
    List<Map<String,Object>> sendUploadWeighInfo(Date startTime, Date endTime);
}

