package com.jcodepoint.customerservice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

	private static Map<Integer, Customer> customers = new HashMap<>(); 	
	
    @PostMapping("/customer")  
    public String addCustomer(@RequestBody Customer customer) { 
        if (customer.getId()<=0){
            return "El id no es valido";
        }
        customers.put(customer.getId(), customer); 
        return "Cliente agregado correctamente."; 
    } 	
	
    @GetMapping("/customer")  
    public List<Customer> getCustomers() { 
        if(customers.values().isEmpty()){
           System.out.print("No hay registros");
        }
    
         return new ArrayList<Customer>(customers.values());
        
    }    
	
}
