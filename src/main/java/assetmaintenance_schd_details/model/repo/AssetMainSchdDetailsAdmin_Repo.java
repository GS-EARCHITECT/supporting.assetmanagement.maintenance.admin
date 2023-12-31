package assetmaintenance_schd_details.model.repo;

import java.sql.Timestamp;
import java.util.ArrayList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import assetmaintenance_schd_details.model.master.AssetMaintenanceSchdDetail;

@Repository("assetMainSchdDetailsAdminRepo")
public interface AssetMainSchdDetailsAdmin_Repo extends JpaRepository<AssetMaintenanceSchdDetail, Long> 
{	
	
	@Query(value="select * from ASSET_MAINTENANCE_SCHD_DETAILS b  where b.ASSET_MAINTENANCE_SEQ_NO in :ids order by schedule_seq_no",nativeQuery = true)
	ArrayList<AssetMaintenanceSchdDetail> getSelectSchedulesByMaintenance(@Param("ids") ArrayList<Long> ids);
	
	@Query(value="select * from ASSET_MAINTENANCE_SCHD_DETAILS b  where upper(trim(b.schedule_id)) in :ids order by schedule_seq_no",nativeQuery = true)
	ArrayList<AssetMaintenanceSchdDetail> getSelectSchedulesByScheduleIds(@Param("ids") ArrayList<String> ids);
	
	@Query(value="select * from ASSET_MAINTENANCE_SCHD_DETAILS b  where b.RESSRVPRD_SEQ_NO in :ids order by schedule_seq_no",nativeQuery = true)
	ArrayList<AssetMaintenanceSchdDetail> getSelectSchedulesByResSrvProds(@Param("ids") ArrayList<Long> ids);

	@Query(value = "SELECT * FROM ASSET_MAINTENANCE_SCHD_DETAILS where upper(trim(okflag))='Y' ORDER BY schedule_SEQ_NO",nativeQuery = true) 
	ArrayList<AssetMaintenanceSchdDetail> getAssetsOK();

	@Query(value = "SELECT * FROM ASSET_MAINTENANCE_SCHD_DETAILS where upper(trim(doneflag))='Y' ORDER BY schedule_SEQ_NO",nativeQuery = true) 
	ArrayList<AssetMaintenanceSchdDetail> getAssetsDone();

	@Query(value = "SELECT * FROM ASSET_MAINTENANCE_SCHD_DETAILS where upper(trim(okflag))<> 'Y' ORDER BY schedule_SEQ_NO",nativeQuery = true) 
	ArrayList<AssetMaintenanceSchdDetail> getAssetsNotOK();

	@Query(value = "SELECT * FROM ASSET_MAINTENANCE_SCHD_DETAILS where upper(trim(doneflag))<> 'Y' ORDER BY schedule_SEQ_NO",nativeQuery = true) 
	ArrayList<AssetMaintenanceSchdDetail> getAssetsNotDone();

	@Query(value = "SELECT * FROM ASSET_MAINTENANCE_SCHD_DETAILS where upper(trim(wipflag)) = 'Y' ORDER BY schedule_SEQ_NO",nativeQuery = true) 
	ArrayList<AssetMaintenanceSchdDetail> getAssetsWIP();
	
	@Query(value = "SELECT * FROM ASSET_MAINTENANCE_SCHD_DETAILS where upper(trim(wipflag))<> 'Y' ORDER BY schedule_SEQ_NO",nativeQuery = true) 
	ArrayList<AssetMaintenanceSchdDetail> getAssetsNotWIP();
	
	@Query(value = "SELECT * FROM ASSET_MAINTENANCE_SCHD_DETAILS where ((:fr BETWEEN FR_DTTM and TO_DTTM) and (:to BETWEEN FR_DTTM and TO_DTTM)) ORDER BY schedule_SEQ_NO",nativeQuery = true) 
	ArrayList<AssetMaintenanceSchdDetail> getAssetsBetweenDTTM(@Param(value = "fr") Timestamp fr, @Param(value = "to") Timestamp to);

	// Delete
	
	@Query(value="delete from ASSET_MAINTENANCE_SCHD_DETAILS b  where b.ASSET_MAINTENANCE_SEQ_NO in :ids ",nativeQuery = true)
	void delSelectSchedulesByMaintenance(@Param("ids") ArrayList<Long> ids);
	
	@Query(value="delete from ASSET_MAINTENANCE_SCHD_DETAILS b  where upper(trim(b.schedule_id)) in :ids",nativeQuery = true)
	void delSelectSchedulesByScheduleIds(@Param("ids") ArrayList<String> ids);
	
	@Query(value="delete from ASSET_MAINTENANCE_SCHD_DETAILS b  where b.RESSRVPRD_SEQ_NO in :ids",nativeQuery = true)
	void delSelectSchedulesByResSrvProds(@Param("ids") ArrayList<Long> ids);

	@Query(value = "delete FROM ASSET_MAINTENANCE_SCHD_DETAILS where upper(trim(okflag))='Y'",nativeQuery = true) 
	void delAssetsOK();

	@Query(value = "delete FROM ASSET_MAINTENANCE_SCHD_DETAILS where upper(trim(doneflag))='Y'",nativeQuery = true) 
	void delAssetsDone();

	@Query(value = "delete FROM ASSET_MAINTENANCE_SCHD_DETAILS where upper(trim(okflag))<> 'Y'",nativeQuery = true) 
	void delAssetsNotOK();

	@Query(value = "delete FROM ASSET_MAINTENANCE_SCHD_DETAILS where upper(trim(doneflag))<> 'Y'",nativeQuery = true) 
	void delAssetsNotDone();

	@Query(value = "delete FROM ASSET_MAINTENANCE_SCHD_DETAILS where upper(trim(wipflag)) = 'Y'",nativeQuery = true) 
	void delAssetsWIP();
	
	@Query(value = "delete FROM ASSET_MAINTENANCE_SCHD_DETAILS where upper(trim(wipflag))<> 'Y'",nativeQuery = true) 
	void delAssetsNotWIP();
	
	@Query(value = "delete FROM ASSET_MAINTENANCE_SCHD_DETAILS where ((:fr BETWEEN FR_DTTM and TO_DTTM) and (:to BETWEEN FR_DTTM and TO_DTTM))",nativeQuery = true) 
	void delAssetsBetweenDTTM(@Param(value = "fr") Timestamp fr, @Param(value = "to") Timestamp to);
	
} 

