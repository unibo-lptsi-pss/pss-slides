class A {
  int i;
  void aggiungi(int a){ 
    this.i = this.i + a;    // this.i: il "mio" campo i
  }
  int restituisciValore(){    
    return this.i;           
  }
  int get(){		// Un alias per restituisciValore
    return this.restituisciValore();
  }
}