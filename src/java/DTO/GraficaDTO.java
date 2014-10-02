/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author Pwned
 */
public class GraficaDTO {

    public GraficaDTO() {
    }
  
    private  int cantidad;
    private String nombre;

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "GraficaDTO{" + "cantidad=" + cantidad + ", nombre=" + nombre + '}';
    }
    
}
