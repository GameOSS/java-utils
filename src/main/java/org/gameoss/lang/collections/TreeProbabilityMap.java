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

import java.util.Map.Entry;
import java.util.TreeMap;

/**
 * A probability map using a tree.
 * 
 * NOTE: Puts are not thread safe. Gets are not thread-safe if the collection is being modified.
 * 
 * @author elvirb
 *
 * @param <T>
 */
public class TreeProbabilityMap<T> implements ProbabiltyMap<T> {
	private TreeMap<Float, T> map;

	public float weightTotal;
	
	public TreeProbabilityMap() {
		this.map = new TreeMap<Float, T>();
		this.weightTotal = 0;
	}

	@Override
	public T get(float randomNumber) throws IllegalStateException, IllegalArgumentException {
		if (randomNumber < 0f || randomNumber > 1f) {
			throw new IllegalArgumentException("The 'randomNumber' argument must be between 0f and 1f.");
		}
		
		// retrieve from tree
		Entry<Float, T> entry = map.floorEntry(randomNumber * weightTotal);
		
		return entry != null ? entry.getValue() : null;
	}

	@Override
	public void put(float weight, T element) throws IllegalArgumentException {
		if (weight <= 0f) {
			throw new IllegalArgumentException("The 'weight' must be greater then 0.");
		}
		
		// place in tree
		map.put(weightTotal, element);
		
		weightTotal += weight;
	}
}
