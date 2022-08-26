package io.matoshri.main;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import io.matoshri.main.daoimpl.ProductDaoImpl;
import io.matoshri.main.model.Product;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Started ..." );
        ApplicationContext context = new ClassPathXmlApplicationContext("config/bean-config.xml");
        ProductDaoImpl productImpl = (ProductDaoImpl) context.getBean("productImpl");
        
        productImpl.create("iPhone 12", 45500);
        
        Product savedProduct = productImpl.getProductByItem("iPhone 12");
        System.out.println("Saved Product: " + savedProduct);
        
        List<Product> products = productImpl.fetchAll();
        products.forEach(System.out::println);

        ((AbstractApplicationContext) context).close();
        System.out.println("Ended ...");
    }
}
