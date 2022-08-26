int f(int i){ return i==0 ? 0 : f(i+1); }
...
int n=f(1); 
// ERRORE: out of (stack) memory 
