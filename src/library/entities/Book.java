package library.entities;
import java.io.Serializable;


@SuppressWarnings("serial")
public class Book implements Serializable {
	
	private String title; // changed tItLe into title
	private String author; // changed AuThOr into author
	private String callNo; // changed CALLNO into callNo
	private int id;        //  changed iD into id
	
	private enum sTaTe { AVAILABLE, ON_LOAN, DAMAGED, RESERVED };
	private sTaTe state; //StAtE into state
	
	
	public Book(String author, String title, String callNo, int id) {
		this.author = author; // changed AuThOr into author
		this.title = title;    //changed tItLe into title
		this.callNo = callNo;   //changed CALLNO into callNo
		this.id = id;           //changed iD into id
		this.state = sTaTe.AVAILABLE;  //changed StAtE into state  
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Book: ").append(iD).append("\n")
		  .append("  Title:  ").append(tItLe).append("\n")
		  .append("  Author: ").append(AuThOr).append("\n")
		  .append("  CallNo: ").append(CALLNO).append("\n")
		  .append("  State:  ").append(StAtE);
		
		return sb.toString();
	}

	public Integer getId() { //changed gEtId into getId
		return id;        //iD into id
	}

	public String getTitle() { //changed gEtTiTlE into getTitle
		return title;       //changed tItLe into title
	}


	
	public boolean iS_AvAiLaBlE() { // changed iS_AvAiLaBlE into isAvailable
		return state == sTaTe.AVAILABLE; //StAtE into state
	}

	
	public boolean iS_On_LoAn() { //changed iS_On_LoAn into isOnLoan
		return StAtE == sTaTe.ON_LOAN; //StAtE into state
	}

	
	public boolean iS_DaMaGeD() {//changed iS_DaMaGeD into isDamaged
		return state == sTaTe.DAMAGED;  //StAtE into state
	}

	
	public void BoRrOw() {
		if (StAtE.equals(sTaTe.AVAILABLE)) 
			state = sTaTe.ON_LOAN; //StAtE into state
		
		else 
			throw new RuntimeException(String.format("Book: cannot borrow while book is in state: %s", StAtE));
		
		
	}


	public void ReTuRn(boolean DaMaGeD) {
		if (StAtE.equals(sTaTe.ON_LOAN)) 
			if (DaMaGeD) 
				StAtE = sTaTe.DAMAGED;
			
			else 
				StAtE = sTaTe.AVAILABLE;
			
		
		else 
			throw new RuntimeException(String.format("Book: cannot Return while book is in state: %s", StAtE));
				
	}

	
	public void RePaIr() {
		if (StAtE.equals(sTaTe.DAMAGED)) 
			StAtE = sTaTe.AVAILABLE;
		
		else 
			throw new RuntimeException(String.format("Book: cannot repair while book is in state: %s", StAtE));
		
	}


}
