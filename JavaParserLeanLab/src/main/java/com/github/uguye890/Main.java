package com.github.uguye890;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.comments.Comment;

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
//            String formattedAST = cu.toString();
//            System.out.println(formattedAST);
            printAST(cu, 0);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static void printAST(Node node, int indentLevel) {
		String indent = " ".repeat(indentLevel * 4);
		String className = node.getClass().getSimpleName();
		
		if (node.getChildNodes().isEmpty()) {
			String name = node.toString();
			int begin = node.getBegin().get().column;
			// コメントノードを表示
			if (!node.getComment().isEmpty()) {
	            System.out.println(indent + className + " | Comment: " + node.getComment().get().getContent());
	        }
			else {
				System.out.println(indent + className + " : " + begin + " : " + name);
			}
		}
		else {
			// コメントノードを表示
	        if (!node.getComment().isEmpty()) {
	            System.out.println(indent + className + " | Comment: " + node.getComment().get().getClass().getSimpleName());
	        }
	        else {
	        	System.out.println(indent + className);
	        }
			// 子ノードを再帰的に表示
			for (Node child: node.getChildNodes()) {
				printAST(child, indentLevel + 1);
			}
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
