package library.entities;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Calendar {
	
	private static Calendar self; 	//sElF has been changed to self 
	private static java.util.Calendar calendar; //cALEndar has been changed into the calendar 
	
	
	private Calendar() {
		calendar = java.util.Calendar.getInstance(); //cALEndar has been changed into the calendar 
	}
	//Changed gEtInStAnCe to getInstance
	//Changed sELF to self 
	public static Calendar getInstance() {
		if (self == null) {
			self = new Calendar();
		}
		return self;
	}
	//cALEndar has been changed into the calendar 
	public void incrementDate(int days) {
		calendar.add(java.util.Calendar.DATE, days);		
	}
	
	// Changed SeT_DaTe to setDate
	//cALEndar has been changed into the calendar
	public synchronized void setDate(Date DaTe) {
		try {
			calendar.setTime(DaTe);
	        calendar.set(java.util.Calendar.HOUR_OF_DAY, 0);  
	        calendar.set(java.util.Calendar.MINUTE, 0);  
	        calendar.set(java.util.Calendar.SECOND, 0);  
	        calendar.set(java.util.Calendar.MILLISECOND, 0);
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}	
	}
	
	//Changed gEt_DaTe to getDate
	//cALEndar has been changed into the calendar

	public synchronized Date getDate() {
		try {
	        calendar.set(java.util.Calendar.HOUR_OF_DAY, 0);  
	        calendar.set(java.util.Calendar.MINUTE, 0);  
	        calendar.set(java.util.Calendar.SECOND, 0);  
	        calendar.set(java.util.Calendar.MILLISECOND, 0);
			return calendar.getTime();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}	
	}

	// Changed gEt_DuE_DaTe to getDueDate
	//cALEndar has been changed into the calendar
	public synchronized Date getDueDate(int loanPeriod) {
		Date nOw = getDaTe(); //gEt_DaTe has been changed to getDate
		calendar.add(java.util.Calendar.DATE, loanPeriod);
		Date DueDaTe = calendar.getTime(); //dUeDate has been changed to DueDate 
		calendar.setTime(nOw);
		return DueDate;
	}
	
	//Changed GeT_DaYs_DiFfErEnCe to getDaysDifference
	public synchronized long getDaysDifference(Date targetDate) {
		
		long Diff_Millis = gEt_DaTe().getTime() - targetDate.getTime();
	    long Diff_Days = TimeUnit.DAYS.convert(Diff_Millis, TimeUnit.MILLISECONDS);
	    return Diff_Days;
	}

}
