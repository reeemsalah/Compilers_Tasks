// Generated from D:/University/Semester10/CSEN 1002/Lab9/src/csen1002/main/assignment2\Assignment2.g4 by ANTLR 4.10.1
package csen1002.main.assignment2;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link Assignment2Parser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface Assignment2Visitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link Assignment2Parser#s}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitS(Assignment2Parser.SContext ctx);
}