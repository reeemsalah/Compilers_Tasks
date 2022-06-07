// Generated from D:/University/Semester10/CSEN 1002/Lab9/src/csen1002/main/assignment2\Assignment2.g4 by ANTLR 4.10.1
package csen1002.main.assignment2;
import org.antlr.v4.runtime.tree.AbstractParseTreeVisitor;

/**
 * This class provides an empty implementation of {@link Assignment2Visitor},
 * which can be extended to create a visitor which only needs to handle a subset
 * of the available methods.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public class Assignment2BaseVisitor<T> extends AbstractParseTreeVisitor<T> implements Assignment2Visitor<T> {
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitS(Assignment2Parser.SContext ctx) { return visitChildren(ctx); }
}