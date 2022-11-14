package calculadorswing.sergio.martinez.carrilero;

public class Modelo {

//    Variable que almacena el resultado
    double resultado = 0;

//    Metodos para sumar, restar, multiplicar y dividir todos almacenan  y
//    van actualizando la variable resultado
    public double sumar(double num) {
        resultado += num;
        return resultado;
    }

    public double restar(double num) {
        resultado -= num;
        return resultado;
    }

    public double multiplicar(double num) {
        resultado *= num;
        return resultado;
    }

//    El metodo dividir tiene una excepción para lidiar cuando un numero se
//    divide entre 0 y en vez de NaN entre en error y se pueda continuar con
//    la funcionalidad del programa
    public double dividir(double num) throws NumberFormatException {
        if (num != 0) {
            resultado /= num;
            return resultado;
        } else {
            throw new NumberFormatException("Division entre 0");
        }

    }

    //Get y Set de la variable resultado
    public double getResultado() {
        return resultado;
    }

    public void setResultado(double resultado) {
        this.resultado = resultado;
    }

}
