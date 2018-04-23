/**
 * 
 */
package layouts;

/**
 * @author RAM
 *
 */
public class SectionDesign implements Comparable<SectionDesign> {
	private int row;
	private int section;
	private int totalCapacity;
	private int availableSeats;

	/**
	 * @return the row
	 */
	public int getRow() {
		return row;
	}

	/**
	 * @param row
	 *            the row to set
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
	 * @param section
	 *            the section to set
	 */
	public void setSection(int section) {
		this.section = section;
	}

	/**
	 * @return the totalCapacity
	 */
	public int getTotalCapacity() {
		return totalCapacity;
	}

	/**
	 * @param totalCapacity
	 *            the totalCapacity to set
	 */
	public void setTotalCapacity(int totalCapacity) {
		this.totalCapacity = totalCapacity;
	}

	/**
	 * @return the availableSeats
	 */
	public int getAvailableSeats() {
		return availableSeats;
	}

	/**
	 * @param availableSeats
	 *            the availableSeats to set
	 */
	public void setAvailableSeats(int availableSeats) {
		this.availableSeats = availableSeats;
	}

	@Override
	public int compareTo(SectionDesign o) {
		// return the available seats , row and section
		int asRS = 0;

		// Making sure that values are entered

		if (this.totalCapacity != 0) {
			if ((this.availableSeats - o.availableSeats) == 0) {
				if ((this.row - o.row) == 0) {
					asRS = this.section - o.section;
				} else {
					asRS = this.row - o.row;
				}
			} else {
				asRS = this.availableSeats - o.availableSeats;
			}
		} else {
			asRS = 0;
		}
		return asRS;
	}

	public String toString() {
		return "Available Seats: " + availableSeats + "\n" + "Row: " + row + "\n" + "Section: " + section + "\n";
	}

}
