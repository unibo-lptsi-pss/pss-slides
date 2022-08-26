package it.unibo.apice.oop.p18concurrency1;

import java.util.*;

class SortingWorker extends Thread {

	private int minIndex;
	private int maxIndex;
	private int[] data;
	
	public SortingWorker(int minIndex, int maxIndex, int[] data){
		this.minIndex = minIndex;
		this.maxIndex = maxIndex;
		this.data = data;
	}
	
	public void run(){
		log("starting "+minIndex+"-"+maxIndex);
		Arrays.sort(data,minIndex,maxIndex);
		log("done "+minIndex+"-"+maxIndex);
	}
	
	private void log(String msg){
		System.out.println(getName()+" "+msg);
	}

}

public class ConcurSortSimple {

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
		SortingWorker w1 = new SortingWorker(0,middle,v);
		SortingWorker w2 = new SortingWorker(middle,v.length,v);
		w1.start();
		w2.start();
		try {
			w1.join();
			w2.join();		
			merge(v,data,0,middle,middle,v.length);
		} catch (InterruptedException ex){}
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
