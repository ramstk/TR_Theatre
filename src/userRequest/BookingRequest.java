package userRequest;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import seatReqDesign.BookingSeat;
import layouts.TheatreDesign;
import parseTheatreRequest.ParseDesignRequest;

public class BookingRequest {

	public static void main(String[] args) throws IOException {
		
		String inputLine;
		StringBuilder theatreDesign = new StringBuilder();
		StringBuilder bookingRequest = new StringBuilder();
		boolean isDesignComplete = false;
		
		System.out.println("Enter the Design and booking request" + "\n" + "Type 'close' when completed \n");
		Scanner input = new Scanner(System.in);
		
		while((inputLine = input.nextLine()) != null && !inputLine.equals("close")){
			
			try {
				if(inputLine.length() == 0) {
					isDesignComplete = true;
					continue;
				}
				if(!isDesignComplete) {
					theatreDesign.append(inputLine + System.lineSeparator());
					
				}
				else{
					bookingRequest.append(inputLine + System.lineSeparator());
				}
			}
			catch(Exception e) {
				e.printStackTrace();
				}
			
		}
				input.close();
				
		
			ParseDesignRequest parseReq = new ParseDesignRequest();
			try {
				TheatreDesign tDesign = parseReq.getTheatreDesign(theatreDesign.toString());
				List<BookingSeat> requests = parseReq.getBookingrequest(bookingRequest.toString());
				parseReq.processBookingReq(tDesign, requests);
			}
			catch (ArrayIndexOutOfBoundsException ar) {
				throw new ArrayIndexOutOfBoundsException ("seat allotment invalid format");
			}
			catch(NumberFormatException nf){
	            
				throw new NumberFormatException ("totalCapacity invalid format");
	            
	        }
			catch(Exception e) {
				e.printStackTrace();
			}
			
	}

}
