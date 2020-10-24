package co.unicauca.restaurant.accces;

import co.unicauca.restaurant.domain.Product;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Kevin Alarcón, Santiago Cordoba
 */
public class ItalianRepositoryImplArrays implements IProductRepository {

    /**
     * Por simplicidad los datos se cargan en un array.
     */
    public static List<Product> products;

    public ItalianRepositoryImplArrays() {
        products = new ArrayList<>();
        initialize();
    }

    private void initialize() {
        products.add(new Product(1, "Risotto", 6000d));
        products.add(new Product(2, "Carpaccio", 6500d));
        products.add(new Product(3, "Sopa Minestrone", 7000d));
        products.add(new Product(4, "Ensalada Capresse", 6800d));
        products.add(new Product(5, "Ossobuco", 5900d));
        products.add(new Product(6, "Espaguetis a la carbonara", 7200d));

    }

    @Override
    public List<Product> findAll() {
        return products;
    }

    @Override
    public Product findById(Integer id) {
        for (Product prod : products) {
            if (prod.getId() == id) {
                return prod;
            }
        }
        return null;
    }

    @Override
    public boolean create(Product newProduct) {
        Product prod = this.findById(newProduct.getId());
        if (prod != null) {
            //Ya existe
            return false;
        }
        products.add(newProduct);
        return true;
    }

    @Override
    public boolean update(Product newProduct) {
        Product prod = this.findById(newProduct.getId());
        if (prod != null) {
            prod.setName(newProduct.getName());
            prod.setPrice(newProduct.getPrice());
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(Integer id) {
        for (Product prod : products) {
            if (prod.getId() == id) {
                products.remove(prod);
                return true;
            }
        }
        return false;
    }

}
