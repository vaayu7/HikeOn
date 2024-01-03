package test;

import main.java.com.Assesment.backend.appConfig.Model.CustomerDetails;
import main.java.com.Assesment.backend.appConfig.Repository.CustomerRepository;
import main.java.com.Assesment.backend.appConfig.Service.CustomerServiceImpl;
@ExtendWith(MockitoExtension.class)
public class CustomerServiceImplTest {
    @Mock
    private CustomerRepository customerRepository;

    @InjectMocks
    private CustomerServiceImpl customerService;

    @Test
    void saveCustomer_ValidCustomer_Success() {
      
        CustomerDetails customer = createValidCustomer();
        when(customerRepository.existsByEmail(anyString())).thenReturn(false);
        when(customerRepository.save(any())).thenReturn(customer);

   
        CustomerDetails savedCustomer = customerService.saveCustomer(customer);

        
        assertNotNull(savedCustomer);
        assertEquals(customer.getName(), savedCustomer.getName());
        assertEquals(customer.getEmail(), savedCustomer.getEmail());
        
        verify(customerRepository, times(1)).existsByEmail(anyString());
        verify(customerRepository, times(1)).save(any());
    }

    @Test
    void saveCustomer_DuplicateEmail_ExceptionThrown() {
       
        CustomerDetails customer = createValidCustomer();
        when(customerRepository.existsByEmail(anyString())).thenReturn(true);

    
        assertThrows(IllegalArgumentException.class, () -> customerService.saveCustomer(customer));
        verify(customerRepository, times(1)).existsByEmail(anyString());
        verify(customerRepository, never()).save(any());
    }

    

    private CustomerDetails createValidCustomer() {
        CustomerDetails customer = new CustomerDetails();
        customer.setId("1");
        customer.setName("John Doe");
        customer.setEmail("john.doe@example.com");
        customer.setDob(new Date());
        customer.setOccupation(CustomerDetails.Occupation.DEVELOPER);
        customer.setCustomerGroup(CustomerDetails.CustomerGroup.DEVELOPER);
        return customer;
    }
}
