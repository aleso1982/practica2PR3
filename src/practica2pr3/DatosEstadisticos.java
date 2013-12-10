package practica2pr3;

public class DatosEstadisticos {
    
    private long nc, nm;
    private float time;
    
    public DatosEstadisticos() {
        nc = 0;
        nm = 0;
        time = 0f;
    }
    
    public void estableceTiempo(float time) {
        this.time = time;   
    }
    
    public void añadeTiempo(float time) {
        this.time += time;
    }
    
    public float dameTiempo() {
        return time;
    }
    
    public void estableceMovimientos(long nm) {
        this.nm = nm;
    }
    
    public void añadeMovimiento(long nm) {
        this.nm += nm;
    }
    
    public long dameMovimientos() {
        return nm;
    }
    
    public void estableceComparaciones(long nc) {
        this.nc = nc;
    }
    
    public void añadeComparacion(long nc) {
        this.nc += nc;
    }
    
    public long dameComparaciones() {
        return nc;
    }
}