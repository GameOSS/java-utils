package org.gameoss.lang.collections;

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
 * A map that randomly retrieves an element based on its probability.
 * 
 * The weight can be any floating point value.
 * 
 * @author Elvir Bahtijaragic
 *
 * @param <T>
 */
public interface ProbabiltyMap<T> {
	/**
	 * Gets a random element based on the current probabilities.
	 * 
	 * @param randomNumber a random number (between 0f and 1f)
	 * @return
	 */
	public T get(float randomNumber) throws IllegalStateException, IllegalArgumentException;
	
	/**
	 * Places an item in a collection based on its probability.
	 * 
	 * @param weight the weight of the element (a value greater then 0f)
	 * @param element the element to add for the above probability
	 */
	public void put(float weight, T element) throws IllegalArgumentException;
}
