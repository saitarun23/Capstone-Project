package backend.com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import backend.com.entity.Medicine;
import backend.com.repository.MedicineRepository;

@Service
public class MedicineService {

	@Autowired
	MedicineRepository medicineRepository;

	public String storeMedicineDetails(Medicine medicine) {
		Medicine result = medicineRepository.save(medicine);
		if (result == null) {
			return "Medicine record didn't store";
		} else {
			return "Medicine record stored successfully";
		}
	}

	public String updateMedicineDetails(Medicine medicine) {
		Optional<Medicine> result = medicineRepository.findById(medicine.getMid());
		if (result.isPresent()) {
			Medicine m = result.get();
			m.setMedicinename(medicine.getMedicinename());
			m.setCompanyname(medicine.getCompanyname());
			m.setPrice(medicine.getPrice());
			m.setQuantity(medicine.getQuantity());
			m.setExpiredate(medicine.getExpiredate());
			medicineRepository.saveAndFlush(m);
			return "Medicine Details Updated Successfully";
		} else {
			return "Medicine not present";
		}
	}
	

	public List<Medicine> getAllMedicineDetails() {
		return medicineRepository.findAll();
	}

	public String deleteMedicine(int mid) {
		Optional<Medicine> result = medicineRepository.findById(mid);
		if (result.isPresent()) {
			medicineRepository.deleteById(mid);
			return "Medicine deleted successfully";
		} else {
			return "Medicine not present";
		}
	}

	public List<Medicine> searchMedicine(String uses) {
		System.out.println(uses);
		return medicineRepository.searchMedicine(uses);
	}

	public Medicine getMedicineById(int mid) {
		Optional<Medicine> result = medicineRepository.findById(mid);
		if (result.isPresent()) {
			return result.get();
		} else {
			return null;
		}
	}
}
