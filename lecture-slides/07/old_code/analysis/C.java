class C{
    protected int i;
    void m(){
        System.out.println("C.m.. prima "+i);
        this.i++;
        System.out.println("C.m.. dopo "+i);
    }
}
