package SReklaw.demo;




import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AppController {
	
	@Autowired
	private TimeCardDao timedao;
	
	@RequestMapping("/")
	public String showHome(Model model){
		LocalDateTime myObj = LocalDateTime.now();
		String formattedDate = TimeCard.formatDate(myObj);
		
		model.addAttribute("date", formattedDate);
		
		//System.out.println(myObj);
		return("index");
	}

	@RequestMapping("/start")
	public String showStart(Model model) {
		LocalDateTime myObj = LocalDateTime.now();
		String formattedDate = TimeCard.formatDate(myObj);
		
		model.addAttribute("date", formattedDate);
		
		return("clockinform");
	}
	
	// each team member has a list of clockin objects
	//each clock in is an object- create json data
	
	@PostMapping ("/startclock")
	public String startClockin(@RequestParam ("duty") String duty) {
		LocalDateTime myObj;
		String formattedtime=null;
		int seconds;
		
		do {
		 myObj = LocalDateTime.now();
		
		seconds= myObj.getSecond();
		System.out.println("seconds to validate" + seconds);
		
		} while (seconds > 59);
		
		if(seconds <59) {
		DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		 formattedtime = myObj.format(myFormatObj);
		
	    TimeCard clock= new TimeCard();
		clock.setDuty(duty);
		clock.setStart(formattedtime);
		timedao.save(clock);
		}
		
		      
		return "redirect:/";
	}
	
	@RequestMapping ("/end")
	public String endClockin(Model model){
	
		return "/logoutconfirm";
	}
	
	@PostMapping ("/endclock")
	public String endClock() {
		//select  time to clock-out and format
		LocalDateTime myObj = LocalDateTime.now();
		String formattedTimeOut = TimeCard.formatDate(myObj);
		
		//locate all clockins 
		List <TimeCard>clockins= timedao.findAll();
		List<TimeCard> startNoEnd= new LinkedList<TimeCard>();
		
		// Loop through List find null end
		 for(TimeCard clock : clockins) {
			 if(clock.getEnd() == null) {
				 startNoEnd.add(clock);
				}
			 }
		 //System.out.println("list" + startNoEnd);
		//Date has to be same
		 
		 LocalDateTime recent= LocalDateTime.MAX;
		 TimeCard recentClock= startNoEnd.get(0);
		//List <LocalDateTime> dateStart= new ArrayList <LocalDateTime>();
		 
		 //Loop clockin with null end and find max time
		 for( int i=1; i < startNoEnd.size(); i++) {
		     recent= TimeCard.formatStringToDate(startNoEnd.get(i).getStart()); 
		     //find max date if multiple 
		     if(recent.isAfter(TimeCard.formatStringToDate(startNoEnd.get(i).getStart()))){
			   recent = TimeCard.formatStringToDate(startNoEnd.get(i).getStart());
		       }
		     recentClock= startNoEnd.get(i);
		    }
		  
	     //System.out.println("time out" + recentClock + formattedTimeOut);
		 //Set end time and save 
		 recentClock.setEnd(formattedTimeOut);
		 timedao.save(recentClock);
		 
		return "redirect:/";
	}
	
	
	@RequestMapping ("/timecard")
	public String viewTimeCard(Model model) {
		
		List <TimeCard>clockins= timedao.findAll();
		Collections.reverse(clockins); 
		String hours = null;
		
		for(TimeCard clock: clockins) {
		//System.out.println(clock);
			if(clock.getStart() != null && clock.getEnd() != null) {
			hours=clock.getHours(clock.getStart(), clock.getEnd());
			clock.setHours(hours);
			//System.out.println(hours);
			}else if ((clock.getEnd() == null)) {
				clock.setEnd("NO CLOCK OUT FOUND");
				clock.setHours("0:00:00");
			}
			if ((clock.getDuty() == null)){
				clock.setDuty("MISC");
		    }
		}
		
		model.addAttribute("timestamps", clockins);
		
		return ("timecard");
	}
	
	@RequestMapping ("/delete/time")
	public String deleteTimeCard(@RequestParam ("id") Long id) {
		timedao.deleteById(id);
		return ("redirect:/timecard");
	}
	
}

