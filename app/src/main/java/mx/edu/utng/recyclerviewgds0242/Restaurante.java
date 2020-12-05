package mx.edu.utng.recyclerviewgds0242;

public class Restaurante {
    //Definir los atributos de la clase, deben corresponder a los datos a mostrar
    private String nombre;
    private String utlPhoto;
    private float valoracion;
    private String direccion;
    private int id;

    public Restaurante(int id, String nombre, String utlPhoto, float valoracion, String direccion) {
        this.id = id;
        this.nombre = nombre;
        this.utlPhoto = utlPhoto;
        this.valoracion = valoracion;
        this.direccion = direccion;
    }

    //Métodos Getterand Setter


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUtlPhoto() {
        return utlPhoto;
    }

    public void setUtlPhoto(String utlPhoto) {
        this.utlPhoto = utlPhoto;
    }

    public float getValoracion() {
        return valoracion;
    }

    public void setValoracion(float valoracion) {
        this.valoracion = valoracion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}
