Collections.<Integer>emptySet().add(1);
// UnsupportedOperationException
/* ERRORE: emptySet() torna un Set immutabile
   deve essere impedita l'invocazione di add() */
