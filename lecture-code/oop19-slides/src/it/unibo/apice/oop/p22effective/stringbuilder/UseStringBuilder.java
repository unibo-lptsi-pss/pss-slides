package it.unibo.apice.oop.p22effective.stringbuilder;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class UseStringBuilder {
    
    private static double duration(Runnable r, int iterations){
        long l = System.currentTimeMillis();
        IntStream.range(0,iterations).forEach(i->r.run());
        return (System.currentTimeMillis()-l)/(double)iterations;
    }
    
    private static final String str = "aaa";
    private static final int nconc = 20;
    
    public static void main(String[] args){
        final List<Runnable> tasks = Arrays.<Runnable>asList(
                () -> {String s = ""; for (int i=0;i<nconc;i++) s+=str; },
                () -> {StringBuilder b = new StringBuilder(); for (int i=0;i<nconc;i++) b.append(str);b.toString(); },
                () -> {StringBuffer b = new StringBuffer(); for (int i=0;i<nconc;i++) b.append(str);b.toString(); }      );
        tasks.forEach(t->System.out.println(duration(t,10000000)));
    }

}
