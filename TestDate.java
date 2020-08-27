import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.*;
import java.util.Date;
import java.sql.*;
import java.text.SimpleDateFormat;
public class TestDate {  
  @SuppressWarnings("deprecation")
public static void main(String[] args) {  
      
   Date dateToConvert = new Date();	  
   
  // LocalDateTime  ldt = dateToConvert.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
   
   LocalDateTime ldt8 = LocalDateTime.of(dateToConvert.getYear(),dateToConvert.getMonth(),dateToConvert.getDay(),dateToConvert.getHours(),dateToConvert.getMinutes());
   
   
   //LocalDateTime  ldt = LocalDateTime.of(Calendar.getInstance().get(Calendar.YEAR), Calendar.getInstance().get(Calendar.MONTH), Calendar.getInstance().get(Calendar.DAY_OF_MONTH),   Calendar.getInstance().get(Calendar.HOUR),   Calendar.getInstance().get(Calendar.MINUTE));   
   ZoneId zone = ZoneId.systemDefault(); 
    
   ZonedDateTime zone1  = ZonedDateTime.of(ldt8, zone);
    
   System.out.println(ldt8);
    //System.out.print(Timestamp(
     // dateToConvert.getTime()).toLocalDateTime());
    //System.out.print(Date.from(zone1.toInstant()));
    
    //System.out.println(zone1);  
    
    //System.out.println(Instant.ofEpochMilli(dateToConvert.getTime())
    //.atZone(ZoneId.systemDefault())
    //.toLocalDateTime());
    
    DateTimeFormatter formatter = DateTimeFormatter.ISO_OFFSET_DATE_TIME;

    String formattedZonedDate = formatter.format(zone1);
    System.out.println("formattedZonedDate = " + formattedZonedDate);
    
    //LocalDateTime aLDT = LocalDateTime.parse(formattedZonedDate);
    
    
   // DateTime dateTimeWithZone = dateTime.withZone(DateTimeZone.forID("Asia/Kolkata"));
    
    //System.out.print(aLDT);
    
    
    //System.out.println(dateToConvert.toInstant()
   // .atZone(ZoneId.systemDefault())
   // .toLocalDateTime());
  System.out.println("-----------------------");
  
  Date today = new Date(); 
  
  today.getYear();
  //toda
  //LocalDateTime ldt1 = LocalDateTime.ofInstant(today.toInstant(), ZoneId.systemDefault());
  
  //System.out.println(ldt1);

 
    
  Instant instant = Instant.ofEpochMilli(today.getTime());
  LocalDateTime ldt3 = LocalDateTime.ofInstant(instant, ZoneOffset.UTC);
  
  System.out.println(ldt3);
  
  ZonedDateTime zone11  = ZonedDateTime.of(ldt3, zone);
  
  DateTimeFormatter formatter1 = DateTimeFormatter.ISO_OFFSET_DATE_TIME;

  String formattedZonedDate1 = formatter1.format(zone11);
  System.out.println("formattedZonedDate = " + formattedZonedDate1);
  
  
    
    
    System.out.println("rrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrr");
    
    String pattern = "yyyy-MM-dd'T'HH:mm:ssXXX";
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
    String date = simpleDateFormat.format(new Date());
    System.out.println(date);
    
   
  }       
}  