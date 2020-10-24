package co.unicauca.restaurant.dishApp;

import co.unicauca.restaurant.accces.IProductRepository;
import co.unicauca.restaurant.accces.ItalianRepositoryImplArrays;
import co.unicauca.restaurant.domain.Product;
import co.unicauca.restaurant.domain.Size;
import co.unicauca.restaurant.services.DishBuilder;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Implementación por defecto. El framewok contenedor de CDI (Contexts and
 * Dependency Injection) carga la implementación por defecto.
 * 
 * @author Kevin Alarcón, Santiago Cordoba
 */
public class ItalianDishBuilder extends DishBuilder{
    
    IProductRepository myRepository;
    ItalianDish myItalianDish;
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    List<Product> allProducts;
    List<Product> bases;
    List<Product> options;
    
    private Product read(List<Product> myProducts, String foodPart){
        String input = "";
        try{
            int i = 1;
            System.out.println("Seleccione una " + foodPart);
            for (Product myProduct : myProducts) {
                System.out.println("" + i + ". " + myProduct.getName() + ":" + myProduct.getPrice());
                i++;
            }
            System.out.println("Ingrese el codigo de la " + foodPart);
            input = br.readLine();
        }catch(IOException e){
        }
        return myProducts.get(Integer.parseInt(input) -1);
    }
    
    private String read(String message){
        String input = "";
        try {
            System.out.println(message);
            input = br.readLine();
        } catch (IOException e) {
        }
        return input;
    }

    @Override
    public DishBuilder init() {
       myRepository = new ItalianRepositoryImplArrays();
       myDish = new ItalianDish(0.0);
       myItalianDish = (ItalianDish) myDish;
       allProducts = myRepository.findAll();
       bases = new ArrayList<Product>();
       options = new ArrayList<Product>();
        for (Product allProduct : allProducts) {
            if(allProduct.getId() <4){
                bases.add(allProduct);
            }else{
                options.add(allProduct);
            }
        }
        return this;
    }

    @Override
    public DishBuilder setCore() {
        myItalianDish.setBase(read(bases, "Base"));
        return this;
    }

    @Override
    public boolean addPart() {
        myItalianDish.addOption(read(options, "Opcion"));
        return ("S".equals(read("Presione S para más opciones")));
    }

    @Override
    public DishBuilder setSize() {
        String tamano = read("Presione la letra correspondiente para el tamaño Personal(P), Doble (D), Familiar (F)");
        if (tamano.equals("F")) {
            myItalianDish.setSize(Size.FAMILY);
        }
        if (tamano.equals("D")) {
            myItalianDish.setSize(Size.DOUBLE);
        }
        if (tamano.equals("P")) {
            myItalianDish.setSize(Size.PERSONAL);
        }
        return this;
    }

}
