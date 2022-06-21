// codice cliente
A obj1 = new A();   // creo un oggetto di A, con nome obj1
A obj2 = new A();   // creo un altro oggetto di A
AltroEsempioDiClasse obj3 = new AltroEsempioDiClasse();
A obj4;           // variabile obj4 non inizializzata
obj4 = new A();     // ok
obj4 = new AltroEsempioDiClasse();// NO!! Errore semantico..