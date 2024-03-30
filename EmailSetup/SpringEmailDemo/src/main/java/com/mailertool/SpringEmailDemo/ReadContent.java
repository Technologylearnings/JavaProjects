package com.mailertool.SpringEmailDemo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReadContent {
	String file="src\\wiki.txt";
	@GetMapping("/read")
	public void readContent() throws IOException
	{
		Files.lines(Paths.get(file)).map(str->str.split(" "))
		.flatMap(Arrays::stream).distinct().sorted()
		.forEach(System.out::println);
	}
}
