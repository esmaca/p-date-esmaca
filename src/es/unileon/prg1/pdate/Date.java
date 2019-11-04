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
	
	public String season() {
		String estacion = new String();
		
		
		if (this.month>=3 && this.month<=5)
			estacion =  "Primavera";
		if (this.month>=6 && this.month<=8)
			estacion = "Verano";
		if (this.month>=9 && this.month<=11)
			estacion = "Otoño";
		if (this.month==12 && this.month<=2)
			estacion = "Invierno";
		
		return estacion;
	}
	
	public int numSameDateWHILE() throws DateException {
		int cont=0;
		
		Date randomDate = new Date();
		randomDate.setYear(this.year);
		
		while(isSame(randomDate)) {
			randomDate.setDay((int)((Math.random()*31)+1));
			randomDate.setMonth((int)((Math.random()*12)+1));
			
			cont++;
		}
		
		return cont;
	}
	
	public int numSameDateDOWHILE() throws DateException {
		int cont=0;
		
		Date randomDate = new Date();
		randomDate.setYear(this.year);
		
		do {
			randomDate.setDay((int)((Math.random()*31)+1));
			randomDate.setMonth((int)((Math.random()*12)+1));
			
			cont++;
		} while(isSame(randomDate));
		
		return cont;
	}
	
	public String monthsLeft() {
		String restantes = new String();
		
		if(this.month<2)
			restantes.concat("Febrero\t");
		if(this.month<3)
			restantes.concat("Marzo\t");
		if(this.month<4)
			restantes.concat("Abril\t");
		if(this.month<5)
			restantes.concat("Mayo\t");
		if(this.month<6)
			restantes.concat("Junio\t");
		if(this.month<7)
			restantes.concat("Julio\t");
		if(this.month<8)
			restantes.concat("Agosto\t");
		if(this.month<9)
			restantes.concat("Septiembre\t");
		if(this.month<10)
			restantes.concat("Octubre\t");
		if(this.month<11)
			restantes.concat("Noviembre\t");
		if(this.month<12)
			restantes.concat("Diciembre\t");
		
		return restantes;
	}
	
	
	
	@Override
	public String toString() {
		return "Date [day=" + day + ", month=" + month + ", year=" + year + "]";
	}
	
	public String daysLeft() {
		String restantes = new String();
		//String aux = new String();
		
		//***dias 2-28
		for (int i=this.day+1; i<=28; i++) {
			//aux = String.valueOf(i);
			restantes.concat(String.valueOf(i)+"\t");
		}
		
		//***dia 29
		if (this.day<29 && this.month!=2)
			restantes.concat("29\t");
		//***dia 30
		if (this.day<30 && this.month!=2)
			restantes.concat("30\t");
		//***dia 31
		if (this.day<31 && this.month!=2 && this.month!=4 && this.month!=6 && this.month!=9 && this.month!=11)
			restantes.concat("31\t");
		
		
		return restantes;
	}
	
	public String monthsWithSameNumDays() throws DateException {
		String meses = new String();
		
		switch(this.month) {
			case 1: case 3: case 5: case 7: case 8: case 10: case 12:
				meses ="Enero, Marzo, Mayo, Julio, Agosto, Octubre y Diciembre";
				break;
			case 2:
				meses = "No hay otros meses con el mismo numero de dias";
				break;
			case 4: case 6: case 9: case 11:
				meses = "Abril, Junio, Septiembrey Noviembre";
				break;
			default : 
				throw new DateException("Fecha fuera del intervalo");
		}
		
		return meses;
	}
	


}
