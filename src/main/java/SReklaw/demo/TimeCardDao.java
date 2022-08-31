package SReklaw.demo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TimeCardDao extends JpaRepository< TimeCard, Long> {


	
	public TimeCard findByStart(String s);
	
}
