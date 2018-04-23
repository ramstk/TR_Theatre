/**
 * 
 */
package seatReqDesign;


/**
 * @author RAM
 *
 */
public class BookingSeat {
	private String name;
	private int ticketsCount;
	private boolean seatAllotted;
	private int row;
	private int section;
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the ticketsCount
	 */
	public int getTicketsCount() {
		return ticketsCount;
	}
	/**
	 * @param ticketsCount the ticketsCount to set
	 */
	public void setTicketsCount(int ticketsCount) {
		this.ticketsCount = ticketsCount;
	}

	/**
	 * @return the seatAllotted
	 */
	public boolean isSeatAllotted() {
		return seatAllotted;
	}
	/**
	 * @param seatAllotted the seatAllotted to set
	 */
	public void setSeatAllotted(boolean seatAllotted) {
		this.seatAllotted = seatAllotted;
	}
	/**
	 * @return the row
	 */
	public int getRow() {
		return row;
	}
	/**
	 * @param row the row to set
	 */
	public void setRow(int row) {
		this.row = row;
	}
	/**
	 * @return the section
	 */
	public int getSection() {
		return section;
	}
	/**
	 * @param section the section to set
	 */
	public void setSection(int section) {
		this.section = section;
	}

	// set the response when a booking request is made; if the layout is not given then we set a default response as totalCapacity not set
	
	public String getResponse() {
		String response = null;
		
		//Smith Row 1 Section 1
		//Wilson Sorry, we can't handle your party.
		//Miller Call to split party.
		
		if (seatAllotted) {
			response = name + " " + "Row " + row + " " + "Section " + section + "\n";
		}
		else {
			if(row == -1 && section == -1) {
				response = name + " " + "Call to split party." + "\n";
			}
			else {
				response = name + " " + "Sorry, we can't handle your party." + "\n";
			}
		}
		return response;
		
	}

}
