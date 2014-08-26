package org.gameoss.lang;

/**
 * An attribute that is gettable.
 * 
 * @author ebahtijaragic
 *
 * @param <R>
 */
public interface GettableAttribute<R> {
	/**
	 * Gets the attribute value.
	 * 
	 * @return
	 */
	public abstract R get();
}