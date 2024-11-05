package backend.com.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import backend.com.entity.Medicine;
import backend.com.repository.MedicineRepository;

@Service
public class CartService {

	@Autowired
	MedicineRepository medicineRepository;

	public List<Medicine> cartDetails(Map<?, ?> cart) {
		List<Medicine> cartMedicine = new ArrayList<>();
		Set<?> ss = cart.entrySet();
		Iterator<?> li = ss.iterator();
		while (li.hasNext()) {
			Map.Entry<?, ?> me = (Map.Entry<?, ?>) li.next();
			int mid = Integer.parseInt(me.getKey().toString());
			Optional<Medicine> result = medicineRepository.findById(mid);
			if (result.isPresent()) {
				Medicine medicine = result.get();
				medicine.setQuantity(Integer.parseInt(me.getValue().toString()));
				cartMedicine.add(medicine);
			}
		}
		return cartMedicine;
	}
}
