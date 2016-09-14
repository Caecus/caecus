package caecus.com.caecus.Entidades;

import android.location.Location;

/**
 * Created by Windows on 12/06/2016.
 */
public class Aviso {
  //  private PDV pdv;
    private String apellido;
    private String nombre;
    private double lng;
    private double lat;
    private int telefono;

    public Aviso(String apellido, String nombre, int telefono) {
        this.apellido = apellido;
        this.nombre = nombre;
        this.telefono = telefono;
        this.lat= -31.400267;
        this.lng= -64.184794;
    }

    public void onLocationChanged(Location loc) {
        // Este metodo se ejecuta cada vez que el GPS recibe nuevas coordenadas
        // debido a la deteccion de un cambio de ubicacion

        lat = loc.getLatitude();
        lng = loc.getLongitude();
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }


}


