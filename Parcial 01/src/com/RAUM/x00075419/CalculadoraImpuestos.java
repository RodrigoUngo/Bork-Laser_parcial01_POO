package com.RAUM.x00075419;

public final class CalculadoraImpuestos {
    private static double totalRenta, totalISSS, totalAFP;

    private CalculadoraImpuestos() {
    }

    public static double calcularPago(Empleado p){
        double Renta = 0, ISSS = 0, AFP = 0, restante = 0;
        if(p instanceof ServicioProfesional){
            Renta = 0.1*p.salario;
            totalRenta += Renta;
            return p.salario - Renta;
        }
        else{
            AFP = 0.0625*p.salario;
            ISSS = 0.03*p.salario;
            restante = p.salario - AFP - ISSS;
            if(restante >= 0.01 && restante <= 472)
                Renta = 0;
            else if(restante >= 472.01 && restante <= 895.24)
                Renta = 0.1*(restante - 472) + 17.67;
            else if(restante >= 895.25 && restante <= 2038.10)
                Renta = 0.2*(restante - 895.24) + 60;
            else if(restante >= 2038.11)
                Renta = 0.3*(restante - 2038.10) + 288.57;
            totalRenta += Renta;
            totalISSS += ISSS;
            totalAFP += AFP;
            return restante - Renta;
        }
    }

    public static String mostrarTotales() {
        return "Total de impuestos de Renta: " + totalRenta +
                ", Total de ISSS: " + totalISSS +
                ", Total de AFP: " + totalAFP +
                '}';
    }
}
