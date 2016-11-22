package a10;

import java.awt.Color;

import javax.swing.JButton;

public class LightsButtons extends JButton {
	private int Rows; 
	private int Columns;
	
	public LightsButtons(int Rows, int Columns) {
		super();
		
		this.Rows = Rows;
		this.Columns = Columns;
	}

	/**
	 * @return the rows
	 */
	public int getRows() {
		return Rows;
	}

	/**
	 * @param rows the rows to set
	 */
	public void setRows(int rows) {
		Rows = rows;
	}

	/**
	 * @return the columns
	 */
	public int getColumns() {
		return Columns;
	}

	/**
	 * @param columns the columns to set
	 */
	public void setColumns(int columns) {
		Columns = columns;
	}
	
	public void black(){
		setBackground(Color.BLACK);
	}
	
	public void white(){
		setBackground(Color.WHITE);
	}
	
	// toggle color
	public void toggle() {
		if (Color.WHITE == Color.WHITE) {
			black(); 
		} else {
			white();
		}
	}
	

}
