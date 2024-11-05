package backend.com.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import backend.com.entity.Medicine;
import backend.com.service.CartService;
import backend.com.service.MedicineOrderDetialsService;

@RestController
@RequestMapping(value = "cart")
@CrossOrigin
public class CartController {

	@Autowired
	CartService cartService;

	@Autowired
	MedicineOrderDetialsService medicineOrderDetailsService;

	@PostMapping(value = "getMedicine", consumes = MediaType.APPLICATION_JSON_VALUE)
	public List<Medicine> getCartMedicine(@RequestBody Map<?, ?> cart) {
		return cartService.cartDetails(cart);
	}

	@PostMapping(value="placeOrder/{email}/{total}")
	public String placeOrder(@RequestBody List<Medicine> listOfMedicine, @PathVariable("email") String email, @PathVariable("total") float total) {
		System.out.println(listOfMedicine);
		return medicineOrderDetailsService.placeOrderDetails(listOfMedicine, email, total);
	}
}
