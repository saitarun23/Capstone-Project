package backend.com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import backend.com.entity.Login;
import backend.com.entity.Medicine;
import backend.com.service.AdminService;
import backend.com.service.MedicineService;

@RestController
@RequestMapping(value = "admin")
@CrossOrigin
public class AdminController {

	@Autowired
	AdminService adminService;

	@Autowired
	MedicineService medicineService;

	@PostMapping(value = "login", consumes = MediaType.APPLICATION_JSON_VALUE)
	public String checkAdminLogin(@RequestBody Login login) {
		System.out.println(login.getEmail() + " " + login.getPassword());
		return adminService.checkAdmin(login);
	}

	@PostMapping(value = "addMedicine", consumes = MediaType.APPLICATION_JSON_VALUE)
	public String addMedicineDetails(@RequestBody Medicine medicine) {
		System.out.println(medicine);
		return medicineService.storeMedicineDetails(medicine);
	}

	@PutMapping(value = "updateMedicine")
	public String updateMedicianDetails(@RequestBody Medicine medicine) {
		return medicineService.updateMedicineDetails(medicine);
	}

	@GetMapping(value = "getAllMedicine")
	public List<Medicine> getAllMedicineDetails() {
		return medicineService.getAllMedicineDetails();
	}

	@DeleteMapping(value = "deleteMedicineById/{mid}")
	public String deleteMedicineById(@PathVariable("mid") int mid) {
		return medicineService.deleteMedicine(mid);
	}

	@GetMapping(value = "getMedicineById/{mid}")
	public Medicine getMedicineById(@PathVariable("mid") int mid) {
		System.out.println("Mid is " + mid);
		return medicineService.getMedicineById(mid);
	}
}
