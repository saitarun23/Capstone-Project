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
		Optional<Medicine> result = medicineRepository.findById(medicine.getMid());
		if (result.isPresent()) {
			return "Medicine Id must be unique";
		} else {
			return "Medicine recorde stored successfully";
		}
	}

	public String updateMedicineDetails(Medicine medicine) {
		int result=medicineRepository.updateMedicianDetails(medicine.getMedicinename(),medicine.getCompanyname(),
				medicine.getPrice(), medicine.getQuantity(),medicine.getExpiredate(),medicine.getMid());
		if(result>0) {
			return "updated";
		}else {
			return "didn't update";
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
