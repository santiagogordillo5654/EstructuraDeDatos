public class AppTienda {
    public static void main(String[] args) {
        CanastaPedidos<Mercancia> miCanasta = new CanastaPedidos<>();

        miCanasta.registrarElemento(new Mercancia("Teclado Mecánico", 250000.00));
        miCanasta.registrarElemento(new Mercancia("Silla Gamer", 850000.00));
        miCanasta.registrarElemento(new Mercancia("Cámara Web", 120000.00));

        System.out.println("RESUMEN DE LA CANASTA");
        System.out.println("Total a pagar: $" + miCanasta.calcularTotal());
        System.out.println("Artículo más caro: " + miCanasta.buscarMayorValor().obtenerValor());

        System.out.println("\nRECORRIENDO ELEMENTOS (Orden Inverso por el Iterador Propio");
        for (Mercancia item : miCanasta) {
            System.out.println("->   " + item);
        }
    }
}