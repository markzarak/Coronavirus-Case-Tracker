/*
 * A Coronavirus Case Tracker Application
 * @author: Mark Zarak, Oct 2020
 */

package mz.coronavirus_case_tracker.controllers;

import mz.coronavirus_case_tracker.models.LocationStats;
import mz.coronavirus_case_tracker.services.CoronavirusDataService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@Autowired
	CoronavirusDataService coronavirusDataService;

	@GetMapping("/")
	public String home(Model model) {
		List<LocationStats> allStats = coronavirusDataService.getAllStats();
		int totalReportedCases = allStats.stream().mapToInt(stat -> stat.getLatestTotalCases()).sum();
		int totalNewCases = allStats.stream().mapToInt(stat -> stat.getDiffFromPrevDay()).sum();
		model.addAttribute("locationStats", allStats);
		model.addAttribute("totalReportedCases", totalReportedCases);
		model.addAttribute("totalNewCases", totalNewCases);

		return "home.html";
	}
}
