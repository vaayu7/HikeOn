package main.java.com.Assesment.backend.appConfig.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import main.java.com.Assesment.backend.appConfig.Model.CustomerDetails;
public class CustomerRepository extends MongoRepository<CustomerDetails, String>{
    
}
