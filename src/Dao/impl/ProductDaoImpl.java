package Dao.impl;

import Dao.ProductDao;
import Model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductDaoImpl implements ProductDao {

    private static ProductDaoImpl INSTANCE_DAO_PRODUCT;
    public List<Product> books = new ArrayList<>();

    private ProductDaoImpl() {
        init();
    }

    public static ProductDaoImpl getInstance() {
        if (INSTANCE_DAO_PRODUCT == null) {
            INSTANCE_DAO_PRODUCT = new ProductDaoImpl();
        }
        return INSTANCE_DAO_PRODUCT;
    }

    @Override
    public List<Product> init() {
        books.add(new Product("Effective_Java", "Joshua_Bloch", 160));
        books.add(new Product("Voina_i_mir", "Lev_Tolstoy", 10));
        books.add(new Product("Kobzar", "Taras_Shevchenko", 250));
        books.add(new Product("The_Great_Gatsby", "Scott_Fitzgerald", 50));
        books.add(new Product("Lisova_Pisnya", "Lesya_Ukrainka", 80));
        books.add(new Product("Poems", "Lesya_Ukrainka", 80));
        books.add(new Product("Poems", "Lesya_Ukrainka", 80));
        books.add(new Product("Java_Puzzlers", "Joshua_Bloch", 160));

        return books;
    }
}
