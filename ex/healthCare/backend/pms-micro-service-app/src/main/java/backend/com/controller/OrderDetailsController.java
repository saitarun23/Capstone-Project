package backend.com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import backend.com.entity.Medicineorderdetails;
import backend.com.service.MedicineOrderDetialsService;
import backend.com.service.OrderDetailsService;

@RestController
@RequestMapping(value="Orders")
@CrossOrigin
public class OrderDetailsController {

	@Autowired
	OrderDetailsService orderDetailsService;

	@Autowired
	MedicineOrderDetialsService medicineOrderDetailsService;

	@GetMapping(value = "orderDetails/{email}")
	public List<Medicineorderdetails> getAllOrderDetails(@PathVariable("email") String email) {
		return orderDetailsService.getAllOrderDetails(email);
	}

	@GetMapping(value = "allOrdersDetails")
	public List<Medicineorderdetails> getAllOrderDetails() {
		return medicineOrderDetailsService.getAllMedicineDetails();
	}
}
