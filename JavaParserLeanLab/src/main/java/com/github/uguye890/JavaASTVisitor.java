package com.github.uguye890;

import com.github.javaparser.ast.Node;

public class JavaASTVisitor {
	Node node = null;
	
	public JavaASTVisitor(Node aNode) {
		this.node = aNode;
	}
	
	public void printAST(Node node, int indentLevel) {
		String indent = " ".repeat(indentLevel * 2);
		System.out.println(indent + node.getClass().getSimpleName());
		
		// 子ノードを再帰的に表示
		for (Node child: node.getChildNodes()) {
			printAST(child, indentLevel + 1);
		}
	}
}
