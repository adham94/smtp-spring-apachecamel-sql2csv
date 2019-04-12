package com.tmim.sba.extractcsi.processor;

import javax.activation.DataHandler;
import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.Processor;
import org.springframework.beans.factory.annotation.Value;

public class EmailAttachmentProcessor
  implements Processor
{
  @Value("${APP.CAMEL_CONTEXT.ROUTE2_MAIL_BODYMSG}")
  private String emailBodyMsg;
  
  public EmailAttachmentProcessor() {}
  
  public void process(Exchange exchange)
    throws Exception
  {
    Message in = exchange.getIn();
    byte[] file = (byte[])in.getBody(byte[].class);
    String fileId = (String)in.getHeader("CamelFileName", String.class);
    in.addAttachment(fileId, new DataHandler(file, "plain/text"));
    
    exchange.getIn().setBody(emailBodyMsg);
  }
}