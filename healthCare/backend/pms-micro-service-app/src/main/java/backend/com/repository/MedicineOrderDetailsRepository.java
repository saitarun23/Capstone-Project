package backend.com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import backend.com.entity.Medicineorderdetails;

@Repository
public interface MedicineOrderDetailsRepository extends JpaRepository<Medicineorderdetails, Integer>{

	@Query("select m from Medicineorderdetails m where m.orderdetails = :orderId")
	public List<Medicineorderdetails> getAllMedicineOrderDetails(@Param("orderId") int orderId);
}
