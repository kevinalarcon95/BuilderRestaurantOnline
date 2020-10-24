package co.unicauca.restaurant.dishApp;

import co.unicauca.restaurant.services.DishDirector;
import co.unicauca.restaurant.domain.Dish;
import java.lang.Exception;
import java.util.Scanner;

/**
 *
 * @author Kevin Alarcón, santiago Cordoba
 */
public class Restaurant {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        DishDirector director;
        int opcion = 0;

        try {
            do {

                System.out.println("-------Menú-------");
                System.out.println("1.Plato Oriental");
                System.out.println("2.Plato Italiano");
                System.out.println("3.Salir");
                System.out.println("Ingresa una opcion: ");
                opcion = in.nextInt();
                
                switch (opcion) {
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
                    case 3:
                        System.exit(0);
                        break;
                    default:
                        System.out.println("\nVuelve a intentarlo, " + opcion + " no es una opcion valida!\n" );
                }
            } while (opcion != 3);
        } catch (Exception e) {
            System.out.println("Ingresa un valor numerico");
        }
    }
}
