A obj = new A();
int v = obj.i;               // vale 0
obj.aggiungi(10);            // modifico obj
obj.aggiungi(20);            // modifico obj
int v2 = obj.i;              // vale 30
int v3 = obj.restituisciValore();  // vale 30