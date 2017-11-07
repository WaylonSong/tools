package com.cputech.appevents.core;

import lombok.Getter;
import lombok.extern.log4j.Log4j;
import org.springframework.data.domain.AfterDomainEventPublication;
import org.springframework.data.domain.DomainEvents;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;
//重写domain中的类,主要是加了id和version
@Log4j
public class AbstractAggregateRoot extends AbstractEntity {

	/**
	 * All domain events currently captured by the aggregate.
	 */
	@Getter(onMethod = @__(@DomainEvents)) //
	private transient final List<Object> domainEvents = new ArrayList<>();

	/**
	 * Registers the given event object for publication on a call to a Spring Data repository's save method.
	 * 
	 * @param event must not be {@literal null}.
	 * @return
	 */
	protected <T> T registerEvent(T event) {

		Assert.notNull(event, "Domain event must not be null!");

		this.domainEvents.add(event);
		return event;
	}

	/**
	 * Clears all domain events currently held. Usually invoked by the infrastructure in place in Spring Data
	 * repositories.
	 */
	@AfterDomainEventPublication
	public void clearDomainEvents() {
		LOG.info("AfterDomainEventPublication "+domainEvents.size());
		this.domainEvents.clear();
	}
}
