package parseTheatreRequest;

import layouts.TheatreDesign;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Comparator;

import seatReqDesign.BookingSeat;
import layouts.SectionDesign;

public class ParseDesignRequest {
	public TheatreDesign getTheatreDesign(String rawLayout) {
		TheatreDesign layout = new TheatreDesign();
		SectionDesign section;
		List<SectionDesign> sectionDesign = new ArrayList<SectionDesign>();
		int totalCapacity = 0, value;
		String [] rows = rawLayout.split(System.lineSeparator());
		String [] sections;
		for(int i=0;i<rows.length;i++) {
			sections = rows[i].split(" ");
			for (int j=0;j<sections.length; j++) {
				try {
					value = Integer.valueOf(sections[j]);
				}catch(Exception e) {
					throw new NumberFormatException ("totalCapacity invalid format");
				}
				totalCapacity = totalCapacity + value;
				section = new SectionDesign();
				section.setRow(i + 1);
				section.setSection(j +1);
				section.setTotalCapacity(value);
				section.setAvailableSeats(value);
				sectionDesign.add(section);
				
			}
			
		}

		layout.setAvailableSeats(totalCapacity);
		layout.setTotalCapacity(totalCapacity);
		layout.setRowSec(sectionDesign);
	
		return layout;
		
	}
	
	public List<BookingSeat> getBookingrequest(String bookingRequest) {
		List<BookingSeat> seatsRequest = new ArrayList<BookingSeat>();
		BookingSeat request;
		String [] requests = bookingRequest.split(System.lineSeparator());
		
			for (String req : requests) {
				String[]reqData = req.split(" ");
				request = new BookingSeat();
				request.setName(reqData [0]);
				request.setTicketsCount(Integer.valueOf(reqData[1]));
				request.setSeatAllotted(false);
				seatsRequest.add(request);
				
			}
		
		
		return seatsRequest;
		
	}
	
	private int findAltReq(List<BookingSeat> requests, int altSeats, int currentReqIndex) {
		int reqNum = -1;
		
		for (int i = currentReqIndex +1; i < requests.size() ; i ++) {
			BookingSeat request = requests.get(i);
			if (!request.isSeatAllotted() && request.getTicketsCount() == altSeats) {
				reqNum = i;
				break;
			}
		}
		
		return reqNum;
		
	}
	
	private int findSection(List<SectionDesign> sections, int availableSeats){
		int i = 0;
		SectionDesign section = new SectionDesign();
		section.setAvailableSeats(availableSeats);
		Collections.sort(sections);
		Comparator<SectionDesign> bySeatsAvailable = new Comparator <SectionDesign>() {
			public int compare(SectionDesign o1, SectionDesign o2) {
				return o1.getAvailableSeats() - o2.getAvailableSeats();
			}
		};
		int sectionNum = Collections.binarySearch(sections, section, bySeatsAvailable);
		if(sectionNum > 0) {
			for(i=sectionNum-1; i>=0; i--) {
				SectionDesign sd = sections.get(i);
				if(sd.getAvailableSeats() != availableSeats)
					break;
			}
			sectionNum = i+1;
		}
		
		return sectionNum;
		
	}
	
	public void processBookingReq (TheatreDesign layout, List<BookingSeat> requests) {
		for(int i=0 ; i<requests.size(); i++) {
			BookingSeat request = requests.get(i);
			if(request.isSeatAllotted())
				continue;
			if(request.getTicketsCount() > layout.getAvailableSeats()) {
				request.setRow(-2);
				request.setSection(-2);
				continue;
			}
			List<SectionDesign> sections = layout.getRowSec();
			for (int j=0 ; j<sections.size() ; j++) {
				SectionDesign section = sections.get(j);
				
				if(request.getTicketsCount() <= section.getAvailableSeats()) {
					request.setRow(section.getRow());
					request.setSection(section.getSection());
					section.setAvailableSeats(section.getAvailableSeats() - request.getTicketsCount());
					layout.setAvailableSeats(layout.getAvailableSeats() - request.getTicketsCount());
					request.setSeatAllotted(true);
					break;
					
				}
				else if(request.getTicketsCount() < section.getAvailableSeats()) {
					
					int requestNum = findAltReq(requests, section.getAvailableSeats() - request.getTicketsCount(), i);
					if(requestNum != -1) {
						request.setRow(section.getRow());
						request.setSection(section.getSection());
						section.setAvailableSeats(section.getAvailableSeats() - request.getTicketsCount());
						layout.setAvailableSeats(layout.getAvailableSeats() - request.getTicketsCount());
						request.setSeatAllotted(true);
						
						BookingSeat altRequest = requests.get(requestNum);
						
						altRequest.setRow(section.getRow());
						altRequest.setSection(section.getSection());
						section.setAvailableSeats(section.getAvailableSeats() - request.getTicketsCount());
						layout.setAvailableSeats(layout.getAvailableSeats() - request.getTicketsCount());
						altRequest.setSeatAllotted(true);
						
						break;
					}
					else {
						int sectionNum = findSection(sections, request.getTicketsCount());
						if(sectionNum >= 0) {
							SectionDesign newSection = sections.get(sectionNum);
							request.setRow(newSection.getRow());
							request.setSection(newSection.getSection());
							newSection.setAvailableSeats(newSection.getAvailableSeats() - request.getTicketsCount());
							layout.setAvailableSeats(layout.getAvailableSeats() - request.getTicketsCount());
							request.setSeatAllotted(true);
							break;
							
						}
						else {
							request.setRow(section.getRow());
							request.setSection(section.getSection());
							section.setAvailableSeats(section.getAvailableSeats() - request.getTicketsCount());
							layout.setAvailableSeats(layout.getAvailableSeats() - request.getTicketsCount());
							request.setSeatAllotted(true);
							break;
						}
					}
				}
			}
			if (!request.isSeatAllotted()) {
				request.setRow(-1);
				request.setSection(-1);
			}
		}
		System.out.println("Seat Allotment" + "\n");
		for(BookingSeat request : requests) {
			System.out.println(request.getResponse());
		}
	}
	

}
