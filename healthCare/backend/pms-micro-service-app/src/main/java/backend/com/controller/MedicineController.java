package backend.com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import backend.com.entity.Medicine;
import backend.com.service.MedicineService;

@RestController
@RequestMapping(value="medicine")
@CrossOrigin
public class MedicineController {

	@Autowired
	MedicineService medicineService;
	
	@GetMapping(value = "search/{uses}")
	public List<Medicine> searchMedicineByDisease(@PathVariable("uses") String uses){
		return medicineService.searchMedicine(uses);
	}
	
	@GetMapping(value = "getAllMedicine")
	public List<Medicine> getAllMedicineDetails(){
		return medicineService.getAllMedicineDetails();
	}
}
