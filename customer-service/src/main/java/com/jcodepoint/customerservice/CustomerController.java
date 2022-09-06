package com.jcodepoint.customerservice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class CustomerController {

    Logger logger = LoggerFactory.getLogger(CustomerController.class);

	private static Map<Integer, Customer> customers = new HashMap<>(); 	
	
    @PostMapping("/customer")  
    public String addCustomer(@RequestBody Customer customer) { 
        if (customer.getId()<=0){
            logger.error("El id no es valido");
            return "El id no es valido";
        }
        customers.put(customer.getId(), customer); 
        return "Cliente agregado correctamente."; 
    } 	
	
    @GetMapping("/customer")  
    public List<Customer> getCustomers() { 
        if(customers.values().isEmpty()){
            logger.info("No hay registros con ese id");
        }
    
         return new ArrayList<Customer>(customers.values());
        
    }    
	
}
