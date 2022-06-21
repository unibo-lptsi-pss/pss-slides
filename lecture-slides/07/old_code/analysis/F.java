class F extends E{
    void n(){
        this.i = this.i+100;
    }
    public static void main(String[] s){
        F f=new F();
        f.i=10;
        f.m();
        System.out.println(""+f.i);
    }
}
