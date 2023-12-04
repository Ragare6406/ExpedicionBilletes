
package expedicionBilletes;

public class HiloPersonas extends Thread{
  
   private int persona;
   private HiloBilletes billetes;

    public HiloPersonas(int persona, HiloBilletes billetes) {
        this.persona = persona;
        this.billetes = billetes;
    }  

    @Override
    public void run() {
        billetes.compraBilletes(persona);
    }
}
