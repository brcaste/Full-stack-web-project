package com.example.demo.bootstrap;

import com.example.demo.domain.InhousePart;
import com.example.demo.domain.OutsourcedPart;
import com.example.demo.domain.Product;
import com.example.demo.repositories.OutsourcedPartRepository;
import com.example.demo.repositories.PartRepository;
import com.example.demo.repositories.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


/**
 *
 *
 *
 *
 */
@Component
public class BootStrapData implements CommandLineRunner {

    private final PartRepository partRepository;
    private final ProductRepository productRepository;

    private final OutsourcedPartRepository outsourcedPartRepository;

    public BootStrapData(PartRepository partRepository, ProductRepository productRepository, OutsourcedPartRepository outsourcedPartRepository) {
        this.partRepository = partRepository;
        this.productRepository = productRepository;
        this.outsourcedPartRepository=outsourcedPartRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        if(productRepository.count() == 0 && outsourcedPartRepository.count() == 0 && partRepository.count() == 0) {
            //add sample part list
            OutsourcedPart movement = new OutsourcedPart("42-mm Automatic Movement", 3599.89, 5, 1, 10, "Rolex");
            OutsourcedPart crown = new OutsourcedPart("14k Solid Gold Crown", 176.89, 5, 1 ,10, "Rolex");
            InhousePart ttBand = new InhousePart("14k Two-Toned Watch Band", 389.99, 5, 1, 10, 101L);
            InhousePart wgBand = new InhousePart("10k White Gold Watch Band", 289.99, 5, 1, 10, 110L);
            OutsourcedPart wgCase = new OutsourcedPart("42-mm White Gold Case", 279.99, 5, 1,10, "Rolex");

            outsourcedPartRepository.save(movement);
            outsourcedPartRepository.save(crown);
            partRepository.save(ttBand);
            partRepository.save(wgBand);
            outsourcedPartRepository.save(wgCase);


            //add sample list
            Product submariner = new Product("42-mm Submariner", 12089.99, 1);
            Product datejust = new Product("42-mm Oyster Perpetual Datejust", 7800.89, 1);
            Product skydweller = new Product("42-mm White Gold SkyDweller", 42000,1);
            Product gmtMaster = new Product("42-mm GMT-Master Gold", 38500, 1);
            Product daytona = new Product("42-mm Cosmograph Daytona Rose Gold", 32100, 1);
            productRepository.save(submariner);
            productRepository.save(datejust);
            productRepository.save(skydweller);
            productRepository.save(gmtMaster);
            productRepository.save(daytona);
        }

        System.out.println("Started in Bootstrap");
        System.out.println("Number of Products "+productRepository.count());
        System.out.println(productRepository.findAll());
        System.out.println("Number of Parts "+partRepository.count());
        System.out.println(partRepository.findAll());

    }
}
