package expedicionBilletes;

public class Principal {

    public static void main(String[] args) {
        HiloBilletes billetes = new HiloBilletes();
       
        
        for (int i = 1; i <= 20; i++) {
            HiloPersonas hilo = new HiloPersonas(i, billetes);
            hilo.start();
            try {
                Thread.sleep(2000); //Espera 2 segundos para la llegada del siguiente 
            } catch (InterruptedException e) {
                e.getMessage();
            }  
        }
        for (int i = 1; i <= 20; i++) {
            try {
                HiloPersonas hilo = new HiloPersonas(i, billetes);
                hilo.join();
            } catch (InterruptedException e) {
                e.getMessage();
            }
        }
        System.out.printf("Todas las personas han comprado su billete en " +String.format("%.2f",billetes.getTiempo()) + "s" + "\n");
    }
}
