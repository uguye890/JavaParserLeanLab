package com.github.uguye890;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.CompilationUnit;

public class Main {

	public static void main(String[] args) {
		
		if ( args.length != 1 ) {
			printError("Error: One arguments are required.\n"
					+ "Usage: java -jar Main.jar <targetPath>");
			System.exit(1);
		}
		
		Path inputPath = Paths.get(args[0]);
		if ( !Files.exists(inputPath) || !Files.isReadable(inputPath) ) {
			printError("Please specified a valid path");
		}
		
		try {
			CompilationUnit cu = StaticJavaParser.parse(inputPath);
            String formattedAST = cu.toString();
            System.out.println(formattedAST);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * エラーメッセージを表示
	 * 
	 * @param aMessage
	 */
	private static void printError(String aMessage) {
		System.err.println("*** Error ***");
		System.err.println(aMessage);
		System.err.println();
	}

}
