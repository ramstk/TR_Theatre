/**
 * 
 */
package layouts;

import java.util.List;

/**
 * @author RAM
 *
 */
public class TheatreDesign {
	private int totalCapacity;
	private int availableSeats;
	private List<SectionDesign> rowSec;

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

	/**
	 * @return the rowSec
	 */
	public List<SectionDesign> getRowSec() {
		return rowSec;
	}

	/**
	 * @param rowSec
	 *            the rowSec to set
	 */
	public void setRowSec(List<SectionDesign> rowSec) {
		this.rowSec = rowSec;
	}

}
