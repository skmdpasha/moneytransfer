package com.revolut.moneytransfer.main;

import com.revolut.moneytransfer.dao.DAOFactory;
import com.revolut.moneytransfer.service.AccountService;
import com.revolut.moneytransfer.service.ServiceExceptionMapper;
import com.revolut.moneytransfer.service.TransactionService;
import com.revolut.moneytransfer.service.UserService;

import org.apache.log4j.Logger;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.jersey.servlet.ServletContainer;

/**
 * Main Class (Starting point) 
 */
public class ApplicationStartServiceMain {

	private static Logger log = Logger.getLogger(ApplicationStartServiceMain.class);

	public static void main(String[] args) throws Exception {
		// Initialize H2 database with demo data
		log.info("Initialize demo .....");
		DAOFactory h2DaoFactory = DAOFactory.getDAOFactory(DAOFactory.H2);
		h2DaoFactory.populateTestData();
		log.info("Initialisation Complete....");
		// Host service on jetty
		startService();
	}

	private static void startService() throws Exception {
		Server server = new Server(8080);
		ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
		context.setContextPath("/");
		server.setHandler(context);
		ServletHolder servletHolder = context.addServlet(ServletContainer.class, "/*");
		servletHolder.setInitParameter("jersey.config.server.provider.classnames",
				UserService.class.getCanonicalName() + "," + AccountService.class.getCanonicalName() + ","
						+ ServiceExceptionMapper.class.getCanonicalName() + ","
						+ TransactionService.class.getCanonicalName());
		try {
			server.start();
			server.join();
		} finally {
			server.destroy();
		}
	}
}
