package com.TravelSiteApplication.bootstrap;

import com.TravelSiteApplication.dao.CustomerRepository;
import com.TravelSiteApplication.dao.DivisionRepository;
import com.TravelSiteApplication.entity.Customer;
import com.TravelSiteApplication.entity.Division;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {

    private final CustomerRepository customerRepository;
    private final DivisionRepository divisionRepository;

    public BootstrapData(CustomerRepository customerRepository, DivisionRepository divisionRepository) {
        this.customerRepository = customerRepository;
        this.divisionRepository = divisionRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if((customerRepository.count() == 1)) {

            // Create and populate division for Customer use
            Division sampleDivision = new Division();
            sampleDivision.setDivision_name("Idaho");
            sampleDivision.setId(11L);
            sampleDivision.setCountry_id(1L);
            //Save division if not previously populated
            divisionRepository.save(sampleDivision);


            Customer customer1 = new Customer(sampleDivision, "44 Cherry Lane", "James", "Smith", "111-111-1111", "11111");
            customerRepository.save(customer1);

            Customer customer2 = new Customer(sampleDivision, "22 Apple Ave", "Charles", "Jones", "222-222-2222", "22222");
            customerRepository.save(customer2);

            Customer customer3 = new Customer(sampleDivision, "33 Banana Cove", "Megan", "Thompson", "333-333-3333", "33333");
            customerRepository.save(customer3);

            Customer customer4 = new Customer(sampleDivision, "44 Pomegranate Path", "Jeffrey", "Revello", "444-444-4444", "44444");
            customerRepository.save(customer4);

            Customer customer5 = new Customer(sampleDivision, "55 Orange Blvd", "Lyndsay", "Lou", "555-555-5555", "55555");
            customerRepository.save(customer5);
        }
    }
}
