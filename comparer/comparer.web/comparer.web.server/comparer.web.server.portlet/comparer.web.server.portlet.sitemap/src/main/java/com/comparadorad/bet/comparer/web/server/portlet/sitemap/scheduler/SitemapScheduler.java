package com.comparadorad.bet.comparer.web.server.portlet.sitemap.scheduler;

import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.messaging.MessageListener;
import com.liferay.portal.kernel.messaging.MessageListenerException;


public class SitemapScheduler extends SitemapController implements MessageListener {

	
	
	
	@Override
	public void receive(Message message) throws MessageListenerException {
		//incluir aqui el codigo del controlador en caso de configurar esto 
		//como un cron

	}

}
