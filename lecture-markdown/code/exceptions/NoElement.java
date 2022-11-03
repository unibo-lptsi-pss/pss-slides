Iterator<Integer> i = Arrays.asList(1,2).iterator();
i.next(); 
i.next();
i.next(); // NoSuchElementException
/* ERRORE: il contratto d'uso degli Iterator prevede di non
   invocare next() se hasNext() dà false */

