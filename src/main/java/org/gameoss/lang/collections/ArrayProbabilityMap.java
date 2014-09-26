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

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * A probability map using arrays.
 * 
 * NOTE: Puts are not thread safe. Gets are not thread-safe if the collection is being modified.
 * 
 * @author elvirb
 *
 * @param <T>
 */
public class ArrayProbabilityMap<T> implements ProbabiltyMap<T> {
	public final Map<Integer, List<ProbabilityNode<T>>> map;
	
	public float weightTotal;
	
	public ArrayProbabilityMap() {
		this(Runtime.getRuntime().availableProcessors() * 0.75f);
	}
	
	public ArrayProbabilityMap(float loadFactor) {
		this.map = new HashMap<Integer, List<ProbabilityNode<T>>>(16, loadFactor);
		this.weightTotal = 0f;
	}
	
	@Override
	public T get(float randomNumber) throws IllegalStateException {
		if (randomNumber < 0f || randomNumber > 1f) {
			throw new IllegalArgumentException("The 'randomNumber' argument must be between 0f and 1f.");
		}

		// find the bucket
		float value = randomNumber * weightTotal;
		int key = (int)Math.floor(value);
		
		List<ProbabilityNode<T>> nodes = map.get(key);
		
		// find the node
		ProbabilityNode<T> previousNode = null;
		ProbabilityNode<T> selectedNode = null;
		
		if (nodes != null) {
			for (ProbabilityNode<T> node : nodes) {
				if (value >= node.startingProbability && value < node.endingProbability) {
					selectedNode = node;
					break;
				}
				
				previousNode = node;
			}
		}
		
		return selectedNode != null ? selectedNode.value : (previousNode != null ? previousNode.value : null);
	}

	@Override
	public void put(float weight, T element) {
		if (weight <= 0f) {
			throw new IllegalArgumentException("The 'weight' must be greater then 0.");
		}
		
		// compute the buckets for this element
		float startingProbability = weightTotal;

		weightTotal += weight;
		
		float endingProbability = weightTotal;
		
		int startingKey = (int)Math.floor(startingProbability);
		int endingKey = (int)Math.floor(endingProbability);
		
		// create the node
		ProbabilityNode<T> node = new ProbabilityNode<T>(element, startingProbability, endingProbability);
		
		// add node to buckets
		for (int i = startingKey; i <= endingKey; i++) {
			List<ProbabilityNode<T>> nodes = map.get(i);
			
			if (nodes == null) {
				nodes = new LinkedList<ProbabilityNode<T>>();
				map.put(i, nodes);
			}
			
			nodes.add(node);
		}
	}
	
	private static class ProbabilityNode<T> {
		private final T value;
		private final float startingProbability;
		private final float endingProbability;
		
		/**
		 * @param value
		 * @param startingProbability
		 * @param endingProbability
		 */
		public ProbabilityNode(T value, float startingProbability,
				float endingProbability) {
			this.value = value;
			this.startingProbability = startingProbability;
			this.endingProbability = endingProbability;
		}
	}
}
