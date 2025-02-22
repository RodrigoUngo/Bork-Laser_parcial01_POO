package com.RAUM.x00075419;

public class ServicioProfesional extends Empleado{
    private int mesesContrato;

    public ServicioProfesional(String nombre, String puesto, double salario, int mesesContrato) {
        super(nombre, puesto, salario);
        this.mesesContrato = mesesContrato;
    }

    public int getMesesContrato() {
        return mesesContrato;
    }

    public void setMesesContrato(int mesesContrato) {
        this.mesesContrato = mesesContrato;
    }

    @Override
    public String toString() {
        return "ServicioProfesional{" +
                "nombre='" + nombre +
                ", puesto='" + puesto + '\'' +
                ", salario=" + salario + '\'' +
                ", mesesContrato=" + mesesContrato +
                '}';
    }
}
