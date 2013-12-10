package practica2pr3;

public class CalculadorEstadisticas {

    public static DatosEstadisticos estadisticaOrdenaVector(OrdenarVector m, int tam_vector, int modo) {
        DatosEstadisticos de = new DatosEstadisticos();
        boolean type = (modo == 1)?true:false;
        
        int[] array_v = GeneraCaso.generaVector(tam_vector, type);
        m.ordena(array_v, de);
        CompruebaCaso.compruebaVector(array_v, tam_vector);
        
        return de;   
    }

    public static MediaDatosEstadisticos estadisticaOrdenaVectorAleatorio(OrdenarVector m, int tam_vector) {
        MediaDatosEstadisticos mde = new MediaDatosEstadisticos();
        
        for (int i=0; i<10; i++){
            int[] array_v = GeneraCaso.generaVector(tam_vector, true);
            DatosEstadisticos aux = new DatosEstadisticos();
            m.ordena(array_v, aux);
            CompruebaCaso.compruebaVector(array_v, tam_vector);
            mde.añadeDatosEstadisticos(aux);
        }
        
        return mde;
    }

    public static DatosEstadisticos[] estadisticasOrdenaVectoresInversos(OrdenarVector m, int[] tam_vectores) {
        DatosEstadisticos[] aux = new DatosEstadisticos[tam_vectores.length];
        
        for(int i = 0; i<tam_vectores.length; i++)
            aux[i] = estadisticaOrdenaVector(m, tam_vectores[i], 0);
        
        return aux;
    }
    
    public static MediaDatosEstadisticos[] estadisticasOrdenaVectoresAleatorios(OrdenarVector m, int[] tam_vectores) {
        MediaDatosEstadisticos[] aux = new MediaDatosEstadisticos[tam_vectores.length];
        
        for(int i = 0; i<tam_vectores.length; i++)
            aux[i] = estadisticaOrdenaVectorAleatorio(m, tam_vectores[i]);
        
        return aux;
    }
}