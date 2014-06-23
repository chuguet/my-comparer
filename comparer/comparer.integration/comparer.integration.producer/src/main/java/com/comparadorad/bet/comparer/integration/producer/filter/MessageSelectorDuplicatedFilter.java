package com.comparadorad.bet.comparer.integration.producer.filter;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.inject.Inject;

import org.springframework.integration.Message;
import org.springframework.integration.core.MessageSelector;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.comparadorad.bet.comparer.integration.core.beans.UpdaterBetsTO;
import com.comparadorad.bet.comparer.util.logger.core.ComparerWrapperLog;

/**
 * The Class MessageSelectorDuplicatedFilter.
 */
@Component
public class MessageSelectorDuplicatedFilter implements MessageSelector {

	/** The message send. */
	private Set<String> messageSend;

	/** The Constant LOG. */
	@Inject
	private ComparerWrapperLog LOG;

	/**
	 * Instantiates a new message selector duplicated filter.
	 */
	public MessageSelectorDuplicatedFilter() {
		messageSend = Collections.synchronizedSet(new HashSet<String>());
	}

	/** {@inheritDoc} */
	@Override
	public boolean accept(Message<?> message) {
		Boolean accept = false;

		UpdaterBetsTO msg = (UpdaterBetsTO) message.getPayload();
		if (!messageSend.contains(String.valueOf(msg.hashCode()))) {
			messageSend.add(String.valueOf(msg.hashCode()));
			accept = true;
		} 
		
		LOG.debug(Thread.currentThread(), new StringBuffer("Mensaje ")
					.append(msg).append(". Aceptado: ").append(accept).toString());


		return accept;
	}

	/**
	 * Update reference timestamp.
	 * 
	 * @param timestamp
	 *            the timestamp
	 */
	@Scheduled(fixedDelay = 600000)
	public void updateReferenceTimestamp() {
		LOG.debug(Thread.currentThread(),
				new StringBuffer(
						"Se resetea la lista de mensajes enviados. Borrando ")
						.append(messageSend.size()).append(" mensajes")
						.toString());

		messageSend.clear();
	}

}
