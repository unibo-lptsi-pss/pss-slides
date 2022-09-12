class A {

    int i;

    void print(){
        System.out.println("Sono un oggetto della classe A");
        System.out.println("Il mio valore di i è: " + this.i);
    }
}

class Print {

    public static void main(String[] args) {
        A obj = new A();
        obj.i = 12;
        obj.print();
    }
}
