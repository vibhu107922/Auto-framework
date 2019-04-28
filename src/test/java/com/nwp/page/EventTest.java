package com.nwp.page;

import com.nwp.baseTest.NWPBaseTest;
import com.nwp.page.event.EventClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class EventTest extends NWPBaseTest {
    EventClass eventClass;

    @BeforeClass
    private void classInit(){
        eventClass = new EventClass(driver);
    }

    @Test
    public void createEvent(){

    }
}
