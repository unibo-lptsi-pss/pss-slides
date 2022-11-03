int size(){ return 0x7FFFFFFF; }
...
int[] array = new int[size()]; 
// ERRORE: out of (heap) memory 
