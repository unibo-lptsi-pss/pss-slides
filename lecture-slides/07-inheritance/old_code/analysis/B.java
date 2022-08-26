class B extends A{
    protected String s;
    public B(String s,int i){
        super(i);
        System.out.println("B().. prima "+this.s+" "+this.i);
        this.s=s;
        System.out.println("B().. dopo "+this.s+" "+this.i);
    }
    public static void main(String[] s){
        B b=new B("prova",5); // Cosa succede?
    }
}
