package Eventhandler;

import cucumber.api.event.EventHandler;
import  cucumber.api.event.EventListener;
import cucumber.api.event.EventPublisher;

import cucumber.api.event.TestRunFinished;
import cucumber.api.event.TestRunStarted;

public class TestEventHandlerPlugin implements EventListener {

	/*@Override
    public <teardown> void setEventPublisher(EventPublisher eventPublisher) {
        eventPublisher.registerHandlerFor(TestRunFinished.class, teardown);
    }

    private EventHandler<TestRunFinished> teardown = event -> {
        //run code after all tests
    };*/

	
    
	 @Override
	    public void setEventPublisher(EventPublisher publisher) {
//	        publisher.registerHandlerFor(TestRunStarted.class, runStartedHandler);
	    }

	    private void startReport(TestRunStarted event) {
	        System.out.println(event.getTimeStamp());
	    }
}