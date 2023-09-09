package assetmaintenance_schd_details.model.dto;

import java.io.Serializable;

public class AssetMaintenanceSchdDetail_DTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8960844619131257024L;
	private Long scheduleSeqNo;
	private Long assetMaintenanceSeqNo;
	private Character doneflag;
	private String frDttm;
	private Character okflag;
	private Long ressrvprdSeqNo;
	private Long ruleSeqNo;
	private String scheduleId;
	private String toDttm;
	private Character wipflag;

	public Long getScheduleSeqNo() {
		return scheduleSeqNo;
	}

	public void setScheduleSeqNo(Long scheduleSeqNo) {
		this.scheduleSeqNo = scheduleSeqNo;
	}

	public Long getAssetMaintenanceSeqNo() {
		return assetMaintenanceSeqNo;
	}

	public void setAssetMaintenanceSeqNo(Long assetMaintenanceSeqNo) {
		this.assetMaintenanceSeqNo = assetMaintenanceSeqNo;
	}

	public Character getDoneflag() {
		return doneflag;
	}

	public void setDoneflag(Character doneflag) {
		this.doneflag = doneflag;
	}

	public String getFrDttm() {
		return frDttm;
	}

	public void setFrDttm(String frDttm) {
		this.frDttm = frDttm;
	}

	public Character getOkflag() {
		return okflag;
	}

	public void setOkflag(Character okflag) {
		this.okflag = okflag;
	}

	public Long getRessrvprdSeqNo() {
		return ressrvprdSeqNo;
	}

	public void setRessrvprdSeqNo(Long ressrvprdSeqNo) {
		this.ressrvprdSeqNo = ressrvprdSeqNo;
	}

	public Long getRuleSeqNo() {
		return ruleSeqNo;
	}

	public void setRuleSeqNo(Long ruleSeqNo) {
		this.ruleSeqNo = ruleSeqNo;
	}

	public String getScheduleId() {
		return scheduleId;
	}

	public void setScheduleId(String scheduleId) {
		this.scheduleId = scheduleId;
	}

	public String getToDttm() {
		return toDttm;
	}

	public void setToDttm(String toDttm) {
		this.toDttm = toDttm;
	}

	public Character getWipflag() {
		return wipflag;
	}

	public void setWipflag(Character wipflag) {
		this.wipflag = wipflag;
	}

	public AssetMaintenanceSchdDetail_DTO(Long scheduleSeqNo, Long assetMaintenanceSeqNo, Character doneflag,
			String frDttm, Character okflag, Long ressrvprdSeqNo, Long ruleSeqNo, String scheduleId, String toDttm,
			Character wipflag) {
		super();
		this.scheduleSeqNo = scheduleSeqNo;
		this.assetMaintenanceSeqNo = assetMaintenanceSeqNo;
		this.doneflag = doneflag;
		this.frDttm = frDttm;
		this.okflag = okflag;
		this.ressrvprdSeqNo = ressrvprdSeqNo;
		this.ruleSeqNo = ruleSeqNo;
		this.scheduleId = scheduleId;
		this.toDttm = toDttm;
		this.wipflag = wipflag;
	}

	public AssetMaintenanceSchdDetail_DTO() {
		super();
	}

}