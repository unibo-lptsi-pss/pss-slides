/* Conto su un array, con Contatore passato in input */
static void countInArray(int[] array,int elem,Counter c){
    for (int i: array){
    	if (i==elem){
    	    c.increment();
    	}
    }
}

/* Conto su una matrice, riusando appieno la countInArray */
static void countInMatrix(int[][] matrix,int elem,Counter c){
    for (int[] array: matrix){
    	countInArray(array,elem,c);
    }
}

