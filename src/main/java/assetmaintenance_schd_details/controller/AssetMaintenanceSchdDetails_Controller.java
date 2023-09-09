package assetmaintenance_schd_details.controller;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import assetmaintenance_schd_details.model.dto.AssetMaintenanceSchdDetail_DTO;
import assetmaintenance_schd_details.service.I_AssetMaintenanceSchdDetailsAdmin_Service;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/assetMaintenanceSchdDetailsMgmt")
public class AssetMaintenanceSchdDetails_Controller {

	// private static final Logger AssMainSchdDetailsgger =
	// LoggerFactory.getLogger(AssetMaint_AssetMaint_Lontroller.class);

	@Autowired
	private I_AssetMaintenanceSchdDetailsAdmin_Service assetMaintSchdDetailsAdminServ;

	@PostMapping("/new")
	public ResponseEntity<AssetMaintenanceSchdDetail_DTO> newAssetMaint(
			@RequestBody AssetMaintenanceSchdDetail_DTO assetMaintDetailsDTO) {
		AssetMaintenanceSchdDetail_DTO assetMaintDetailsDTO2 = assetMaintSchdDetailsAdminServ
				.newAssetMaintenanceSchdDetail(assetMaintDetailsDTO);
		HttpHeaders httpHeaders = new HttpHeaders();
		return new ResponseEntity<>(assetMaintDetailsDTO2, httpHeaders, HttpStatus.CREATED);
	}

	@GetMapping(value = "/getAllAssMainSchdDetails", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<AssetMaintenanceSchdDetail_DTO>> getAllAssetMaintenance_Details() {
		ArrayList<AssetMaintenanceSchdDetail_DTO> assetMaintDetailsDTOs = assetMaintSchdDetailsAdminServ
				.getAllAssetMaintenanceSchdDetails();
		// AssMainSchdDetailsgger.info("size :"+assetMaintDetailsDTOs.size());
		return new ResponseEntity<>(assetMaintDetailsDTOs, HttpStatus.OK);
	}

	@GetMapping(value = "/getSelectAssMainSchdDetails", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<AssetMaintenanceSchdDetail_DTO>> getSelectAssetMaintenance_Details(
			@RequestBody ArrayList<Long> aList) {
		ArrayList<AssetMaintenanceSchdDetail_DTO> assetMaintDetailsDTOs2 = assetMaintSchdDetailsAdminServ
				.getSelectAssetMaintDetails(aList);
		return new ResponseEntity<>(assetMaintDetailsDTOs2, HttpStatus.OK);
	}

	@GetMapping(value = "/getSelectSchedulesByMaintenance", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<AssetMaintenanceSchdDetail_DTO>> getSelectSchedulesByMaintenance(
			@RequestBody ArrayList<Long> aList) {
		ArrayList<AssetMaintenanceSchdDetail_DTO> assetMaintDetailsDTOs2 = assetMaintSchdDetailsAdminServ
				.getSelectSchedulesByMaintenance(aList);
		return new ResponseEntity<>(assetMaintDetailsDTOs2, HttpStatus.OK);
	}

	@GetMapping(value = "/getSelectSchedulesByScheduleIds", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<AssetMaintenanceSchdDetail_DTO>> getSelectSchedulesByScheduleIds(
			@RequestBody ArrayList<String> aList) {
		ArrayList<AssetMaintenanceSchdDetail_DTO> assetMaintDetailsDTOs2 = assetMaintSchdDetailsAdminServ
				.getSelectSchedulesByScheduleIds(aList);
		return new ResponseEntity<>(assetMaintDetailsDTOs2, HttpStatus.OK);
	}

	@GetMapping(value = "/getSelectSchedulesByResSrvProds", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<AssetMaintenanceSchdDetail_DTO>> getSelectSchedulesByResSrvProds(
			@RequestBody ArrayList<Long> aList) {
		ArrayList<AssetMaintenanceSchdDetail_DTO> assetMaintDetailsDTOs2 = assetMaintSchdDetailsAdminServ
				.getSelectSchedulesByResSrvProds(aList);
		return new ResponseEntity<>(assetMaintDetailsDTOs2, HttpStatus.OK);
	}

	@GetMapping(value = "/getAssetsOK", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<AssetMaintenanceSchdDetail_DTO>> getAssetsOK() {
		ArrayList<AssetMaintenanceSchdDetail_DTO> assetMaintDetailsDTOs2 = assetMaintSchdDetailsAdminServ.getAssetsOK();
		return new ResponseEntity<>(assetMaintDetailsDTOs2, HttpStatus.OK);
	}

	@GetMapping(value = "/getAssetsDone", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<AssetMaintenanceSchdDetail_DTO>> getAssetsDone() {
		ArrayList<AssetMaintenanceSchdDetail_DTO> assetMaintDetailsDTOs2 = assetMaintSchdDetailsAdminServ
				.getAssetsDone();
		return new ResponseEntity<>(assetMaintDetailsDTOs2, HttpStatus.OK);
	}

	@GetMapping(value = "/getAssetsNotOK", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<AssetMaintenanceSchdDetail_DTO>> getAssetsNotOK() {
		ArrayList<AssetMaintenanceSchdDetail_DTO> assetMaintDetailsDTOs2 = assetMaintSchdDetailsAdminServ
				.getAssetsNotOK();
		return new ResponseEntity<>(assetMaintDetailsDTOs2, HttpStatus.OK);
	}

	@GetMapping(value = "/getAssetsNotDone", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<AssetMaintenanceSchdDetail_DTO>> getAssetsNotDone() {
		ArrayList<AssetMaintenanceSchdDetail_DTO> assetMaintDetailsDTOs2 = assetMaintSchdDetailsAdminServ
				.getAssetsNotDone();
		return new ResponseEntity<>(assetMaintDetailsDTOs2, HttpStatus.OK);
	}

	@GetMapping(value = "/getAssetsWIP", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<AssetMaintenanceSchdDetail_DTO>> getAssetsWIP() {
		ArrayList<AssetMaintenanceSchdDetail_DTO> assetMaintDetailsDTOs2 = assetMaintSchdDetailsAdminServ
				.getAssetsWIP();
		return new ResponseEntity<>(assetMaintDetailsDTOs2, HttpStatus.OK);
	}

	@GetMapping(value = "/getAssetsNotWIP", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<AssetMaintenanceSchdDetail_DTO>> getAssetsNotWIP() {
		ArrayList<AssetMaintenanceSchdDetail_DTO> assetMaintDetailsDTOs2 = assetMaintSchdDetailsAdminServ
				.getAssetsNotWIP();
		return new ResponseEntity<>(assetMaintDetailsDTOs2, HttpStatus.OK);
	}

	@GetMapping(value = "/getAssetsBetweenDTTM/{fr}/{to}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<AssetMaintenanceSchdDetail_DTO>> getAssetsBetweenDTTM(@PathVariable String fr,
			@PathVariable String to) {
		ArrayList<AssetMaintenanceSchdDetail_DTO> assetMaintDetailsDTOs2 = assetMaintSchdDetailsAdminServ
				.getAssetsBetweenDTTM(fr, to);
		return new ResponseEntity<>(assetMaintDetailsDTOs2, HttpStatus.OK);
	}

	@PutMapping("/updAssetMaint")
	public void updateAssetMaint(@RequestBody AssetMaintenanceSchdDetail_DTO assetMaintSchdDetailDTO) {
		assetMaintSchdDetailsAdminServ.updAssetMaintenanceSchdDetail(assetMaintSchdDetailDTO);
	}

	@DeleteMapping("/delSelectAssMainSchdDetails")
	public void deleteSelectAssMainSchdDetails(@RequestBody ArrayList<Long> aList) {
		assetMaintSchdDetailsAdminServ.delSelectAssetMaintenanceDetails(aList);
	}

	@DeleteMapping("/delSelectSchedulesByMaintenance")
	public void delSelectSchedulesByMaintenance(@RequestBody ArrayList<Long> aList) {
		assetMaintSchdDetailsAdminServ.delSelectSchedulesByMaintenance(aList);
	}

	@DeleteMapping("/delSelectSchedulesByScheduleIds")
	public void delSelectSchedulesByScheduleIds(@RequestBody ArrayList<String> aList) {
		assetMaintSchdDetailsAdminServ.delSelectSchedulesByScheduleIds(aList);
	}

	@DeleteMapping("/delSelectSchedulesByResSrvProds")
	public void delSelectSchedulesByResSrvProds(@RequestBody ArrayList<Long> aList) {
		assetMaintSchdDetailsAdminServ.delSelectSchedulesByResSrvProds(aList);
	}

	@DeleteMapping("/delAssetsOK")
	public void delAssetsOK() {
		assetMaintSchdDetailsAdminServ.delAssetsOK();
	}

	@DeleteMapping("/delAssetsNotOK")
	public void delAssetsNotOK() {
		assetMaintSchdDetailsAdminServ.delAssetsNotOK();
	}

	@DeleteMapping("/delAssetsDone")
	public void delAssetsDone() {
		assetMaintSchdDetailsAdminServ.delAssetsDone();
		;
	}

	@DeleteMapping("/delAssetsNotDone")
	public void delAssetsNotDone() {
		assetMaintSchdDetailsAdminServ.delAssetsNotDone();
	}

	@DeleteMapping("/delAssetsWIP")
	public void delAssetsWIP() {
		assetMaintSchdDetailsAdminServ.delAssetsWIP();
	}

	@DeleteMapping("/delAssetsNotWIP")
	public void delAssetsNotWIP() {
		assetMaintSchdDetailsAdminServ.delAssetsNotWIP();
	}

	@DeleteMapping("/delAssetsNotWIP/{fr}/{to}")
	public void delAssetsBetweenDTTM(String fr, String to) {
		assetMaintSchdDetailsAdminServ.delAssetsBetweenDTTM(fr, to);
	}

	@DeleteMapping("/delAllAssMainSchdDetails")
	public void deleteAllAssetMaint() {
		assetMaintSchdDetailsAdminServ.delAllAssetMaintenanceSchdDetails();
	}
}