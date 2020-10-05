/*
 * A Coronavirus Case Tracker Application
 * @author: Mark Zarak, Oct 2020
 */

package mz.coronavirus_case_tracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class CoronavirusCaseTrackerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoronavirusCaseTrackerApplication.class, args);
	}
}
