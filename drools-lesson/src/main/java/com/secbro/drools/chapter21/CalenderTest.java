package com.secbro.drools.chapter21;

import com.secbro.drools.BaseTest;
import org.junit.Test;
import org.kie.api.runtime.KieSession;
import org.kie.api.time.Calendar;
import org.quartz.impl.calendar.WeeklyCalendar;

public class CalenderTest extends BaseTest{

    @Test
    public void testCalender(){
        KieSession kieSession = this.getKieSessionBySessionName("calenderTest-rules");
        kieSession.getCalendars().set("weekday",WEEKDAY);
        kieSession.getCalendars().set("weekday_exclude",WEEKDAY_EXCLUDE);
        kieSession.fireAllRules();
        kieSession.dispose();

    }

    private static final Calendar WEEKDAY = new Calendar() {
        @Override
        public boolean isTimeIncluded(long timestamp) {
            WeeklyCalendar weeklyCalendar = new WeeklyCalendar();
            weeklyCalendar.setDaysExcluded(new boolean[]{false,false,false,false,false,false,false});
            weeklyCalendar.setDayExcluded(java.util.Calendar.THURSDAY,true);
            return weeklyCalendar.isTimeIncluded(timestamp);
        }
    };

    private static final Calendar WEEKDAY_EXCLUDE = new Calendar() {
        @Override
        public boolean isTimeIncluded(long timestamp) {
            WeeklyCalendar weeklyCalendar = new WeeklyCalendar();
            weeklyCalendar.setDaysExcluded(new boolean[]{false,false,false,false,false,false,false});
            return weeklyCalendar.isTimeIncluded(timestamp);
        }
    };

}
