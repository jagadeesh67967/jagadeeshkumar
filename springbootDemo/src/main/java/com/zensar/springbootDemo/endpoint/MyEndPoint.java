package com.zensar.springbootDemo.endpoint;

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
@Endpoint(id = "bug-fixes")
public class MyEndPoint {
	/*
	 * @ReadOperation public String sayHello() { return "Hello"; }
	 * 
	 * @WriteOperation public String writeOp(@Selector String write) { return write;
	 * }
	 */
	private Map<String, List<String>> bugFixesByVersion = new HashMap<>();

	@PostConstruct
	public void init() {
		bugFixesByVersion.put("v1", Arrays.asList("Invalid status issue","Windows closing not working"));
		bugFixesByVersion.put("v2",Arrays.asList("Window size issue","Window minimising not working") );
						
				
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
