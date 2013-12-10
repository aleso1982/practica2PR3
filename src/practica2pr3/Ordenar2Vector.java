package practica2pr3;

public class Ordenar2Vector implements OrdenarVector {
    
    public String nombreMetodo() {
        return "División e Intercambio, método iterativo";
    }
    
    /* # Se contabiliza una comparación, cuando en ella interviene al menos un elemento de un vector.
     * # Se considera un movimiento, cuando se asignan elementos de un vector al mismo o a otro vector.
     * # Existen métodos de ordenación que intercambian los elementos del vector para ordenarlo. Cada 
     * intercambio de dos elementos se cuenta como dos movimientos. Normalmente aparecen en el algoritmo
     * con el signo "<->".
     */    
    public void ordena(int[] v, DatosEstadisticos de){
        double time = System.currentTimeMillis();
        
        int izq = 0;
        int der = v.length-1;
        int puntPila = -1;
        int pivote, temp;
        int lsup, linf;
        int aux;
        int cuentaSup;
        int cuentaInf;
        int[] pilasup = new int[v.length];
        int[] pilainf = new int[v.length];
        boolean salir = true;
        
        do {
            if ((der-izq) > 0) {
                pivote = (izq+der)/2;
                temp = v[pivote];
                v[pivote] = v[izq];
                de.añadeMovimiento(1);
                lsup = der;
                linf = izq+1;
			
                while (linf <= lsup) {
                    cuentaSup = 0;
                    cuentaInf = 0;
                    
                    while (linf <= lsup && v[lsup] >= temp) {
                        lsup--;
                        cuentaSup++;
                    }
                    while (linf <= lsup && v[linf] <= temp) {
                        linf++;
                        cuentaInf++;
                    }
				
                    if (linf <= lsup) {
                        // Aunque no entre en el bucle igualmente ha comparado
                        // 2 veces, siempre y cuando (linf <= lsup)
				    
                        long comparacionesBucles;			    
                        comparacionesBucles = (cuentaSup == 0) ? 1 : cuentaSup;
                        comparacionesBucles += (cuentaInf == 0) ? 1 : cuentaInf;
                        de.añadeComparacion(comparacionesBucles);
                    }
				
                    if (lsup > linf) {
                        aux = v[linf];
                        v[linf] = v[lsup];
                        v[lsup] = aux;
                        lsup--;
                        linf++;
                        de.añadeMovimiento(2); // Swap
                    }
                }
			
                v[izq] = v[lsup];
                v[lsup] = temp;
                de.añadeMovimiento(2); // temp = v[pivote]
                lsup--;
                puntPila++;
			
                if ((lsup-izq) > (der-linf)) {
                    pilainf[puntPila] = izq;
                    pilasup[puntPila] = lsup;
                    izq = linf;
                } else {
                    pilainf[puntPila] = linf;
                    pilasup[puntPila] = der;
                    der = lsup; 
                }
            } else {	   
                if (izq < der) {
                    if (v[izq] > v[der]) {
                        aux = v[izq];
                        v[izq] = v[der];
                        v[der] = aux;
                        de.añadeMovimiento(2); // Swap
                    }
                    de.añadeComparacion(1);
                }
			
                if (puntPila >= 0) {
                    izq = pilainf[puntPila];
                    der = pilasup[puntPila];
                    puntPila--;
                } else {
                    salir = false;
                }
            }
        } while (salir);	
        
        de.estableceTiempo((float) (System.currentTimeMillis() - time)/1000);
    }
}