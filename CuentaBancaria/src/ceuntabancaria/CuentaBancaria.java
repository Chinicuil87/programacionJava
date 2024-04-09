package ceuntabancaria;

import java.util.Scanner;


public class CuentaBancaria {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        String nombreCliente = "Cesar Lopez";
        String tipoCuenta = "Corriente";
        double saldoDisponible = 2500;
        boolean salir = true;

        String menu= """
                ****************************************
                                   
                 Esbriba el numero de la opcion deseada 
                1- Consultar saldo
                2- Retirar
                3- Depositar
                9- Salir
                                   
                ****************************************
                """;
        System.out.println("****************************************");
        System.out.println("Nombre del Cliente: " +nombreCliente);
        System.out.println("Tipo de Cuenta: " + tipoCuenta);
        System.out.println("Saldo dsiponible" + saldoDisponible);
        System.out.println("****************************************");


        while (salir) {

            System.out.println(menu);
            int seleccion = sc.nextInt();

            switch (seleccion){
                
                case 1:
                    System.out.println("Su saldo disponible es: " + saldoDisponible);
                    break;
                case 2:
                    System.out.print("Monto a retirar: ");
                    double retiro = sc.nextDouble();
                    if (retiro > saldoDisponible){
                        System.out.println("Saldo insuficiente.");
                    } else{
                        saldoDisponible = saldoDisponible - retiro;
                        System.out.println("Su saldo disponible es: " + saldoDisponible);
                    }
                    break;
                case 3:
                    System.out.println("Monto a depositar: ");
                    double deposito = sc.nextDouble();
                    saldoDisponible = saldoDisponible + deposito;
                    System.out.println("Su saldo disponible es: " + saldoDisponible);
                    break;
                case 9:
                    System.out.println("****************************************");
                    System.out.println("             Cerrando cesion");
                    System.out.println("   Gracias por usar nuestros servicios.");
                    System.out.println("****************************************");
                    salir = false;
                    break;
                default:
                    System.out.println(" Error. Opcion no valida.");
            }
        
        }
    }
    
}
