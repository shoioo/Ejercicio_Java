/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.util.Scanner;

/**
 *
 * @author Shaila
 */
public abstract class Electrodomestico {

    static Scanner scanner = new Scanner(System.in).useDelimiter("\n");

    protected Double precio;
    protected String color;
    protected char consumoElectrico;
    protected Double peso;

    public Electrodomestico() {
    }

    public Electrodomestico(Double precio, String color, char consumoElectrico, Double peso) {
        this.precio = precio;
        this.color = color;
        this.consumoElectrico = consumoElectrico;
        this.peso = peso;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public char getConsumoElectrico() {
        return consumoElectrico;
    }

    public void setConsumoElectrico(char consumoElectrico) {
        this.consumoElectrico = consumoElectrico;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    /*comprueba que la letra es correcta, sino es correcta usara la letra F por defecto.
    Este método se debeinvocar al crear el objeto y no será visible*/
    public char comprobarConsumoEnergetico(char letra) {

        switch (letra) {
            case 'A':
            case 'B':
            case 'C':
            case 'D':
            case 'E':
            case 'F':
                break;
            default:
                letra = 'F';
        }
        return letra;
    }

    /*
    comprueba que el color es correcto, y si no lo es, usa el color blanco por defecto.
    Los colores disponibles para los electrodomésticos son blanco, negro, rojo, azul y gris. 
    No importa si el nombre está en mayúsculas o en minúsculas. 
    Este método se invocará al crear el objeto y no será visible.
     */
    public String comprobarColor(String color) {

        switch (color) {
            case "blanco":
            case "negro":
            case "azul":
            case "gris":
                break;
            default:
                color = "blanco";
        }
        return color;
    }

    /*
    le pide la información al usuario y llena el
    electrodoméstico, también llama los métodos para comprobar el color y el
    consumo. Al precio se le da un valor base de $1000.
     */
    public void crearElectrodomestico() {

        System.out.println("Ingrese el peso");
        peso = scanner.nextDouble();
        System.out.println("Ingrese el color");
        color = comprobarColor(scanner.next());
        System.out.println("Ingrese el consumo electronico");
        consumoElectrico = comprobarConsumoEnergetico(scanner.next().charAt(0));
        precio = 1000.0;
    }

    /*
    según el consumo energético y su tamaño, aumentaráel valor del precio.
     */
    public void precioFinal() {

        switch (consumoElectrico) {
            case 'A':
                precio += 1000.0;
                break;
            case 'B':
                precio += 800.0;
                break;
            case 'C':
                precio += 600.0;
                break;
            case 'D':
                precio += 500.0;
                break;
            case 'E':
                precio += 300.0;
                break;
            case 'F':
                precio += 100.0;
                break;
            default:          
        }
        
        if (peso>=1 && peso<20) {
            precio += 100.0;
        }else if (peso>=20 && peso<50) {
            precio += 500.0;
        }else if (peso>=50 && peso<80) {
            precio += 800.0;
        }else if (peso>80) {
            precio += 1000.0;
        }
    }
}
