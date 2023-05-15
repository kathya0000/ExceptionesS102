package S201N1Ex1;

public class Main {
    public static void main(String[] args) {
        // Creamos algunos productos
        Producto producto1 = new Producto("Leche", 2.0);
        Producto producto2 = new Producto("Pan", 1.0);
        Producto producto3 = new Producto("Azúcar", 0.5);

        // Creamos una venta y añadimos los productos
        Venta venta = new Venta();
        venta.agregarProducto(producto1);
        venta.agregarProducto(producto2);
        venta.agregarProducto(producto3);

        // Añadimos otro producto a la venta
        venta.agregarProducto(new Producto("Aceite", 3.0));

        try {
            // Calculamos el precio total de la venta de nuevo
            venta.calcularTotal();
            System.out.println("El precio total de la venta es: " + venta.getPrecioTotal());
        } catch (VentaBuidaException e) {
            System.out.println(e.getMessage());
        }

        // Intentamos agregar un producto nulo a la venta
        venta.agregarProducto(null);

        try {
            // Calculamos el precio total de la venta de nuevo
            venta.calcularTotal();
            System.out.println("El precio total de la venta es: " + venta.getPrecioTotal());
        } catch (VentaBuidaException e) {
            System.out.println(e.getMessage());
        }
    }
}
