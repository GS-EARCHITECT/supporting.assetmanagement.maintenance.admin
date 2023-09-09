package assetmaintenance_schd_details.service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import assetmaintenance_schd_details.model.dto.AssetMaintenanceSchdDetail_DTO;
import assetmaintenance_schd_details.model.master.AssetMaintenanceSchdDetail;
import assetmaintenance_schd_details.model.repo.AssetMainSchdDetailsAdmin_Repo;

@Service("assetMaintSchdDetailsAdminServ")
@Scope(value = "prototype", proxyMode = ScopedProxyMode.TARGET_CLASS)
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
public class AssetMaintenanceSchdDetailsAdmin_Service implements I_AssetMaintenanceSchdDetailsAdmin_Service 
{
	//private static final Logger logger = LoggerFactory.getLogger(AssetMaintenanceSchdDetailService.class);
	
	@Autowired
    private AssetMainSchdDetailsAdmin_Repo assetMainSchdDetailsAdminRepo;
	
	public AssetMaintenanceSchdDetail_DTO newAssetMaintenanceSchdDetail(AssetMaintenanceSchdDetail_DTO lMaster) 
	{
		if(!assetMainSchdDetailsAdminRepo.existsById(lMaster.getScheduleSeqNo()))
		{
		lMaster = this.getAssetMaintenanceSchdDetail_DTO(assetMainSchdDetailsAdminRepo.save(this.setAssetMaintenanceSchdDetail(lMaster)));
		}
		return lMaster;
	}

	public ArrayList<AssetMaintenanceSchdDetail_DTO> getAllAssetMaintenanceSchdDetails() 
	{
		ArrayList<AssetMaintenanceSchdDetail> assetMaintList =  (ArrayList<AssetMaintenanceSchdDetail>) assetMainSchdDetailsAdminRepo.findAll();
		ArrayList<AssetMaintenanceSchdDetail_DTO> lMasterss = assetMaintList != null ? this.getAssetMaintenanceSchdDetailDtos(assetMaintList) : null;
		return lMasterss;
	}
	
	public ArrayList<AssetMaintenanceSchdDetail_DTO> getSelectAssetMaintDetails(ArrayList<Long> aList) 
	{
		ArrayList<AssetMaintenanceSchdDetail> assetMaintenanceSchdDetails =  (ArrayList<AssetMaintenanceSchdDetail>) assetMainSchdDetailsAdminRepo.findAllById(aList);
		ArrayList<AssetMaintenanceSchdDetail_DTO> lMasterss = assetMaintenanceSchdDetails != null ? this.getAssetMaintenanceSchdDetailDtos(assetMaintenanceSchdDetails) : null;
		return lMasterss;
	}

	public ArrayList<AssetMaintenanceSchdDetail_DTO> getSelectSchedulesByMaintenance(ArrayList<Long> ids) 
	{
		ArrayList<AssetMaintenanceSchdDetail> assetMaintenanceSchdDetails =  assetMainSchdDetailsAdminRepo.getSelectSchedulesByMaintenance(ids);
		ArrayList<AssetMaintenanceSchdDetail_DTO> lMasterss = assetMaintenanceSchdDetails != null ? this.getAssetMaintenanceSchdDetailDtos(assetMaintenanceSchdDetails) : null;
		return lMasterss;
	}
	
	public ArrayList<AssetMaintenanceSchdDetail_DTO> getSelectSchedulesByScheduleIds( ArrayList<String> ids) 
	{
		ArrayList<AssetMaintenanceSchdDetail> assetMaintenanceSchdDetails =  assetMainSchdDetailsAdminRepo.getSelectSchedulesByScheduleIds(ids);
		ArrayList<AssetMaintenanceSchdDetail_DTO> lMasterss = assetMaintenanceSchdDetails != null ? this.getAssetMaintenanceSchdDetailDtos(assetMaintenanceSchdDetails) : null;
		return lMasterss;
	}
	
	public ArrayList<AssetMaintenanceSchdDetail_DTO> getSelectSchedulesByResSrvProds( ArrayList<Long> ids) 
	{
		ArrayList<AssetMaintenanceSchdDetail> assetMaintenanceSchdDetails =  assetMainSchdDetailsAdminRepo.getSelectSchedulesByResSrvProds(ids);
		ArrayList<AssetMaintenanceSchdDetail_DTO> lMasterss = assetMaintenanceSchdDetails != null ? this.getAssetMaintenanceSchdDetailDtos(assetMaintenanceSchdDetails) : null;
		return lMasterss;
	}
	
	public ArrayList<AssetMaintenanceSchdDetail_DTO> getAssetsOK() 
	{
		ArrayList<AssetMaintenanceSchdDetail> assetMaintenanceSchdDetails = assetMainSchdDetailsAdminRepo.getAssetsOK();
		ArrayList<AssetMaintenanceSchdDetail_DTO> lMasterss = assetMaintenanceSchdDetails != null ? this.getAssetMaintenanceSchdDetailDtos(assetMaintenanceSchdDetails) : null;
		return lMasterss;
	}

	public ArrayList<AssetMaintenanceSchdDetail_DTO> getAssetsDone() 
	{
		ArrayList<AssetMaintenanceSchdDetail> assetMaintenanceSchdDetails = assetMainSchdDetailsAdminRepo.getAssetsDone();
		ArrayList<AssetMaintenanceSchdDetail_DTO> lMasterss = assetMaintenanceSchdDetails != null ? this.getAssetMaintenanceSchdDetailDtos(assetMaintenanceSchdDetails) : null;
		return lMasterss;	
	}
	
	public ArrayList<AssetMaintenanceSchdDetail_DTO> getAssetsNotOK() 
	{
		ArrayList<AssetMaintenanceSchdDetail> assetMaintenanceSchdDetails = assetMainSchdDetailsAdminRepo.getAssetsNotOK();
		ArrayList<AssetMaintenanceSchdDetail_DTO> lMasterss = assetMaintenanceSchdDetails != null ? this.getAssetMaintenanceSchdDetailDtos(assetMaintenanceSchdDetails) : null;
		return lMasterss;
	}

	public ArrayList<AssetMaintenanceSchdDetail_DTO> getAssetsNotDone() 
	{
		ArrayList<AssetMaintenanceSchdDetail> assetMaintenanceSchdDetails = assetMainSchdDetailsAdminRepo.getAssetsNotDone();
		ArrayList<AssetMaintenanceSchdDetail_DTO> lMasterss = assetMaintenanceSchdDetails != null ? this.getAssetMaintenanceSchdDetailDtos(assetMaintenanceSchdDetails) : null;
		return lMasterss;
	}
	
	public ArrayList<AssetMaintenanceSchdDetail_DTO> getAssetsNotWIP() 
	{
		ArrayList<AssetMaintenanceSchdDetail> assetMaintenanceSchdDetails = assetMainSchdDetailsAdminRepo.getAssetsNotWIP();
		ArrayList<AssetMaintenanceSchdDetail_DTO> lMasterss = assetMaintenanceSchdDetails != null ? this.getAssetMaintenanceSchdDetailDtos(assetMaintenanceSchdDetails) : null;
		return lMasterss;
	}

	public ArrayList<AssetMaintenanceSchdDetail_DTO> getAssetsWIP() 
	{
		ArrayList<AssetMaintenanceSchdDetail> assetMaintenanceSchdDetails = assetMainSchdDetailsAdminRepo.getAssetsWIP();
		ArrayList<AssetMaintenanceSchdDetail_DTO> lMasterss = assetMaintenanceSchdDetails != null ? this.getAssetMaintenanceSchdDetailDtos(assetMaintenanceSchdDetails) : null;
		return lMasterss;
	}
	
	public ArrayList<AssetMaintenanceSchdDetail_DTO> getAssetsBetweenDTTM( String fr,  String to) 
	{
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		LocalDateTime dateOn = LocalDateTime.parse(fr, formatter);
		LocalDateTime dateTo = LocalDateTime.parse(to, formatter);
		Timestamp ts_Fr = Timestamp.valueOf(dateOn);
		Timestamp ts_To = Timestamp.valueOf(dateTo);
		ArrayList<AssetMaintenanceSchdDetail> assetMaintenanceSchdDetails = assetMainSchdDetailsAdminRepo.getAssetsBetweenDTTM(ts_Fr, ts_To);
		ArrayList<AssetMaintenanceSchdDetail_DTO> lMasterss = assetMaintenanceSchdDetails != null ? this.getAssetMaintenanceSchdDetailDtos(assetMaintenanceSchdDetails) : null;
		return lMasterss;
	}

	
	public void updAssetMaintenanceSchdDetail(AssetMaintenanceSchdDetail_DTO assetMaintenanceSchdDetail_DTO) 
	{
		if(assetMaintenanceSchdDetail_DTO!=null)
		{		
		if (assetMainSchdDetailsAdminRepo.existsById(assetMaintenanceSchdDetail_DTO.getScheduleSeqNo()))
		{
			AssetMaintenanceSchdDetail assetMaintenanceSchdDetail = this.setAssetMaintenanceSchdDetail(assetMaintenanceSchdDetail_DTO); 
			assetMaintenanceSchdDetail.setScheduleSeqNo(assetMaintenanceSchdDetail_DTO.getScheduleSeqNo());
			assetMainSchdDetailsAdminRepo.save(assetMaintenanceSchdDetail);
		}
		}
		return;
	}

	public void delAllAssetMaintenanceSchdDetails() 
	{
		assetMainSchdDetailsAdminRepo.deleteAll();
	}

	public void delSelectAssetMaintenanceDetails(ArrayList<Long> aList) 
	{
	assetMainSchdDetailsAdminRepo.deleteAllById(aList);	
	}

	public void delSelectSchedulesByMaintenance( ArrayList<Long> ids) 
	{
	assetMainSchdDetailsAdminRepo.delSelectSchedulesByMaintenance(ids);	
	}
	
	public void delSelectSchedulesByScheduleIds( ArrayList<String> ids) 
	{
	assetMainSchdDetailsAdminRepo.delSelectSchedulesByScheduleIds(ids);	
	}
	
	public void delSelectSchedulesByResSrvProds( ArrayList<Long> ids) 
	{
	assetMainSchdDetailsAdminRepo.delSelectSchedulesByResSrvProds(ids);	
	}
	
	public void delAssetsOK()
	{
	assetMainSchdDetailsAdminRepo.delAssetsOK();
	}
	
    public void delAssetsDone()
    {
    assetMainSchdDetailsAdminRepo.delAssetsDone();;
	}
    
    public void delAssetsNotOK()
    {
    assetMainSchdDetailsAdminRepo.delAssetsNotOK();
	}
    
    public void delAssetsNotDone()
    {
    assetMainSchdDetailsAdminRepo.delAssetsNotDone();
	}	
	
    public void delAssetsWIP()
    {
    assetMainSchdDetailsAdminRepo.delAssetsWIP();
	}
    
    public void delAssetsNotWIP()
    {
    assetMainSchdDetailsAdminRepo.delAssetsNotWIP();
	}
    
    public void delAssetsBetweenDTTM( String fr,  String to) 
	{
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		LocalDateTime dateOn = LocalDateTime.parse(fr, formatter);
		LocalDateTime dateTo = LocalDateTime.parse(to, formatter);
		Timestamp ts_Fr = Timestamp.valueOf(dateOn);
		Timestamp ts_To = Timestamp.valueOf(dateTo);
		assetMainSchdDetailsAdminRepo.delAssetsBetweenDTTM(ts_Fr, ts_To);		
		return;
	}
    
    
	private ArrayList<AssetMaintenanceSchdDetail_DTO> getAssetMaintenanceSchdDetailDtos(ArrayList<AssetMaintenanceSchdDetail> lMasters) {
		AssetMaintenanceSchdDetail_DTO lDTO = null;
		ArrayList<AssetMaintenanceSchdDetail_DTO> lMasterDTOs = new ArrayList<AssetMaintenanceSchdDetail_DTO>();
		
		for (int i = 0; i < lMasters.size(); i++)
		{
			lDTO = this.getAssetMaintenanceSchdDetail_DTO(lMasters.get(i));					
			lMasterDTOs.add(lDTO);
		}
		return lMasterDTOs;
	}

	private AssetMaintenanceSchdDetail_DTO getAssetMaintenanceSchdDetail_DTO(AssetMaintenanceSchdDetail lMaster) 
	{
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		AssetMaintenanceSchdDetail_DTO lDTO = new AssetMaintenanceSchdDetail_DTO();		
		lDTO.setFrDttm(formatter.format(lMaster.getFrDttm().toLocalDateTime()));
		lDTO.setToDttm(formatter.format(lMaster.getToDttm().toLocalDateTime()));
		lDTO.setAssetMaintenanceSeqNo(lMaster.getAssetMaintenanceSeqNo());
		lDTO.setDoneflag(lMaster.getDoneflag());
		lDTO.setOkflag(lMaster.getOkflag());
		lDTO.setRessrvprdSeqNo(lMaster.getRessrvprdSeqNo());
		lDTO.setRuleSeqNo(lMaster.getRuleSeqNo());
		lDTO.setScheduleId(lMaster.getScheduleId());
		lDTO.setScheduleSeqNo(lMaster.getScheduleSeqNo());
		lDTO.setWipflag(lMaster.getWipflag());
		return lDTO;
	}

	private AssetMaintenanceSchdDetail setAssetMaintenanceSchdDetail(AssetMaintenanceSchdDetail_DTO lDTO) {
		AssetMaintenanceSchdDetail lMaster = new AssetMaintenanceSchdDetail();		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		LocalDateTime dateFr = LocalDateTime.parse(lDTO.getFrDttm(), formatter);
		LocalDateTime dateTo = LocalDateTime.parse(lDTO.getToDttm(), formatter);
		Timestamp ts_Fr = Timestamp.valueOf(dateFr);
		Timestamp ts_To = Timestamp.valueOf(dateTo);
		lMaster.setFrDttm(ts_Fr);
		lMaster.setToDttm(ts_To);
		lMaster.setAssetMaintenanceSeqNo(lDTO.getAssetMaintenanceSeqNo());
		lMaster.setDoneflag(lDTO.getDoneflag());
		lMaster.setOkflag(lDTO.getOkflag());
		lMaster.setRessrvprdSeqNo(lDTO.getRessrvprdSeqNo());
		lMaster.setRuleSeqNo(lDTO.getRuleSeqNo());
		lMaster.setScheduleId(lDTO.getScheduleId());
		lMaster.setWipflag(lDTO.getWipflag());
		return lMaster;
	}
	
}