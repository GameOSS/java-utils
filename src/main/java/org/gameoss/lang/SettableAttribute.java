package org.gameoss.lang;

/**
 * An attribute that is settable.
 * 
 * @author elvirb
 *
 * @param <P>
 * @param <R>
 */
public interface SettableAttribute<P, R> {
	/**
	 * Sets the attribute value and returns the parent.
	 * 
	 * @param value
	 * @return
	 */
	public abstract P set(R value);
}