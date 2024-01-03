package main.java.com.Assesment.backend.appConfig.Service;

import main.java.com.Assesment.backend.appConfig.Model.CustomerDetails;
import main.java.com.Assesment.backend.appConfig.Repository.CustomerRepository;
@Service
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public CustomerDetails saveCustomer(CustomerDetails customer) {
        validateCustomerDetails(customer);


        if (customer.getEmail().endsWith("@hikeon.tech")) {
            customer.setCustomerGroup(CustomerDetails.CustomerGroup.HIKEON);
        } else if (customer.getOccupation() == CustomerDetails.Occupation.DEVELOPER) {
            customer.setCustomerGroup(CustomerDetails.CustomerGroup.DEVELOPER);
        } else if (customer.getOccupation() == CustomerDetails.Occupation.CHEF) {
            customer.setCustomerGroup(CustomerDetails.CustomerGroup.CHEF);
        } else {
            customer.setCustomerGroup(CustomerDetails.CustomerGroup.NA);
        }

        return customerRepository.save(customer);
    }
    private void validateCustomerDetails(CustomerDetails customer) {
        if (customerRepository.existsByEmail(customer.getEmail())) {
            throw new IllegalArgumentException("Duplicate email address not allowed");
        }

        if (isBelow18(customer.getDob())) {
            throw new IllegalArgumentException("Customer is below 18 years old. Data not saved.");
        }      
    }

    private boolean isBelow18(Date dob) {
        return false;
    }
}
