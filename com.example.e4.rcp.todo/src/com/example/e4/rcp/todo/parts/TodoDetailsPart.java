 
package com.example.e4.rcp.todo.parts;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.eclipse.swt.widgets.Composite;

public class TodoDetailsPart {
	@Inject
	public TodoDetailsPart() {
		
	}
	
	@Inject
	@PostConstruct
	public void createControls(Composite parent) {
		System.out.println(this.getClass().getSimpleName() + " @PostConstruct method called.");
	}
	
	
}