package practica2pr3;

public class ComparaMetodos {
            
    public static void main(String[] args) {
        System.out.println("Inicio de programa"); 
            
        printEstadisticas(new Ordenar2Vector());
        printEstadisticas(new Ordenar1Vector());
        
        System.out.println("\nFin de programa");
    }
    
    private static void printEstadisticas(OrdenarVector ord) {
        String header1 = "	        Vector inversamente ordenado    ";
        String header2 = "                Vector aleatorio";
        String header3 = "	     Tiempo  Comparaciones  Movimientos";
        
        System.out.printf("\nMétodo: %s\n\n", ord.nombreMetodo());
        System.out.print(header1);
        System.out.println(header2);
        System.out.print(header3);
        System.out.println(header3);
        
        int[] tamaños = new int[] {1000,2000,4000,8000,16000,32000};
        
        DatosEstadisticos[] dei = CalculadorEstadisticas.estadisticasOrdenaVectoresInversos(ord, tamaños);
        MediaDatosEstadisticos[] mdea = CalculadorEstadisticas.estadisticasOrdenaVectoresAleatorios(ord, tamaños);
        
        for (int i = 0; i < tamaños.length; i++) {
            // Inverso
            
            System.out.printf("%6d  %2.4f  %13d %12d", 
                tamaños[i],
                dei[i].dameTiempo(),
                dei[i].dameComparaciones(),
                dei[i].dameMovimientos());
                
            // Aleatorio
            
            System.out.printf("        %2.4f  %13.1f %12.1f\n", 
                mdea[i].dameMediaTiempos(),
                mdea[i].dameMediaComparaciones(),
                mdea[i].dameMediaMovimientos());
        }
    }
}
