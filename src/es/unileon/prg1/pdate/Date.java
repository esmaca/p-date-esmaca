package es.unileon.prg1.pdate;

/**
 * IMPLEMENTACION DE LA CLASE DATE
 * @author ester
 * @version 0.1
 */

public class Date {
	private int day;
	private int month;
	private int year;
	
	//Constructor vacio
	Date(){
		this.day = 1;
		this.month = 1;
		this.year = 2020;
	}
	
	//Constructor con valores
	/*public Date(int day, int month, int year) {
		if((day<=31) && (day>0) && (month>0) && (month<=12)) {
			this.day = day;
			this.month = month;
			this.year = year;
		} else {
			throw new DateException("Fecha fuera del intervalo");
		}
	}*/
	
	//Constructor con valores
		public Date(int day, int month, int year) throws DateException {
			setDay(day);
			setMonth(month);
			setYear(year);
		}
	
	
	//get and set methods
	public int getDay() {
		return day;
	}

	public void setDay(int day) throws DateException {
		if((day<=31) && (day>0)) {
			this.day = day;
		} else {
			throw new DateException("Fecha fuera del intervalo");
		}
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) throws DateException {
		if((month>0) && (month<=12)) {
			this.month = month;
		} else {
			throw new DateException("Fecha fuera del intervalo");
		}
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	//Metodos del trabajo
	public boolean isSameYear(Date miFecha) {
		boolean retorno = false;
		
		if(this.year == miFecha.getYear())
			retorno = true;
		
		return retorno;
	}
	
	public boolean isSameYearNOTIF(Date miFecha) {
		return this.year == miFecha.getYear();
	}
	
	public boolean isSameMonth(Date miFecha) {
		boolean retorno = false;
		
		if(this.month == miFecha.getMonth())
			retorno = true;
		
		return retorno;
	}
	
	public boolean isSameMonthNOTIF(Date miFecha) {
		return this.month == miFecha.getMonth();
	}
	
	public boolean isSameDay(Date miFecha) {
		boolean retorno = false;
		
		if(this.day == miFecha.getDay())
			retorno = true;
		
		return retorno;
	}
	
	public boolean isSameDayNOTIF(Date miFecha) {
		return this.day == miFecha.getDay();
	}
	
	public boolean isSame(Date miFecha){
		//boolean retorno = false;
		
		//if(isSameYear(miFecha) && isSameMonth(miFecha) && isSameDay(miFecha))
			//retorno = true;
		
		return (isSameYear(miFecha) && isSameMonth(miFecha) && isSameDay(miFecha));
	}
	
	
	
	@Override
	public String toString() {
		return "Date [day=" + day + ", month=" + month + ", year=" + year + "]";
	}


}
