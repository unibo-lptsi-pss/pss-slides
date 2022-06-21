interface I {
    void m();
}

class C1 implememts I {
    void m(){ System.out.println("I'm istance of C1");}
}

class C2 implememts I {
    void m(){ System.out.println("I'm istance of C2");}
    static void m2(){ System.out.println("I'm a static method of C2");} 
}

// Codice cliente

I i = Math.random() > 0.5 ? new C1() : new C2();
i.m(); // collegamento al body da eseguire è late, ossia dinamico

C2.m2(); // collegamento al body da eseguire è early, ossia statico


