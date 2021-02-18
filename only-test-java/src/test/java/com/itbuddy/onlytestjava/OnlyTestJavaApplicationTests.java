package com.itbuddy.onlytestjava;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;



@SpringBootTest
class OnlyTestJavaApplicationTests {

	@Test
	void contextLoads() {
		List<Item> mapArrayList = new ArrayList<Item>();
		mapArrayList.add(new Item(1, "text"));
		mapArrayList.add(new Item(2, "text"));
		mapArrayList.add(new Item(3, "text"));
		mapArrayList.add(new Item(9, "text"));
		mapArrayList.add(new Item(8, "text"));
		mapArrayList.add(new Item(7, "text"));

		mapArrayList
		.stream()
		.forEach(System.out::println);
		
		System.out.println("\n\n\n");

		//스트림으로  sort
		List<Item> sortedmapArrayList = mapArrayList
						.stream()
						.sorted(Comparator.comparing(Item::getKey))
						.collect(Collectors.toCollection(ArrayList<Item>::new));

		sortedmapArrayList.stream().forEach(System.out::println);

	}
}

class Item{
	Integer key = null;
	String text = null;

	@Override
	public String toString() {
		return "( key : "+ key + ", text : " + text + " )";
	}
	public Integer getKey() {
		return key;
	}
	public void setKey(Integer key) {
		this.key = key;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public Item(Integer key, String text){
		this.key = key;
		this.text = text;
	}
}
