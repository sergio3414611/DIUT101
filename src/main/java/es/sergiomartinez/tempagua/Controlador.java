package es.sergiomartinez.tempagua;

public class Controlador {

    private Modelo modelo;
    private Vista vista;

    public Controlador() {
        modelo = new Modelo();
        vista = new Vista(this);
    }

    public static void main(String[] args) {
        //args = new String[]{"-b", "80"};
        Controlador ctrl = new Controlador();
        ctrl.inciarVista(args);
    }

    private void inciarVista(String[] args) {
        vista.convertir(args);
    }

    void auTemperatura(int temp) {
        int diferente = modelo.aumentarTemperatura(temp);
        vista.showT(diferente);
    }

    void bjTemperatura(int temp) {
        int red = modelo.bajarTemperatura(temp);
        vista.showT(red);
    }

    void compTemp() {
        int grey = modelo.getTemp();
        vista.showT(grey);
    }
}
