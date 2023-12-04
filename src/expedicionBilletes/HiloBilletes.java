/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package expedicionBilletes;

import java.util.concurrent.Semaphore;

/**
 *
 * @author Miguel
 */
public class HiloBilletes extends Thread {

    Semaphore semaforo = new Semaphore(1);
    private double tiempo = 0;
    private double tiempoTotal= 0;

    public double getTiempo() {
       return tiempoTotal;
    }

    public void compraBilletes(int persona) {
        
        try {
            
            semaforo.acquire(); //bloquea el semaforo
            System.out.println("Persona " + persona + " inicia la compra del billete.");//mensaje en consola para comprobar funcionamiento
            long tiempoInicio = System.currentTimeMillis(); // Marcar el tiempo de inicio
            Thread.sleep((int) (Math.random() * 2 + 1) * 1000); //generamos un tiempo aleatorio entre 1 y 3s (lo multiplicamos por 1000 para pasar a milisegundos)
            semaforo.release();//se libera el semaforo
            System.out.println("Persona " + persona + " ha terminado de comprar el billete.");
            long tiempoFin = System.currentTimeMillis(); // Marcar el tiempo de fin
            double tiempo = ((tiempoFin - tiempoInicio)/1000.0); // Calcular el tiempo utilizado
            tiempoTotal += tiempo; //Sumamos el tiempo de la persona al tiempo total
             
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
