package backend.com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import backend.com.repository.MedicineOrderDetailsRepository;
import backend.com.repository.OrderDetailsRepository;


@Service
public class OrderDetailsService {

	@Autowired
	OrderDetailsRepository orderDetailsRepository;
	
	@Autowired
	MedicineOrderDetailsRepository medicineOrderDetailsRepository;
	
	
}
