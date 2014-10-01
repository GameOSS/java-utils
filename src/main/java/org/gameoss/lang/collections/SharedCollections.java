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
 * A helper class for the shared collections library.
 * 
 * @author Elvir Bahtijaragic
 */
public final class SharedCollections {
	private SharedCollections() {}

	/**
	 * Returns a unmodifiable {@link ProbabiltyMap}
	 * 
	 * @param original
	 * @return
	 */
	public static <T> ProbabiltyMap<T> unmodifiableProbabilityMap(ProbabiltyMap<T> original) {
		return new UnmodifiableProbabiltyMapWrapper<T>(original);
	}
	
	/**
	 * Returns a synchronized {@link ProbabiltyMap}
	 * 
	 * @param original
	 * @return
	 */
	public static <T> ProbabiltyMap<T> synchronizedProbabilityMap(ProbabiltyMap<T> original) {
		return new SynchronizedProbabiltyMapWrapper<T>(original);
	}
	
	/**
	 * A wrapper around a {@link ProbabiltyMap} that throws a {@link UnsupportedOperationException} when someone tries to call the put method.
	 * 
	 * @author elvir.bahtijaragic
	 *
	 * @param <T>
	 */
	private static class UnmodifiableProbabiltyMapWrapper<T> implements ProbabiltyMap<T> {
		private final ProbabiltyMap<T> wrappedMap;
		
		/**
		 * @param wrappedMap
		 */
		public UnmodifiableProbabiltyMapWrapper(ProbabiltyMap<T> wrappedMap) {
			this.wrappedMap = wrappedMap;
		}

		@Override
		public T get(float randomNumber) throws IllegalStateException, IllegalArgumentException {
			return wrappedMap.get(randomNumber);
		}

		@Override
		public void put(float weight, T element) throws IllegalArgumentException {
			throw new UnsupportedOperationException("This ProbabiltyMap cannot be modified.");
		}
	}
	
	/**
	 * A synchronized wrapper around a {@link ProbabiltyMap}.
	 * 
	 * @author elvir.bahtijaragic
	 *
	 * @param <T>
	 */
	private static class SynchronizedProbabiltyMapWrapper<T> implements ProbabiltyMap<T> {
		private final ProbabiltyMap<T> wrappedMap;
		
		/**
		 * @param wrappedMap
		 */
		public SynchronizedProbabiltyMapWrapper(ProbabiltyMap<T> wrappedMap) {
			this.wrappedMap = wrappedMap;
		}

		@Override
		public T get(float randomNumber) throws IllegalStateException, IllegalArgumentException {
			synchronized(this) {
				return wrappedMap.get(randomNumber);
			}
		}

		@Override
		public void put(float weight, T element) throws IllegalArgumentException {
			synchronized(this) {
				wrappedMap.put(weight, element);
			}
		}
	}
}
