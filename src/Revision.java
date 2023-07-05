public class Revision {

    private int idRevision;
    private int idVisita;
    private String nombre;
    private String detalle;
    private int estado;

    // Constructor de la clase
    public Revision(int idRevision, int idVisita, String nombre, String detalle, int estado) throws IllegalArgumentException {
        validarNombre(nombre);
        validarDetalle(detalle);
        validarEstado(estado);
        this.idRevision = idRevision;
        this.idVisita = idVisita;
        this.nombre = nombre;
        this.detalle = detalle;
        this.estado = estado;
    }

    // Getters y setters
    public int getIdRevision() {
        return idRevision;
    }

    public void setIdRevision(int idRevision) {
        this.idRevision = idRevision;
    }

    public int getIdVisita() {
        return idVisita;
    }

    public void setIdVisita(int idVisita) {
        this.idVisita = idVisita;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        validarNombre(nombre);
        this.nombre = nombre;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        validarDetalle(detalle);
        this.detalle = detalle;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        validarEstado(estado);
        this.estado = estado;
    }

    // Método para validar el nombre alusivo a la revisión
    private void validarNombre(String nombre) throws IllegalArgumentException {
        if (nombre == null || nombre.isEmpty()) {
            throw new IllegalArgumentException("El nombre alusivo a la revisión es obligatorio.");
        }
        if (nombre.length() < 10 || nombre.length() > 50) {
            throw new IllegalArgumentException("El nombre alusivo a la revisión debe tener entre 10 y 50 caracteres.");
        }
    }

    // Método para validar el detalle de la revisión
    private void validarDetalle(String detalle) throws IllegalArgumentException {
        if (detalle != null && detalle.length() > 100) {
            throw new IllegalArgumentException("El detalle para revisar no puede tener más de 100 caracteres.");
        }
    }

    // Método para validar el estado de la revisión
    private void validarEstado(int estado) throws IllegalArgumentException {
        if (estado < 1 || estado > 3) {
            throw new IllegalArgumentException("El estado de la revisión debe ser 1 (sin problemas), 2 (con observaciones) o 3 (no aprueba).");
        }
    }

}
