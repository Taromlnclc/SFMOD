import java.util.Date;
public class Administrativo extends Usuario {
    private String area;
    private String experienciaPrevia;

    public Administrativo(String nombre, String fechaNacimiento, int rut, String area, String experienciaPrevia) {
        super(nombre, fechaNacimiento, rut);
        setArea(area);
        setExperienciaPrevia(experienciaPrevia);
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        if (area == null || area.trim().length() < 5 || area.trim().length() > 20) {
            throw new IllegalArgumentException("Area deben tener al menos 5 caracteres y máximo 20 caracteres");
        }
        this.area = area;
    }

    public String getExperienciaPrevia() {
        return experienciaPrevia;
    }

    public void setExperienciaPrevia(String experienciaPrevia) {
        if (experienciaPrevia.trim().length() > 100) {
            throw new IllegalArgumentException("Experiencia Previa debe tener máximo 100 caracteres");
        }
        this.experienciaPrevia = experienciaPrevia;
    }
}
