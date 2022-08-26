package it.unibo.apice.oop.p22effective.enummap;

import java.util.*;
import java.util.stream.*;

public class UseEnumMap {
	
	static enum WeekDay { 
		MONDAY, TUESDAY, WEDNESDAY, THURSDAY, 
		FRIDAY, SATURDAY, SUNDAY
	} 

	public static void main(String[] args) {
		
		Map<WeekDay,List<String>> lessons = new EnumMap<>(WeekDay.class);
		lessons.put(WeekDay.TUESDAY,Arrays.asList("LAB"));
		lessons.put(WeekDay.WEDNESDAY,Arrays.asList("OOP","FIS"));
		lessons.put(WeekDay.THURSDAY,Arrays.asList("SISOP","FIS"));
		lessons.put(WeekDay.FRIDAY,Arrays.asList("SISOP","OOP"));
		
		// In quali giorni ho OOP?
		System.out.println(
				lessons.entrySet()
				       .stream()
					   .filter(e->e.getValue().contains("OOP"))
					   .map(e->e.getKey())
					   .map(Enum::name)
					   .collect(Collectors.joining(",","(",")"))
		);

	}

}
