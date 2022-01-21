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
public class Lavadora extends Electrodomestico {

    static Scanner scanner = new Scanner(System.in).useDelimiter("\n");

    private Double carga;

    public Lavadora() {
    }

    public Lavadora(Double carga, Double precio, String color, char consumoElectrico, Double peso) {
        super(precio, color, consumoElectrico, peso);
        this.carga = carga;
    }

    public Double getCarga() {
        return carga;
    }

    public void setCarga(Double carga) {
        this.carga = carga;
    }

    /*
    este método llama a crearElectrodomestico() de la
    clase padre, lo utilizamos para llenar los atributos heredados del padre y
    después llenamos el atributo propio de la lavadora.
     */
    public void crearLavadora() {
        crearElectrodomestico();
        System.out.println("Ingrese la carga");
        carga = scanner.nextDouble();
    }

    /*
    este método será heredado y se le sumará la siguiente
    funcionalidad. Si tiene una carga mayor de 30 kg, aumentará el precio en $500,
    si la carga es menor o igual, no se incrementará el precio. Este método debe
    llamar al método padre y añadir el código necesario. Recuerda que las
    condiciones que hemos visto en la clase Electrodoméstico también deben
    afectar al precio
     */
    @Override
    public void precioFinal() {
        super.precioFinal();
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

        if (peso > 30 && peso < 50) {
            precio += 500.0;
        } else if (peso >= 50 && peso < 80) {
            precio += 800.0;
        } else if (peso > 80) {
            precio += 1000.0;
        }
    }
}
