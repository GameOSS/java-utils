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
 * @author elvirb
 */
public class Attribute<P, R> implements SettableAttribute<P, R>, GettableAttribute<R> {
	private P parent;
	private R value;
	
	/**
	 * Creates an attribute with a parent.
	 * 
	 * @param parent
	 */
	public Attribute(P parent) {
		this.parent = parent;
	}
	
	/**
	 * Creates an attribute with a parent and an initial value.
	 * 
	 * @param parent
	 * @param initialValue
	 */
	public Attribute(P parent, R initialValue) {
		this.parent = parent;
		this.value = initialValue;
	}
	
	/**
	 * @see org.gameoss.lang.SettableAttribute#set(R)
	 */
	public P set(R value) {
		this.value = value;
		
		return parent;
	}

	/**
	 * @see org.gameoss.lang.GettableAttribute#get()
	 */
	public R get() {
		return this.value;
	}
	
	/**
	 * Gettable attribute with parent.
	 * 
	 * @param parent
	 * @return
	 */
	public static <P, R> GettableAttribute<R> gettable(P parent) {
		return new Attribute<P, R>(parent);
	}

	/**
	 * Gettable attribute with parent and initial value.
	 * 
	 * @param parent
	 * @param initialValue
	 * @return
	 */
	public static <P, R> GettableAttribute<R> gettable(P parent, R initialValue) {
		return new Attribute<P, R>(parent, initialValue);
	}
	
	/**
	 * Settable attribute with parent.
	 * 
	 * @param parent
	 * @return
	 */
	public static <P, R> SettableAttribute<P, R> settable(P parent) {
		return new Attribute<P, R>(parent);
	}
	
	/**
	 * Settable attribute with parent and initial value.
	 * 
	 * @param parent
	 * @param initialValue
	 * @return
	 */
	public static <P, R> SettableAttribute<P, R> settable(P parent, R initialValue) {
		return new Attribute<P, R>(parent, initialValue);
	}

	/**
	 * Default settable and gettable attribute with parent.
	 * 
	 * @param parent
	 * @return
	 */
	public static <P, R> Attribute<P, R> create(P parent) {
		return new Attribute<P, R>(parent);
	}
	
	/**
	 * Default settable and gettable attribute with parent and initial value.
	 * 
	 * @param parent
	 * @param initialValue
	 * @return
	 */
	public static <P, R> Attribute<P, R> create(P parent, R initialValue) {
		return new Attribute<P, R>(parent, initialValue);
	}
}
