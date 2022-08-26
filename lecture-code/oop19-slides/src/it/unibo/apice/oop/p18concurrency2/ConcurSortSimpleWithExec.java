package it.unibo.apice.oop.p18concurrency2;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ConcurSortSimpleWithExec {

	static final Random gen = new Random(10000);
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		long t0,t1;		
		System.out.println("Generating array...");
		int[] v = genArray(n);
		log("Array generated.");
		t0 = System.nanoTime();
		sortPar(v);
		t1 = System.nanoTime();
		log("Time elapsed: "+((t1-t0)/1000000)+" ms");
		if (check(v)){
			log("SORTING OK.");
		} else {
			log("SORTING NOT OK.");
		}
	}
	
	private static boolean check(int[] v){
		double a = v[0];
		for (int i = 1; i < v.length; i++){
			if (a > v[i]){
				return false;
			}
			a = v[i];
		}
		return true;
	}
	
	private static int[] genArray(int n){
		int v[] = new int[n];
		for (int i = 0; i < v.length; i++){
			v[i] = gen.nextInt();
		}
		return v;
	}

	private static void sortPar(int[] data){
		int[] v = Arrays.copyOf(data, data.length);
		int middle = v.length / 2;
		
		int threadPoolSize = Runtime.getRuntime().availableProcessors() + 1;
		ExecutorService exec = Executors.newFixedThreadPool(threadPoolSize);
		exec.execute(() -> {
			Arrays.sort(v, 0, middle);
		});
		exec.execute(() -> {
			Arrays.sort(v, middle, v.length);
		});
		exec.shutdown();
		try {
			exec.awaitTermination(Long.MAX_VALUE, TimeUnit.SECONDS);
			merge(v,data,0,middle,middle,v.length);
		} catch (InterruptedException ex){
			ex.printStackTrace();
		}
	}
	
	private static void merge(int[] source, int[] dest, int from1, int to1, int from2, int to2){
		int index1 = from1;
		int index2 = from2;
		int i = 0;
		while (index1 < to1 && index2 < to2){
			int a = source[index1];
			int b = source[index2];
			if (a < b){
				dest[i] = a;
				index1++;
			} else {
				dest[i] = b;
				index2++;
			}
			i++;
		}
		for (int j = index1; j < to1; j++){
			dest[i++] = source[j];
		}
		for (int j = index2; j < to2; j++){
			dest[i++] = source[j];
		}
		
	}
	
	private static void log(String msg){
		System.out.println(msg);
	}
}
