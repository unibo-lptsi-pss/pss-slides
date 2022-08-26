int mysize(List<?> l){ return l.size(); }
...
int n=mysize(null); 
// ERRORE: invocazione metodo size() su null 
