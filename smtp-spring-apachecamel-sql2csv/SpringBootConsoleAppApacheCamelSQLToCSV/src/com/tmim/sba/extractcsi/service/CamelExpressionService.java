package com.tmim.sba.extractcsi.service;

import java.util.Date;
import org.apache.commons.lang3.time.FastDateFormat;
import org.springframework.beans.factory.annotation.Value;

@org.springframework.stereotype.Service
public class CamelExpressionService
{
  @Value("${APP.CSV_FILENAME_PREFIX}")
  private String csvFilenamePrefix;
  @Value("${APP.CSV_FILENAME_SUFFIX}")
  private String csvFilenameSuffix;
  
  public CamelExpressionService() {}
  
  private final FastDateFormat CSV_DATE_FORMAT = FastDateFormat.getInstance("yyyyMMdd-HHmmss");
  private final Date CURRENT_DT = new Date();
  
  public String getCsvFilename() {
    return csvFilenamePrefix + CSV_DATE_FORMAT.format(CURRENT_DT) + "." + csvFilenameSuffix;
  }
}