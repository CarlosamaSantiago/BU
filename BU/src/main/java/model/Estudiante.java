package model;

public class Estudiante {
    private String nombre;
    private String codigo;
    private double peso;
    private double altura;

    public Estudiante(String nombre, String codigo, double peso, double altura) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.peso = peso;
        this.altura = altura;
    }

    public double getAltura() {
        return altura;
    }

    public double getPeso() {
        return peso;
    }
}
