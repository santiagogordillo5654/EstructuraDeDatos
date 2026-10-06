public class Mercancia implements ItemComercial {
    private String descripcion;
    private double costo;

    public Mercancia(String descripcion, double costo) {
        this.descripcion = descripcion;
        this.costo = costo;
    }

    @Override
    public double obtenerValor() {
        return this.costo;
    }

    @Override
    public String toString() {
        return descripcion + " - $" + costo;
    }
}