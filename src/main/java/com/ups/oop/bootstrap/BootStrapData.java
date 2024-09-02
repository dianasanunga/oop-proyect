package com.ups.oop.bootstrap;

import com.ups.oop.entity.*;
import com.ups.oop.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class BootStrapData implements CommandLineRunner {
    private final BranchRepository branchRepository;
    private final BuyerRepository buyerRepository;
    private final CityRepository cityRepository;
    private final PayRepository payRepository;
    private final ProductRepository productRepository;
    public final SellerRepository sellerRepository;
    public final InvoiceRepository invoiceRepository;
    public final InvoiceDetailRepository invoiceDetailRepository;


    public BootStrapData(BranchRepository branchRepository, BuyerRepository buyerRepository, CityRepository cityRepository, PayRepository payRepository, ProductRepository productRepository, SellerRepository sellerRepository, InvoiceRepository invoiceRepository, InvoiceDetailRepository invoiceDetailRepository) {
        this.branchRepository = branchRepository;
        this.buyerRepository = buyerRepository;
        this.cityRepository = cityRepository;
        this.payRepository = payRepository;
        this.productRepository = productRepository;
        this.sellerRepository = sellerRepository;
        this.invoiceRepository = invoiceRepository;
        this.invoiceDetailRepository = invoiceDetailRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        //City
        City c1 = new City();
        c1.setIdCity("001");
        c1.setName("Quito");
        c1.setDescription("mountain region");

        City c2 = new City();
        c2.setIdCity("002");
        c2.setName("Guayaquil");
        c2.setDescription("coastal region");

        City c3 = new City();
        c3.setIdCity("003");
        c3.setName("Galapagos");
        c3.setDescription("island region");

        City c4 = new City();
        c4.setIdCity("004");
        c4.setName("Manta");
        c4.setDescription("coastal region");

        City c5 = new City();
        c5.setIdCity("005");
        c5.setName("Esmeralda");
        c5.setDescription("coastal region");

        cityRepository.save(c1);
        cityRepository.save(c2);
        cityRepository.save(c3);
        cityRepository.save(c4);
        cityRepository.save(c5);

        //Pay
        Pay p1 = new Pay();
        p1.setIdPay("001");
        p1.setName("cash");
        p1.setDescription("payment with cash");

        Pay p2 = new Pay();
        p2.setIdPay("002");
        p2.setName("credit card");
        p2.setDescription("credit card payment");

        Pay p3 = new Pay();
        p3.setIdPay("003");
        p3.setName("debit card");
        p3.setDescription("debit card payment");

        Pay p4 = new Pay();
        p4.setIdPay("004");
        p4.setName("check");
        p4.setDescription("payment by check");

        Pay p5 = new Pay();
        p5.setIdPay("005");
        p5.setName("transfer");
        p5.setDescription("payment with transfer");

        payRepository.save(p1);
        payRepository.save(p2);
        payRepository.save(p3);
        payRepository.save(p4);
        payRepository.save(p5);

        //Branch
        Branch b1 = new Branch();
        b1.setIdBranch("001");
        b1.setName("Quito Branch");
        b1.setAddress("Quito Av. Atahualpa OE1-109 y 10 de Agosto");
        b1.setEmployeeNumber("15");
        b1.setPhoneNumber("0923564545");

        Branch b2 = new Branch();
        b2.setIdBranch("002");
        b2.setName("Guayaquil Branch");
        b2.setAddress("Pichincha 605 entre C. Ballén y República de Guayaquil");
        b2.setEmployeeNumber("20");
        b2.setPhoneNumber("0925689564");

        Branch b3 = new Branch();
        b3.setIdBranch("003");
        b3.setName("Galapagos Branch");
        b3.setAddress("Av. Charles Darwin y 12 de Febrero Edificio Capturgal");
        b3.setEmployeeNumber("10");
        b3.setPhoneNumber("0923789654");

        Branch b4 = new Branch();
        b4.setIdBranch("004");
        b4.setName("Manta Branch");
        b4.setAddress(" Manta, Calle 17 av 22");
        b4.setEmployeeNumber("25");
        b4.setPhoneNumber("0936987412");

        Branch b5 = new Branch();
        b5.setIdBranch("005");
        b5.setName("Esmeralda Branch");
        b5.setAddress("E40 Av. Samborondón Norte, 4302");
        b5.setEmployeeNumber("30");
        b5.setPhoneNumber("0913654789");

        branchRepository.save(b1);
        branchRepository.save(b2);
        branchRepository.save(b3);
        branchRepository.save(b4);
        branchRepository.save(b5);

        //Buyer
        Buyer by1 = new Buyer();
        by1.setBuyerId("001");
        by1.setRegistrationDate(new Date());
        by1.setName("Diana");
        by1.setLastname("Sanunga");
        by1.setAge(18);
        by1.setAddress("via daule");
        by1.setCity(c1);
        by1.setPhoneNumber("0911354687");
        by1.setEmail("ds@gmail.com");
        buyerRepository.save(by1);

        c1.getBuyers().add(by1);
        buyerRepository.save(by1);

        Buyer by2 = new Buyer();
        by2.setBuyerId("002");
        by2.setRegistrationDate(new Date());
        by2.setName("valeska");
        by2.setLastname("adrian");
        by2.setAge(20);
        by2.setAddress("via duran");
        by2.setCity(c2);
        by2.setPhoneNumber("0923657891");
        by2.setEmail("va@gmail.com");
        buyerRepository.save(by2);

        c2.getBuyers().add(by2);
        buyerRepository.save(by2);

        Buyer by3 = new Buyer();
        by3.setBuyerId("003");
        by3.setRegistrationDate(new Date());
        by3.setName("Miguel");
        by3.setLastname("toral");
        by3.setAge(23);
        by3.setAddress("Urdesa");
        by3.setCity(c2);
        by3.setPhoneNumber("0923564789");
        by3.setEmail("mt@gmail.com");
        buyerRepository.save(by3);

        c3.getBuyers().add(by3);
        buyerRepository.save(by3);

        Buyer by4 = new Buyer();
        by4.setBuyerId("004");
        by4.setRegistrationDate(new Date());
        by4.setName("matias");
        by4.setLastname("Adrian");
        by4.setAge(30);
        by4.setAddress("via a la costa");
        by4.setCity(c3);
        by4.setPhoneNumber("0956987412");
        by4.setEmail("ma@gmail.com");
        buyerRepository.save(by4);

        c4.getBuyers().add(by4);
        buyerRepository.save(by4);

        Buyer by5 = new Buyer();
        by5.setBuyerId("005");
        by5.setRegistrationDate(new Date());
        by5.setName("lucia");
        by5.setLastname("Hidalgo");
        by5.setAge(25);
        by5.setAddress("via quito");
        by5.setCity(c5);
        by5.setPhoneNumber("0932145698");
        by5.setEmail("lh@gmail.com");
        buyerRepository.save(by5);

        c5.getBuyers().add(by5);
        buyerRepository.save(by5);

        //Seller
        Seller s1 = new Seller();
        s1.setIdSeller("001");
        s1.setName("Eduardo");
        s1.setLastname("Adrian");
        s1.setAge(20);
        s1.setCity(c1);
        s1.setEmail("ea@gmail.com");
        s1.setPhoneNumber("0623547895");
        sellerRepository.save(s1);

        c1.getSellers().add(s1);
        sellerRepository.save(s1);

        Seller s2 = new Seller();
        s2.setIdSeller("002");
        s2.setName("Adriana");
        s2.setLastname("maldonado");
        s2.setAge(25);
        s2.setCity(c2);
        s2.setEmail("am@gmail.com");
        s2.setPhoneNumber("0932456987");
        sellerRepository.save(s2);

        c2.getSellers().add(s2);
        sellerRepository.save(s2);

        Seller s3 = new Seller();
        s3.setIdSeller("003");
        s3.setName("Ariana");
        s3.setLastname("Goya");
        s3.setAge(30);
        s3.setCity(c3);
        s3.setEmail("ag@gmail.com");
        s3.setPhoneNumber("0965321478");
        sellerRepository.save(s2);

        c3.getSellers().add(s2);
        sellerRepository.save(s2);

        Seller s4 = new Seller();
        s4.setIdSeller("001");
        s4.setName("Mirka");
        s4.setLastname("Alvarez");
        s4.setAge(23);
        s4.setCity(c4);
        s4.setEmail("ma@gmail.com");
        s4.setPhoneNumber("0956321456");
        sellerRepository.save(s4);

        c4.getSellers().add(s4);
        sellerRepository.save(s4);

        Seller s5 = new Seller();
        s5.setIdSeller("005");
        s5.setName("Milena");
        s5.setLastname("Vera");
        s5.setAge(35);
        s5.setCity(c5);
        s5.setEmail("mv@gmail.com");
        s5.setPhoneNumber("0923657821");
        sellerRepository.save(s5);

        c5.getSellers().add(s5);
        sellerRepository.save(s5);

        //Product
        Product pd1 = new Product();
        pd1.setIdProduct("001");
        pd1.setName("blouse");
        pd1.setDescription("Product A");
        pd1.setPrice(25);

        Product pd2 = new Product();
        pd2.setIdProduct("002");
        pd2.setName("Pants");
        pd2.setDescription("Product B");
        pd2.setPrice(10);

        Product pd3 = new Product();
        pd3.setIdProduct("003");
        pd3.setName("Short");
        pd3.setDescription("Product C");
        pd3.setPrice(50);

        Product pd4 = new Product();
        pd4.setIdProduct("004");
        pd4.setName("skirt");
        pd4.setDescription("product D");
        pd4.setPrice(30);

        Product pd5 = new Product();
        pd5.setIdProduct("005");
        pd5.setName("dress");
        pd5.setDescription("Product E");
        pd5.setPrice(40);

        productRepository.save(pd1);
        productRepository.save(pd2);
        productRepository.save(pd3);
        productRepository.save(pd4);
        productRepository.save(pd5);

        //invoice
        Invoice i1 = new Invoice();
        i1.setSerial("001");
        i1.setInvoiceDate("2024-09-02");
        i1.setBranch(b1);
        i1.setBuyer(by1);
        i1.setSubtotal(80);
        i1.setTax(12);
        i1.setTotal(92);
        i1.setSeller(s1);
        i1.setPay(p1);
        invoiceRepository.save(i1);

        b1.getInvoices().add(i1);
        by1.getInvoices().add(i1);
        s1.getInvoices().add(i1);
        p1.getInvoices().add(i1);
        invoiceRepository.save(i1);

        Invoice i2 = new Invoice();
        i2.setSerial("002");
        i2.setInvoiceDate("2024-09-01");
        i2.setBranch(b2);
        i2.setBuyer(by2);
        i2.setSubtotal(200);
        i2.setTax(30);
        i2.setTotal(230);
        i2.setSeller(s2);
        i2.setPay(p2);
        invoiceRepository.save(i2);

        b2.getInvoices().add(i2);
        by2.getInvoices().add(i2);
        s2.getInvoices().add(i2);
        p2.getInvoices().add(i2);
        invoiceRepository.save(i2);

        //InvoiceDetail
        InvoiceDetail id1 = new InvoiceDetail();
        id1.setIdInvoiceDetail("a1");
        id1.setInvoice(i1);
        id1.setProduct(pd1);
        id1.setUnitPrice("25");
        id1.setQuantity("2");
        id1.setTotal("50");

        invoiceDetailRepository.save(id1);
        i1.getDetailList().add(id1);
        pd1.getDetailList().add(id1);
        invoiceDetailRepository.save(id1);

        InvoiceDetail id2 = new InvoiceDetail();
        id2.setIdInvoiceDetail("b2");
        id2.setInvoice(i1);
        id2.setProduct(pd2);
        id2.setUnitPrice("10");
        id2.setQuantity("3");
        id2.setTotal("30");

        invoiceDetailRepository.save(id2);
        i1.getDetailList().add(id2);
        pd2.getDetailList().add(id2);
        invoiceDetailRepository.save(id2);

        InvoiceDetail id3 = new InvoiceDetail();
        id3.setIdInvoiceDetail("c3");
        id3.setInvoice(i2);
        id3.setProduct(pd3);
        id3.setUnitPrice("50");
        id3.setQuantity("4");
        id3.setTotal("200");

        invoiceDetailRepository.save(id3);
        i2.getDetailList().add(id3);
        pd3.getDetailList().add(id3);
        invoiceDetailRepository.save(id3);


        System.out.println("--------Started BootstrapData-------- ");
        System.out.println("Number of City: " +cityRepository.count());
        System.out.println("Number of Branch: " +branchRepository.count());
        System.out.println("Number of Buyer: " +buyerRepository.count());
        System.out.println("Number of Pay: " +payRepository.count());
        System.out.println("Number of Product: " +productRepository.count());
        System.out.println("Number of Seller: " +sellerRepository.count());
        System.out.println("Number of Invoice: " +invoiceRepository.count());
        System.out.println("Number of InvoiceDetail: " +invoiceDetailRepository.count());









    }
}
