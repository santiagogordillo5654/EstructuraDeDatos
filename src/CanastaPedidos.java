import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

// La clase es genérica y obliga a que T sea un ItemComercial
public class CanastaPedidos<T extends ItemComercial> implements Iterable<T> {

    private List<T> elementos;

    public CanastaPedidos() {
        this.elementos = new ArrayList<>();
    }

    // Requisito: Agregar productos
    public void registrarElemento(T item) {
        elementos.add(item);
    }

    // Requisito: Obtener el producto de mayor precio
    public T buscarMayorValor() {
        if (elementos.isEmpty()) return null;
        return elementos.stream()
                .max(Comparator.comparing(ItemComercial::obtenerValor))
                .orElse(null);
    }

    // Requisito: Calcular el precio total
    public double calcularTotal() {
        return elementos.stream()
                .mapToDouble(ItemComercial::obtenerValor)
                .sum();
    }

    // Exponemos el iterador personalizado
    @Override
    public Iterator<T> iterator() {
        return new RecorridoInverso();
    }

    // ITERADOR PROPIO: Diseñado para recorrer la lista de atrás hacia adelante
    private class RecorridoInverso implements Iterator<T> {
        // Iniciamos el puntero en la última posición válida de la lista
        private int posicionActual = elementos.size() - 1;

        @Override
        public boolean hasNext() {
            // Hay un siguiente elemento si la posición es mayor o igual a 0
            return posicionActual >= 0;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException("No hay más elementos en la canasta.");
            }
            // Retorna el elemento y luego resta 1 a la posición
            return elementos.get(posicionActual--);
        }
    }
}