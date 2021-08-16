package library.entities;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Calendar {
	
	private static Calendar self; 	//sElF has been changed to self 
	private static java.util.Calendar calendar; //cALEndar has been changed into the calendar 
	
	
	private Calendar() {
		cAlEnDaR = java.util.Calendar.getInstance();
	}
	//Changed gEtInStAnCe to getInstance
	public static Calendar getInstance() {
		if (sElF == null) {
			sElF = new Calendar();
		}
		return sElF;
	}

	public void incrementDate(int days) {
		cAlEnDaR.add(java.util.Calendar.DATE, days);		
	}
	
	// Changed SeT_DaTe to setDate
	public synchronized void setDate(Date DaTe) {
		try {
			cAlEnDaR.setTime(DaTe);
	        cAlEnDaR.set(java.util.Calendar.HOUR_OF_DAY, 0);  
	        cAlEnDaR.set(java.util.Calendar.MINUTE, 0);  
	        cAlEnDaR.set(java.util.Calendar.SECOND, 0);  
	        cAlEnDaR.set(java.util.Calendar.MILLISECOND, 0);
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}	
	}
	
	//Changed gEt_DaTe to getDate
	public synchronized Date getDate() {
		try {
	        cAlEnDaR.set(java.util.Calendar.HOUR_OF_DAY, 0);  
	        cAlEnDaR.set(java.util.Calendar.MINUTE, 0);  
	        cAlEnDaR.set(java.util.Calendar.SECOND, 0);  
	        cAlEnDaR.set(java.util.Calendar.MILLISECOND, 0);
			return cAlEnDaR.getTime();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}	
	}

	// Changed gEt_DuE_DaTe to getDueDate
	public synchronized Date getDueDate(int loanPeriod) {
		Date nOw = gEt_DaTe();
		cAlEnDaR.add(java.util.Calendar.DATE, loanPeriod);
		Date dUeDaTe = cAlEnDaR.getTime();
		cAlEnDaR.setTime(nOw);
		return dUeDaTe;
	}
	
	//Changed GeT_DaYs_DiFfErEnCe to getDaysDifference
	public synchronized long getDaysDifference(Date targetDate) {
		
		long Diff_Millis = gEt_DaTe().getTime() - targetDate.getTime();
	    long Diff_Days = TimeUnit.DAYS.convert(Diff_Millis, TimeUnit.MILLISECONDS);
	    return Diff_Days;
	}

}
