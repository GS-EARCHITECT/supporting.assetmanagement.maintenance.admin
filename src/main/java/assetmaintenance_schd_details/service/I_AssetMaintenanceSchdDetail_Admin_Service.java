package assetmaintenance_schd_details.service;


import java.util.ArrayList;
import assetmaintenance_master.model.master.AssetMaintenanceMaster;
import assetmaintenance_schd_details.model.dto.AssetMaintenanceSchdDetail_DTO;

public interface I_AssetMaintenanceSchdDetailsAdmin_Service
{
    public AssetMaintenanceSchdDetail_DTO newAssetMaintenanceDetails(AssetMaintenanceSchdDetail_DTO asssetMaintMasterDTO);
    public ArrayList<AssetMaintenanceSchdDetail_DTO> getAllAssetMaintenanceDetails();
    public ArrayList<AssetMaintenanceSchdDetail_DTO> getSelectAssetMaintDetails(ArrayList<AssetMaintenanceSchdDetail_DTO> assetMaintenanceSchdDetail_DTOs);
    public ArrayList<AssetMaintenanceSchdDetail_DTO> getSelectSchedulesByMaintenance( ArrayList<AssetMaintenanceSchdDetail_DTO> ids);
	public ArrayList<AssetMaintenanceSchdDetail_DTO> getSelectSchedulesByScheduleIds( ArrayList<String> ids);
	public ArrayList<AssetMaintenanceSchdDetail_DTO> getSelectSchedulesByResSrvProds( ArrayList<AssetMaintenanceSchdDetail_DTO> ids);
	public ArrayList<AssetMaintenanceSchdDetail_DTO> getAssetsOK();
	public ArrayList<AssetMaintenanceSchdDetail_DTO> getAssetsDone();
	public ArrayList<AssetMaintenanceSchdDetail_DTO> getAssetsNotOK();
	public ArrayList<AssetMaintenanceSchdDetail_DTO> getAssetsNotDone();
	public ArrayList<AssetMaintenanceSchdDetail_DTO> getAssetsWIP();
	public ArrayList<AssetMaintenanceSchdDetail_DTO> getAssetsNotWIP();
	public ArrayList<AssetMaintenanceMaster> getAssetsBetweenDTTM(String  fr,  String to);    
    public void updAssetMaintenanceDetails(AssetMaintenanceSchdDetail_DTO assetMaintenanceSchdDetail_DTO);
    public void delAllAssetMaintenanceDetails();
    public void delSelectAssetMaintenanceDetails(ArrayList<AssetMaintenanceSchdDetail_DTO> assetMaintenanceSchdDetail_DTOs);    
    public void delSelectSchedulesByMaintenance( ArrayList<AssetMaintenanceSchdDetail_DTO> ids);
    public void delSelectSchedulesByScheduleIds( ArrayList<String> ids);
    public void delSelectSchedulesByResSrvProds( ArrayList<AssetMaintenanceSchdDetail_DTO> ids);
    public void delAssetsOK();
	public void delAssetsDone();
	public void delAssetsNotOK();
	public void delAssetsNotDone();
	public void delAssetsWIP();
	public void delAssetsNotWIP();
	public void delAssetsBetweenDTTM( String fr,  String to);
}