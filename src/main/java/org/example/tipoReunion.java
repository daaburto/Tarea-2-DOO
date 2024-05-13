package org.example;


public enum tipoReunion{
    TECNICA(0),
    MARKETING(1),
    OTRO(2);
    private final int tipo;

    private tipoReunion(int tipo) {
        this.tipo = tipo;
    }

    public int getTipo() {
        return tipo;
    }
}