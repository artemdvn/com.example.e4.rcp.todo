
package com.example.e4.rcp.todo.parts;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.ui.di.Focus;
import org.eclipse.e4.ui.di.Persist;
import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;

public class PlaygroundPart {
	
	private StringBuilder sb;
	
	@Inject
	private MPart part;
	
	@Inject
	public PlaygroundPart(@Named @Optional StringBuilder stringBuilder) {
		this.sb = stringBuilder;
		System.out.println("String Builder: " + sb);
	}

	@PostConstruct
	public void createControls(Composite parent) {
		System.out.println(this.getClass().getSimpleName() + " @PostConstruct method called.");
		Button button = new Button(parent, SWT.CHECK);
		button.setText("Set dirty");
        button.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                part.setDirty(button.getSelection());
            }
        });
	}

	@Inject
	public void receiveActiveShell(@Named(IServiceConstants.ACTIVE_SHELL) Shell shell) {
		if (shell != null) {
			System.out.println("Active shell: " + System.identityHashCode(shell));
		}
	
	}

	@Inject
	public void receiveActivePart(@Named(IServiceConstants.ACTIVE_PART) MPart activePart) {
		if (activePart != null) {
			System.out.println("Active part: " + activePart.getLabel());
		}
	}

	@Inject
	@Optional
	public void receiveStringBuilder(StringBuilder stringBuilder) {
		if (stringBuilder != null) {
			System.out.println("String Builder: " + stringBuilder.getClass().getName());
		} else {
			System.out.println("String Builder is null");
		}
	}
	
	@Inject
	public void receiveComposite(Composite composite) {
		if (composite != null) {
			System.out.println("Composite: " + composite.getClass().getName());
		} else {
			System.out.println("Composite");
		}
	}
	
	@Focus
	void grantFocus() {
		System.out.println("Focused on: " + this.getClass().getName());
	}
	
	@Persist
	public void save(MPart part) {
	    System.out.println("Save Part: " + part.getClass().getName());
	    part.setDirty(false);
	}
}