package org.corvine.demo;

import org.corvine.demo.domain.Customer;
import org.corvine.demo.repository.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication
public class DemoApplication {
    private static final Logger log = LoggerFactory.getLogger(DemoApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

    @Bean
    public CommandLineRunner demo(CustomerRepository repository) {
        return (args) -> {
            saveSampleCustomers(repository);
//            showAllCustomers(repository);
//            showCustomerForId(repository, 1L);
//            showCustomersMatchingName(repository, "Bauer");
        };
    }

    private void showCustomersMatchingName(CustomerRepository repository, String lastName) {
        log.info("Customer found with findByLastName('" + lastName + "'):");
        log.info("--------------------------------------------");
        for (Customer customer : repository.findByLastName(lastName)) {
            log.info(customer.toString());
        }
        log.info("");
    }

    private void showCustomerForId(CustomerRepository repository, long id) {
        Customer customer = repository.findOne(id);
        log.info("Customer found with findOne(" + id + "):");
        log.info("--------------------------------");
        log.info(customer.toString());
        log.info("");
    }

    private void showAllCustomers(CustomerRepository repository) {
        log.info("Customers found with findAll():");
        log.info("-------------------------------");
        for (Customer customer : repository.findAll()) {
            log.info(customer.toString());
        }
        log.info("");
    }

    private void saveSampleCustomers(CustomerRepository repository) {
        repository.save(new Customer("Jack", "Bauer"));
        repository.save(new Customer("Chloe", "O'Brian"));
        repository.save(new Customer("Kim", "Bauer"));
        repository.save(new Customer("David", "Palmer"));
        repository.save(new Customer("Michelle", "Dessler"));
    }

    //    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {

            System.out.println("Let's inspect the beans provided by Spring Boot:");

            String[] beanNames = ctx.getBeanDefinitionNames();
            Arrays.sort(beanNames);
            for (String beanName : beanNames) {
                System.out.println(beanName);
            }

        };
    }
}
