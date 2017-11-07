/*
 * Copyright 2012-2016 the original author or authors.
 *
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
 */
package com.cputech.appevents.model;

import com.cputech.appevents.core.AbstractAggregateRoot;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * An order.
 *
 * @author Oliver Gierke
 */
@Entity
@Table(name = "OrderT")
public class Order extends AbstractAggregateRoot {

	public Order markPaid() {
		registerEvent(new PaidEvent());
		return this;
	}
}
