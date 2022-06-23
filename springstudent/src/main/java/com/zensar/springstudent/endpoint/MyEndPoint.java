package com.zensar.springstudent.endpoint;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.boot.actuate.endpoint.annotation.DeleteOperation;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.Selector;
import org.springframework.boot.actuate.endpoint.annotation.WriteOperation;
import org.springframework.stereotype.Component;

@Component
@Endpoint(id = "myEndPoint")
public class MyEndPoint<bugFixesByVersion> {

	/*
	 * @ReadOperation public String sayHello() { return " HELLO "; }
	 * 
	 * @WriteOperation public String writeOp(@Selector String write) { return write;
	 * }
	 */
	
	private Map<String, List<String>> bugFixesByVersion = new HashMap<>();

	@PostConstruct
	public void init() {
		bugFixesByVersion.put("v1", Arrays.asList("status invalid","closing Windows not working"));
		bugFixesByVersion.put("v2",Arrays.asList("issue in Window size","minimising Window not working") );
						
				
	}
	@ReadOperation
	public Map<String, List<String>> getAllBugFixes() {
		return bugFixesByVersion;
		
	}
	@ReadOperation
	public List<String> getBugByVersion(@Selector String version) {
		
		return bugFixesByVersion.get(version);
		
	}
	
	@WriteOperation
	public void addBugFixes(@Selector String version,@Selector String bugFixes) {
		bugFixesByVersion.put(version, Arrays.asList(bugFixes.split(",")));
	}

	@DeleteOperation
	public void deleteBugFixes(@Selector String version) {
		bugFixesByVersion.remove(version);
	}

}
