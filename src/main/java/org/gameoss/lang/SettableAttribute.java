package org.gameoss.lang;

/*
 * #%L
 * Utils
 * %%
 * Copyright (C) 2014 GameOSS
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

/**
 * A reference holding object that returns a parent for every set.
 * 
 * @author ebahtijaragic
 */
public class SettableAttribute<P, R> {
	private P parent;
	private R value;
	
	/**
	 * Creates an attribute with a parent.
	 * 
	 * @param parent
	 */
	public SettableAttribute(P parent) {
		this.parent = parent;
	}
	
	/**
	 * Creates an attribute with a parent and an initial value.
	 * 
	 * @param parent
	 * @param initialValue
	 */
	public SettableAttribute(P parent, R initialValue) {
		this.parent = parent;
		this.value = initialValue;
	}
	
	/**
	 * Sets the attribute value and returns the parent.
	 * 
	 * @param value
	 * @return
	 */
	public P set(R value) {
		this.value = value;
		
		return parent;
	}

	/**
	 * Gets the attribute value.
	 * 
	 * @return
	 */
	public R get() {
		return this.value;
	}
}
