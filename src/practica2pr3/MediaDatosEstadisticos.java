package practica2pr3;

public class MediaDatosEstadisticos {
    
    private float mediaTiempo;
    private float mediaComparaciones;
    private float mediaMovimientos;
    private long numDatos;
    
    public MediaDatosEstadisticos() {
        mediaTiempo = 0f;
        mediaComparaciones = 0f;
        mediaMovimientos = 0f;    
        numDatos = 0;
    }
    
    public void añadeDatosEstadisticos(DatosEstadisticos de) {
        numDatos++;
        mediaTiempo += de.dameTiempo();
        mediaComparaciones += de.dameComparaciones();
        mediaMovimientos += de.dameMovimientos();
    }
    
    public float dameMediaTiempos() {
        return mediaTiempo / numDatos;
    }
    
    public float dameMediaComparaciones() {
        return mediaComparaciones / numDatos;
    }
    
    public float dameMediaMovimientos() {
        return mediaMovimientos / numDatos;
    }
    
}
