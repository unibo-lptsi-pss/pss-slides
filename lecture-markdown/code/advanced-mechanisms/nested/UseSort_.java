import java.util.*;

public class UseSort {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(10,40,7,57,13,19,21,35);
		System.out.println(list);
		// classe anonima a partire da una interfaccia
		Collections.sort(list,new Comparator<Integer>(){
			public int compare(Integer a,Integer b){
				return a > b ? 1 : (a == b ? 0 : -1); //deboxing
			}
		});
		System.out.println(list);

		Collections.sort(list,new Comparator<Integer>(){
			public int compare(Integer a,Integer b){
				return a < b ? 1 : (a == b ? 0 : -1);
			}
		});
		System.out.println(list);
	}
}
