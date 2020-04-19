package com.RAUM.x00075419;
import java.util.Scanner;

public class Main {
    static Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
        String empleado, puesto;
        double salario;
        int mesescontrato, extension;
        System.out.println("Empleado servicio profesional");
        System.out.println("Nombre: "); empleado = in.nextLine();
        System.out.println("Puesto: "); puesto = in.nextLine();
        System.out.println("Salario total: "); salario = in.nextDouble(); in.nextLine();
        System.out.println("Meses de duracion del contrato: "); mesescontrato = in.nextInt(); in.nextLine();
        ServicioProfesional servicio = new ServicioProfesional(empleado, puesto, salario, mesescontrato);

        System.out.println("Empleado de plaza fija");
        System.out.println("Nombre: "); empleado = in.nextLine();
        System.out.println("Puesto: "); puesto = in.nextLine();
        System.out.println("Salario total: "); salario = in.nextDouble(); in.nextLine();
        System.out.println("Extension del contrato (meses): "); extension = in.nextInt(); in.nextLine();
        PlazaFija plaza = new PlazaFija(empleado, puesto, salario, extension);

        double salario1 = CalculadoraImpuestos.calcularPago(servicio);
        System.out.println("Salario liquido del empleado de servicio profesional: " + salario1);
        double salario2 = CalculadoraImpuestos.calcularPago(plaza);
        System.out.println("Salario liquido del empleado con plaza fija: " + salario2);
        System.out.println("");

        System.out.println(CalculadoraImpuestos.mostrarTotales());
    }
}
