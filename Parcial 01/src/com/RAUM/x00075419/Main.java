package com.RAUM.x00075419;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {
    static Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
        String empleado = "", puesto = "";
        double salario = 0;
        int mesescontrato = 0, extension = 0;
        boolean continuar = false;
        System.out.println("Empleado servicio profesional");
        do {
            try {
                System.out.println("Nombre: ");
                empleado = in.nextLine();
                if (empleado.equals(""))
                    throw new EmpyFieldException("Por favor ingrese los datos en los campos respectivos");
                System.out.println("Puesto: ");
                puesto = in.nextLine();
                if (puesto.equals(""))
                    throw new EmpyFieldException("Por favor ingrese los datos en los campos respectivos");
                System.out.println("Salario total: ");
                salario = in.nextDouble();
                in.nextLine();
                if (salario < 0)
                    throw new NegativeNumberException("No puede ingresar un salario negativo");
                System.out.println("Meses de duracion del contrato: ");
                mesescontrato = in.nextInt();
                in.nextLine();
                if (mesescontrato < 0)
                    throw new NegativeNumberException("No puede ingresar una cantidad negativa");
                continuar = true;
            } catch (EmpyFieldException | NegativeNumberException | InputMismatchException ex) {
                System.out.println(ex.getMessage());
            }
        }
        while(!continuar);
        ServicioProfesional servicio = new ServicioProfesional(empleado, puesto, salario, mesescontrato);

        continuar = false;

        System.out.println("Empleado de plaza fija");
        do {
            try {
                System.out.println("Nombre: ");
                empleado = in.nextLine();
                if (empleado.equals(""))
                    throw new EmpyFieldException("Por favor ingrese los datos en los campos respectivos");
                System.out.println("Puesto: ");
                puesto = in.nextLine();
                if (puesto.equals(""))
                    throw new EmpyFieldException("Por favor ingrese los datos en los campos respectivos");
                System.out.println("Salario total: ");
                salario = in.nextDouble(); in.nextLine();
                if (salario < 0)
                    throw new NegativeNumberException("No puede ingresar un salario negativo");
                System.out.println("Extension del contrato (meses): ");
                extension = in.nextInt(); in.nextLine();
                if (extension < 0)
                    throw new NegativeNumberException("No puede ingresar una cantidad negativa");
                continuar = true;
            } catch (EmpyFieldException | NegativeNumberException | InputMismatchException ex) {
                System.out.println(ex.getMessage());
            }
        }
        while(!continuar);
        PlazaFija plaza = new PlazaFija(empleado, puesto, salario, extension);

        double salario1 = CalculadoraImpuestos.calcularPago(servicio);
        System.out.println("Salario liquido de empleado de servicio profesional: " + salario1);
        double salario2 = CalculadoraImpuestos.calcularPago(plaza);
        System.out.println("Salario liquido del empleado con plaza fija: " + salario2);
        System.out.println("");

        System.out.println(CalculadoraImpuestos.mostrarTotales());
    }
}
