package S201N1Ex1;

import java.util.ArrayList;
import java.util.List;

public class Venta {
    private List<Producto> productos;
    private double precioTotal;

    public Venta() {
        productos = new ArrayList<>();
    }

    public void agregarProducto(Producto producto) {
        if (producto != null) {
            productos.add(producto);
        }
    }

    public void calcularTotal() throws VentaBuidaException {
        if (productos.isEmpty()) {
            throw new VentaBuidaException("Para hacer una venta primero debes añadir productos");
        } else {
            precioTotal = 0;
            for (Producto producto : productos) {
                precioTotal += producto.getPrecio();
            }
        }
    }

    public double getPrecioTotal() {
        return precioTotal;
    }
}


