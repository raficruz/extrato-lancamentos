package tk.raficruz.dataextractor.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;

public class DateUtils {

  private static final String DAY_MONTH_YEAR = "dd/MM/yyyy";
  private static final String DAY_MONTH_YEAR_HOUR_MINUTES = "dd/MM/yyyy HH:mm";



  /**
   * Format - "dd/MM/yyyy"
   */
  public static LocalDate toDate(String date) {
    return toDate(date, DAY_MONTH_YEAR);
  }

  /**
   * Format - "dd/MM/yyyy HH:mm"
   */
  public static LocalDateTime toDateTime(String date) {
    return toDateTime(date, DAY_MONTH_YEAR_HOUR_MINUTES);
  }

  /**
   * Format - "dd/MM/yyyy"
   */
  public static String toString(LocalDate date) {
    return toString(date, DAY_MONTH_YEAR);
  }

  /**
   * Format - "dd/MM/yyyy HH:mm"
   */
  public static String toString(LocalDateTime date) {
    return toString(date, DAY_MONTH_YEAR_HOUR_MINUTES);
  }

  public static LocalDate toDate(String date, String parser) {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern(parser);
    LocalDate localDate = LocalDate.parse(date, formatter);
    return localDate;
  }

  public static LocalDateTime toDateTime(String date, String parser) {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern(parser);
    LocalDateTime localDate = LocalDateTime.parse(date, formatter);
    return localDate;
  }

  public static String toString(TemporalAccessor temporalAccessor, String parser) {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern(parser);
    return formatter.format(temporalAccessor);
  }

}
