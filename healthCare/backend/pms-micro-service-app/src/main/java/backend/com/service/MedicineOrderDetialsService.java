package backend.com.service;

import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import backend.com.entity.Account;
import backend.com.entity.Medicine;
import backend.com.entity.Medicineorderdetails;
import backend.com.entity.Orderdetails;
import backend.com.repository.AccountRepository;
import backend.com.repository.MedicineOrderDetailsRepository;
import backend.com.repository.MedicineRepository;
import backend.com.repository.OrderDetailsRepository;

@Service
public class MedicineOrderDetialsService {

	@Autowired
	MedicineOrderDetailsRepository medicineOrderDetailsRepository;

	@Autowired
	OrderDetailsRepository orderDetailsRepository;

	@Autowired
	MedicineRepository medicineRepository;

	AccountRepository accountRepository;

	public String placeOrderDetails(List<Medicine> listofmedicine, String email, float total) {
		try {
			Account acc = accountRepository.getAccountDetails(email);
			System.out.println(acc.getAccnumber() + "" + acc.getAmount() + " Total " + total);
			if (total > acc.getAmount()) {
				return "Insufficient amount you can't place the order";
			} else {
				Orderdetails od = new Orderdetails();
				od.setEmailid(email);
				od.setTotalamount(total);

				Orderdetails odref = orderDetailsRepository.save(od);
				System.out.println(odref);
				System.out.println(odref.getOrderid());
				Iterator<Medicine> li = listofmedicine.iterator();
				while (li.hasNext()) {
					Medicineorderdetails mod = new Medicineorderdetails();
					Medicine mm = li.next();
					mod.setMid(mm.getMid());
					mod.setMedicinename(mm.getMedicinename());
					mod.setPrice(mm.getPrice());
					mod.setQuantity(mm.getQuantity());
					mod.setOrderdetails(odref);
					mod.setEmailid(odref.getEmailid());
					mod.setOrderdate(LocalDateTime.now());
					medicineOrderDetailsRepository.save(mod);
					medicineRepository.updateOrderQuantity(mm.getMid(), mm.getQuantity());
					accountRepository.amountDebits(acc.getAccnumber(), total);
				}
			}
			return "Order placed successfully";
		} catch (Exception e) {
			System.out.println(e);
			return "Order didn't place";
		}
	}

	public List<Medicineorderdetails> getAllMedicineDetails() {
		return medicineOrderDetailsRepository.findAll();
	}
}
