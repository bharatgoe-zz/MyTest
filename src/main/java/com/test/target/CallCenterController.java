package com.test.target;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.test.target.model.Example;
import com.test.target.model.JuniorExecutive;
import com.test.target.model.Manager;
import com.test.target.model.Performance;
import com.test.target.model.SeniorExecutive;

@RestController
public class CallCenterController {

	private int total_number_of_calLs = 0;
	private int total_resolved = 0;
	private int total_unresolved = 0;
	private int total_time_taken_in_minutes = 0;

	@RequestMapping(value = "/processInfo", method = RequestMethod.POST)
	public ResponseEntity<Example> processInfo(@RequestBody CallCenterInformation callCenterInformation) {

		Example example = processData(callCenterInformation);

		return new ResponseEntity<Example>(example, HttpStatus.OK);
	}

	private Example processData(CallCenterInformation callCenterInformation) {

		Manager manager = processManagerData(callCenterInformation);
		List<Performance> performances = new ArrayList<Performance>();
		List<JuniorExecutive> juniorExecutives = processJuniorExecutiveData(callCenterInformation);
		List<SeniorExecutive> seniorExecutives = processSeniorExecutiveData(callCenterInformation);
		Performance performance = new Performance();
		performance.setJuniorExecutives(juniorExecutives);
		performance.setSeniorExecutives(seniorExecutives);
		performance.setManager(manager);

		Example example = new Example();
		example.setNumberOfCalls(Integer.toString(total_number_of_calLs));
		example.setResolved(Integer.toString(total_resolved));
		example.setUnresolved(Integer.toString(total_unresolved));
		example.setTotalTimeTakenInMinutes(Integer.toString(total_time_taken_in_minutes));
		performances.add(performance);
		example.setPerformance(performances);

		return example;

	}

	private List<SeniorExecutive> processSeniorExecutiveData(CallCenterInformation callCenterInformation) {
		List<SeniorExecutive> executives = new ArrayList<SeniorExecutive>();
		int seniorTotalNumberOfCalls = 0;
		int seniorTotalTimeTaken = 0;
		int seniorResolved = 0;
		int seniorUnResolved = 0;
		SeniorExecutive executive = null;
		List<String> je = callCenterInformation.getJe();
		int execCount = 1;
		for (String juniorExec : je) {
			executive = new SeniorExecutive();
			String id = "se" + execCount;
			String[] execData = juniorExec.split(",");
			int resolved = 0;
			int callsAttended = 0;
			int timeTaken = 0;
			int escalated = 0;
			int unresolved = 0;
			for (String exec : execData) {
				if (Integer.parseInt(exec) > 10) {
					escalated = escalated + 1;
					unresolved = unresolved + 1;
				} else {
					resolved = resolved + 1;
				}
				callsAttended = callsAttended + 1;
				timeTaken = timeTaken + Integer.parseInt(exec);

			}

			executive.setId(id);
			executive.setResolved(Integer.toString(resolved));
			executive.setEscalated(Integer.toString(escalated));
			executive.setTimeTakenInMinutes(Integer.toString(timeTaken));
			executive.setCallsAttended(Integer.toString(callsAttended));
			seniorTotalNumberOfCalls = seniorTotalNumberOfCalls + callsAttended;
			seniorTotalTimeTaken = seniorTotalTimeTaken + timeTaken;
			seniorResolved = seniorResolved + resolved;
			seniorUnResolved = seniorUnResolved + unresolved;
			executives.add(executive);
		}
		execCount=execCount+1;
		total_number_of_calLs = total_number_of_calLs + seniorTotalNumberOfCalls;
		total_time_taken_in_minutes = total_time_taken_in_minutes + seniorTotalTimeTaken;
		total_resolved = total_resolved + seniorResolved;
		total_unresolved = total_unresolved + seniorUnResolved;

		return executives;
	}

	private List<JuniorExecutive> processJuniorExecutiveData(CallCenterInformation callCenterInformation) {

		List<JuniorExecutive> executives = new ArrayList<JuniorExecutive>();
		JuniorExecutive executive = null;
		int juniorTimeTaken = 0;
		int juniorResolved = 0;
		int juniorUnresolved = 0;
		List<String> je = callCenterInformation.getJe();
		int juniorTotalCallsAttended = 0;
		int execCount = 1;
		for (String juniorExec : je) {
			executive = new JuniorExecutive();
			String id = "je" + execCount;
			String[] execData = juniorExec.split(",");
			int resolved = 0;
			int callsAttended = 0;
			int timeTaken = 0;
			int escalated = 0;
			int unresolved = 0;
			for (String exec : execData) {
				if (Integer.parseInt(exec) > 7) {
					escalated = escalated + 1;
				} else {
					resolved = resolved + 1;
					unresolved = unresolved + 1;
				}
				callsAttended = callsAttended + 1;

				timeTaken = timeTaken + Integer.parseInt(exec);
				
			}
			execCount=execCount+1;
			executive.setId(id);
			executive.setResolved(Integer.toString(resolved));
			executive.setEscalated(Integer.toString(escalated));
			executive.setTimeTakenInMinutes(Integer.toString(timeTaken));
			executive.setCallsAttended(Integer.toString(callsAttended));
			juniorTotalCallsAttended = juniorTotalCallsAttended + callsAttended;
			juniorResolved = juniorResolved + resolved;
			juniorTimeTaken = juniorTimeTaken + timeTaken;
			juniorUnresolved = juniorUnresolved + unresolved;
			executives.add(executive);
		}

		
		
		total_number_of_calLs = total_number_of_calLs + juniorTotalCallsAttended;
		total_resolved = total_resolved + juniorResolved;
		total_unresolved = total_unresolved + juniorUnresolved;
		total_time_taken_in_minutes = total_time_taken_in_minutes + juniorTimeTaken;

		return executives;
	}

	private Manager processManagerData(CallCenterInformation callCenterInformation) {
		// TODO Auto-generated method stub
		String mgr1 = callCenterInformation.getMgr();
		String id = "mgr";
		int mgrResolved = 0;
		int mgrUnresolved = 0;
		String[] mgrData = mgr1.split(",");
		int mgrCallsAttended = 0;
		int totalTimeTaken = 0;
		for (String mgr : mgrData) {
			int time = Integer.parseInt(mgr);
			if (time > 15) {
				mgrUnresolved = mgrUnresolved + 1;
			} else {
				mgrResolved = mgrResolved + 1;
			}
			totalTimeTaken = totalTimeTaken + time;
			mgrCallsAttended = mgrCallsAttended + 1;
			;
		}

		Manager manager = new Manager();
		manager.setId(id);
		manager.setResolved(Integer.toString(mgrResolved));
		manager.setUnresolved(Integer.toString(mgrUnresolved));
		manager.setTimeTakenInMinutes(Integer.toString(totalTimeTaken));
		manager.setCallsAttended(Integer.toString(mgrCallsAttended));
		total_number_of_calLs = mgrCallsAttended + total_number_of_calLs;
		return manager;

	}

}
