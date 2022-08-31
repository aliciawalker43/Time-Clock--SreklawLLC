package SReklaw.demo;


import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "time_card")
public class TimeCard {
	
	@Id@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String start;
	private String end;
	private String duty;
	private String hours;
	
	
	
	
	@Override
	public String toString() {
		return "TimeCard [id=" + id + ", start=" + start + ", end=" + end + ", duty=" + duty + ", hours=" + hours + "]";
	}



	public TimeCard() {
		super();
	}


	
	public TimeCard(Long id, String start, String end, String duty, Long hours) {
		super();
		this.id = id;
		this.start = start;
		this.end = end;
		this.duty = duty;
		//this.hours = hours;
	}







	public Long getId() {
		return id;
	}







	public void setId(Long id) {
		this.id = id;
	}







	public String getStart() {
		return start;
	}







	public void setStart(String start) {
		this.start = start;
	}







	public String getEnd() {
		return end;
	}







	public void setEnd(String end) {
		this.end = end;
	}







	public String getDuty() {
		return duty;
	}







	public void setDuty(String duty) {
		this.duty = duty;
	}




	public String getHours() {
		return hours;
	}



	public void setHours(String hours) {
		this.hours = hours;
	}


	
	
	//Methods
public static String formatDate(LocalDateTime myObj) {
		
	DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	String formattedDate = myObj.format(myFormatObj);
		return formattedDate;
	}
	

	public static LocalDateTime formatStringToDate(String dateTime) {
		
		LocalDateTime date = LocalDateTime.parse(dateTime, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
		
		return date;
	}
	

	public String getHours(String start, String end) {
	
		
		LocalDateTime startTime = LocalDateTime.parse(start, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
		LocalDateTime endTime = LocalDateTime.parse(end, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
		
		LocalTime localTime1 = startTime.toLocalTime();
		LocalTime localTime2 = endTime.toLocalTime();
		
		//System.out.println("start time:" + localTime1);
		//System.out.println("end time:" + localTime2);
		
		Duration diff = Duration.between(localTime1,localTime2);
	
		 String hms = String.format("%d:%02d:%02d", 
                 diff.toHours(), 
                 diff.toMinutesPart(), 
                 diff.toSecondsPart());
		
		return hms;
		

		
	}


public static boolean validateTime(String time) {
	    
		
		LocalDateTime dateTime = LocalDateTime.parse(time, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
		
		LocalTime localTime1 = dateTime.toLocalTime();
		
		
		//System.out.println("start time:" + localTime1);
		
		
		int seconds= localTime1.getSecond();
		
		if(seconds > 59);
		
		return false;
		

		
	}



	


}