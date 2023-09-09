package assetmaintenance_schd_details.service;

import java.util.ArrayList;
import assetmaintenance_schd_details.model.dto.AssetMaintenanceSchdDetail_DTO;

public interface I_AssetMaintenanceSchdDetailsAdmin_Service
{
    public AssetMaintenanceSchdDetail_DTO newAssetMaintenanceSchdDetail(AssetMaintenanceSchdDetail_DTO asssetMaintMasterDTO);
    public ArrayList<AssetMaintenanceSchdDetail_DTO> getAllAssetMaintenanceSchdDetails();
    public ArrayList<AssetMaintenanceSchdDetail_DTO> getSelectAssetMaintDetails(ArrayList<Long> aList);
    public ArrayList<AssetMaintenanceSchdDetail_DTO> getSelectSchedulesByMaintenance( ArrayList<Long> ids);
	public ArrayList<AssetMaintenanceSchdDetail_DTO> getSelectSchedulesByScheduleIds( ArrayList<String> ids);
	public ArrayList<AssetMaintenanceSchdDetail_DTO> getSelectSchedulesByResSrvProds( ArrayList<Long> ids);
	public ArrayList<AssetMaintenanceSchdDetail_DTO> getAssetsOK();
	public ArrayList<AssetMaintenanceSchdDetail_DTO> getAssetsDone();
	public ArrayList<AssetMaintenanceSchdDetail_DTO> getAssetsNotOK();
	public ArrayList<AssetMaintenanceSchdDetail_DTO> getAssetsNotDone();
	public ArrayList<AssetMaintenanceSchdDetail_DTO> getAssetsWIP();
	public ArrayList<AssetMaintenanceSchdDetail_DTO> getAssetsNotWIP();
	public ArrayList<AssetMaintenanceSchdDetail_DTO> getAssetsBetweenDTTM(String  fr,  String to);    
    public void updAssetMaintenanceSchdDetail(AssetMaintenanceSchdDetail_DTO assetMaintenanceSchdDetail_DTO);
    public void delAllAssetMaintenanceSchdDetails();
    public void delSelectAssetMaintenanceDetails(ArrayList<Long> aList);    
    public void delSelectSchedulesByMaintenance( ArrayList<Long> ids);
    public void delSelectSchedulesByScheduleIds( ArrayList<String> ids);
    public void delSelectSchedulesByResSrvProds( ArrayList<Long> ids);
    public void delAssetsOK();
	public void delAssetsDone();
	public void delAssetsNotOK();
	public void delAssetsNotDone();
	public void delAssetsWIP();
	public void delAssetsNotWIP();
	public void delAssetsBetweenDTTM( String fr,  String to);
}