package es.sergiomartinez.tempagua;

public class Modelo {

    private final static int TEMPERATURA_I = (int) (Math.random() * 100);

    public int aumentarTemperatura(int temp) {
        return temp + TEMPERATURA_I;
    }

    public int bajarTemperatura(int temp) {
        return TEMPERATURA_I - temp;
    }

    public int getTemp() {
        return TEMPERATURA_I;
    }
}
