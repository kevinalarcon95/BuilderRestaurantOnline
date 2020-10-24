package co.unicauca.restaurant.dishApp;

import co.unicauca.restaurant.services.DishDirector;
import co.unicauca.restaurant.domain.Dish;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Kevin Alarcón, santiago Cordoba
 */
public class Restaurant {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        DishDirector director;
        String opcion = "";

        System.out.println("-------Menú-------");
        System.out.println("1.Plato Oriental");
        System.out.println("2.Plato Italiano");
        System.out.println("Ingresa una opcion: ");
        opcion = br.readLine();

        switch (Integer.parseInt(opcion)) {
            case 1:
                director = new DishDirector(new OrientalDishBuilder());
                director.create();
                Dish myDish = director.getDish();
                System.out.println("El plato le cuesta: " + myDish.getPrice());
                break;
            case 2:
                director = new DishDirector(new ItalianDishBuilder());
                director.create();
                Dish myDish1 = director.getDish();
                System.out.println("El plato le cuesta: " + myDish1.getPrice());
                break;
            default:
                System.out.println("No es una opcion valida");
        }

    }
}
