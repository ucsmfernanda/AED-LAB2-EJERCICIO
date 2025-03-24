package ejercicio;

public class OperacionesMat<T extends Number> implements Operable<T> {

    @Override
    public T suma(T operando1, T operando2) {
        return convertir(operando1.doubleValue() + operando2.doubleValue(), operando1);
    }

    @Override
    public T resta(T operando1, T operando2) {
        return convertir(operando1.doubleValue() - operando2.doubleValue(), operando1);
    }

    @Override
    public T producto(T operando1, T operando2) {
        return convertir(operando1.doubleValue() * operando2.doubleValue(), operando1);
    }

    @Override
    public T division(T operando1, T operando2) {
        if (operando2.doubleValue() == 0) {
            throw new ArithmeticException("División por cero no permitida");
        }
        return convertir(operando1.doubleValue() / operando2.doubleValue(), operando1);
    }

    @Override
    public T potencia(T base, T exponente) {
        return convertir(Math.pow(base.doubleValue(), exponente.doubleValue()), base);
    }

    @Override
    public T raizCuadrada(T operando) {
        return convertir(Math.sqrt(operando.doubleValue()), operando);
    }

    @Override
    public T raizCubica(T operando) {
        return convertir(Math.cbrt(operando.doubleValue()), operando);
    }

    // Método para convertir Double al tipo original de T
    private T convertir(double resultado, T referencia) {
        if (referencia instanceof Integer) {
            return (T) Integer.valueOf((int) resultado);
        } else if (referencia instanceof Long) {
            return (T) Long.valueOf((long) resultado);
        } else if (referencia instanceof Float) {
            return (T) Float.valueOf((float) resultado);
        } else if (referencia instanceof Double) {
            return (T) Double.valueOf(resultado);
        } else {
            throw new UnsupportedOperationException("Tipo de dato no soportado");
        }
    }
}

