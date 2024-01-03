package main.java.com.Assesment.backend.appConfig.Controller;

import main.java.com.Assesment.backend.appConfig.Model.CustomerDetails;
import main.java.com.Assesment.backend.appConfig.Service.CustomerService;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {
    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    public ResponseEntity<CustomerDetails> createCustomer(@RequestBody CustomerDetails customer) {
        CustomerDetails savedCustomer = customerService.saveCustomer(customer);
        return new ResponseEntity<>(savedCustomer, HttpStatus.CREATED);
    }

}
