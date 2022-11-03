Object[] o = new Integer[]{1,2,3}; // OK per covarianza
o[0] = "a"; // Lancia ArrayStoreException
// per prevenire la unsafety di successive istruzioni come:
// Integer[] ar=((Integer[])o);
// int i=ar[0].intValue();
