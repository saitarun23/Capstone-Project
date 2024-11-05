package backend.com.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import backend.com.entity.Medicineorderdetails;
import backend.com.entity.Orderdetails;
import backend.com.repository.MedicineOrderDetailsRepository;
import backend.com.repository.OrderDetailsRepository;

@Service
public class OrderDetailsService {

	@Autowired
	OrderDetailsRepository orderDetailsRepository;

	@Autowired
	MedicineOrderDetailsRepository medicineOrderDetailsRepository;

	public List<Medicineorderdetails> getAllOrderDetails(String email) {
		List<Medicineorderdetails> listOfOrderDetails = new ArrayList<>();
		List<Orderdetails> orderDetails = orderDetailsRepository.getOrderIdUsingEmail(email);
		for (Orderdetails od : orderDetails) {
			List<Medicineorderdetails> medicineOrdersDetaails = medicineOrderDetailsRepository
					.getAllMedicineOrderDetails(od.getOrderid());
			for (Medicineorderdetails morder : medicineOrdersDetaails) {
				listOfOrderDetails.add(morder);
			}
		}
		return listOfOrderDetails;
	}
}
