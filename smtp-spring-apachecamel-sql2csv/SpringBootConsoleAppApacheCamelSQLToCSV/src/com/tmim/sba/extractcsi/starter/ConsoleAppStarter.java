package com.tmim.sba.extractcsi.starter;

import org.apache.camel.CamelContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource({"classpath:spring-appcontext-dir/appcontext-root.xml"})
public class ConsoleAppStarter
  implements CommandLineRunner
{
  static final Logger LOGGER = LoggerFactory.getLogger(ConsoleAppStarter.class);
  
  @Value("${APP.GENERIC.APPNAME}")
  private String genericAppName;
  @Value("${APP.GENERIC.ENVNAME}")
  private String genericEnvName;
  @Value("${APP.JDBC.CONNECTION_STR}")
  private String jdbcConnectionStr;
  @Value("${APP.CAMEL_CONTEXT.THREAD_WAIT_MILIS}")
  private int threadWaitMilis;
  @Autowired
  private CamelContext camelContext;
  
  public ConsoleAppStarter() {}
  
  public static void main(String[] args)
    throws Exception
  {
    SpringApplication.run(ConsoleAppStarter.class, args);
  }
  




  public void run(String... args)
    throws Exception
  {
    LOGGER.info("===========================================");
    LOGGER.info("APPNAME\t\t\t\t\t:{}", genericAppName);
    LOGGER.info("ENVNAME\t\t\t\t\t:{}", genericEnvName);
    LOGGER.info("JDBC.CONNECTION_STR\t\t\t\t:{}", jdbcConnectionStr);
    LOGGER.info("CAMEL_CONTEXT.THREAD_WAIT_MILIS\t\t:{}", Integer.valueOf(threadWaitMilis));
    try
    {
      camelContext.start();
      Thread.sleep(threadWaitMilis);
      
      camelContext.stop();
      LOGGER.info("*** Camel Context Completed & Closed. ***");
      LOGGER.info("===========================================");
    }
    finally
    {
      camelContext.stop();
      LOGGER.info("*** Camel Context Completed & Closed. ***");
      LOGGER.info("===========================================");
    }
  }
}
