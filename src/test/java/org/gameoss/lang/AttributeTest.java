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

import org.junit.Assert;
import org.junit.Test;

/**
 * Tests the {@link Attribute}
 * 
 * @author ebahtijaragic
 */
public class AttributeTest {
	private class SampleBuilder {
		public final Attribute<SampleBuilder, String> sampleInitializedString = new Attribute<SampleBuilder, String>(this, "InitialValue");

		public final Attribute<SampleBuilder, String> sampleUninitializedString = new Attribute<SampleBuilder, String>(this);
	}
	
	@Test
	public void testSetAndGet() {
		Assert.assertEquals("SomeValue", 
				new SampleBuilder()
					.sampleInitializedString.set("SomeValue")
					.sampleInitializedString.get());
	}
	
	@Test
	public void testInitialValueAndGet() {
		Assert.assertEquals("InitialValue", 
				new SampleBuilder()
					.sampleInitializedString.get());
	}

	@Test
	public void testUninitializedStringAndGet() {
		Assert.assertNull(
				new SampleBuilder()
					.sampleUninitializedString.get());
	}
}
