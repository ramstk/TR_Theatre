/**
 * 
 */
package test.unit;

import java.util.List;

import org.junit.jupiter.api.Test;
import seatReqDesign.BookingSeat;
import layouts.TheatreDesign;
import parseTheatreRequest.ParseDesignRequest;

/**
 * @author RAM
 *
 */
class Inputs {

	@Test
	public void ArrayIndexOutOfBoundsExceptiontest() {
		String inputLine;
		StringBuilder theatreDesign = new StringBuilder();
		StringBuilder bookingRequest = new StringBuilder();
		inputLine = "3" + "\n";
		theatreDesign.append(inputLine + "\n" + "\n");
		bookingRequest.append(theatreDesign + "\n" + "\n" + "Ram 3" + "");
		
		ParseDesignRequest parseReq = new ParseDesignRequest();
		
		try {
			TheatreDesign tDesign = parseReq.getTheatreDesign(theatreDesign.toString());
			List<BookingSeat> requests = parseReq.getBookingrequest(bookingRequest.toString());
			parseReq.processBookingReq(tDesign, requests);
			assert false;
		}catch(ArrayIndexOutOfBoundsException nfe) {
			assert true;
		}
			

	}
	
	@Test
	public void ValidInputtest() {
		String inputLine;
		StringBuilder theatreDesign = new StringBuilder();
		StringBuilder bookingRequest = new StringBuilder();
		inputLine = "3";
		
		theatreDesign.append(inputLine);
		
		bookingRequest.append( "Ram 3");
		
		
		ParseDesignRequest parseReq = new ParseDesignRequest();
		
	
			TheatreDesign tDesign = parseReq.getTheatreDesign(theatreDesign.toString());
			List<BookingSeat> requests = parseReq.getBookingrequest(bookingRequest.toString());
			parseReq.processBookingReq(tDesign, requests);

	}
	
	@Test
	public void MultiRows() {
		String inputLine;
		StringBuilder theatreDesign = new StringBuilder();
		StringBuilder bookingRequest = new StringBuilder();
		inputLine = "1\n4";
		
		theatreDesign.append(inputLine);
		
		bookingRequest.append( "Ram 3");
			ParseDesignRequest parseReq = new ParseDesignRequest();

			TheatreDesign tDesign = parseReq.getTheatreDesign(theatreDesign.toString());
			List<BookingSeat> requests = parseReq.getBookingrequest(bookingRequest.toString());
			parseReq.processBookingReq(tDesign, requests);

	
	}
	@Test
	public void MultiUsersRequests() {
		String inputLine;
		StringBuilder theatreDesign = new StringBuilder();
		StringBuilder bookingRequest = new StringBuilder();
		inputLine = "2\n4";
		
		theatreDesign.append(inputLine);
		
		bookingRequest.append( "Ram 3\nSam 2");
			ParseDesignRequest parseReq = new ParseDesignRequest();

			TheatreDesign tDesign = parseReq.getTheatreDesign(theatreDesign.toString());
			List<BookingSeat> requests = parseReq.getBookingrequest(bookingRequest.toString());
			parseReq.processBookingReq(tDesign, requests);

	
	}
	
	@Test
	public void SplitCall() {
		String inputLine;
		StringBuilder theatreDesign = new StringBuilder();
		StringBuilder bookingRequest = new StringBuilder();
		inputLine = "8\n4\n6";
		
		theatreDesign.append(inputLine);
		
		bookingRequest.append( "Ram 7\nSam 7");
			ParseDesignRequest parseReq = new ParseDesignRequest();

			TheatreDesign tDesign = parseReq.getTheatreDesign(theatreDesign.toString());
			List<BookingSeat> requests = parseReq.getBookingrequest(bookingRequest.toString());
			parseReq.processBookingReq(tDesign, requests);

	
	}
	@Test
	public void FailCall() {
		String inputLine;
		StringBuilder theatreDesign = new StringBuilder();
		StringBuilder bookingRequest = new StringBuilder();
		inputLine = "2\n2";
		
		theatreDesign.append(inputLine);
		
		bookingRequest.append( "Ram 7\nSam 7");
			ParseDesignRequest parseReq = new ParseDesignRequest();

			TheatreDesign tDesign = parseReq.getTheatreDesign(theatreDesign.toString());
			List<BookingSeat> requests = parseReq.getBookingrequest(bookingRequest.toString());
			parseReq.processBookingReq(tDesign, requests);

	
	}
	@Test
	public void NumberFormatExceptiontest() {
		String inputLine;
		StringBuilder theatreDesign = new StringBuilder();
		StringBuilder bookingRequest = new StringBuilder();
		inputLine = "2\nR";
		
		theatreDesign.append(inputLine);
		
		bookingRequest.append( "Ram 7\nSam 7");
		
		ParseDesignRequest parseReq = new ParseDesignRequest();
		
		try {
			TheatreDesign tDesign = parseReq.getTheatreDesign(theatreDesign.toString());
			List<BookingSeat> requests = parseReq.getBookingrequest(bookingRequest.toString());
			parseReq.processBookingReq(tDesign, requests);
			assert false;
		}catch(NumberFormatException nfe) {
			assert true;
		}
			

	}
	

}
