package es.unileon.prg1.date;

public class Date {

	private int day;
	private int month;
	private int year;
	
	public Date(){
		this.day = 1;
		this.month = 1;
		this.year = 2016;
	}
	
	public Date(int day, int month, int year) throws DateException{
		StringBuffer message = new StringBuffer();

		if (day <= 0){
			message.append("Los días no pueden ser negativos: " + day + "\n");
		}
		if (month <= 0){
			message.append("Los meses no pueden ser negativos: " + month + "\n");			
		} else {
			if (month > 12){
				message.append("Sólo hay 12 meses: " + month + "\n");							
			} else {
				if (day>this.daysOfMonth(month)){
					message.append("Combinación inválida: " + day + "/" + month + "\n");						
				}				
			}
		}
		if (year<0){
			message.append("Los años no pueden ser negativos: " + year + "\n");			
		}
		
		if (message.length() != 0){
			throw new DateException(message.toString());
		} else {
			this.day = day;
			this.month = month;
			this.year = year;
		}
	}
		
	public boolean isSameDay(Date other){
		if ( this.day == other.getDay() )
			return true;
		else
			return false;
	}
	
	public boolean isSameMonth(Date other){
		if ( this.month == other.getMonth() ) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isSameYear(Date other){
		return this.year == other.getYear();
	}

	public boolean isSame (Date other){
		return this.isSameDay(other) && this.isSameMonth(other) && this.isSameYear(other);
	}

	public String getMonthName(){
		String name = null;
		switch (this.month){
			case 1:
				name = "Enero";
				break;
			case 2:
				name = "Febrero";
				break;
			case 3:
				name = "Marzo";
				break;
			case 4:
				name = "Abril";
				break;
			case 5:
				name = "Mayo";
				break;
			case 6:
				name = "Junio";
				break;
			case 7:
				name = "Julio";
				break;
			case 8:
				name = "Agosto";
				break;
			case 9:
				name = "Septiembre";
				break;
			case 10:
				name = "Octubre";
				break;
			case 11:
				name = "Noviembre";
				break;
			case 12:
				name = "Diciembre";
				break;
		}
		return name;
	}
		
	private boolean isDayRight(int day){
		return ( ( day > 0 ) && (day <= this.daysOfMonth(this.month) ) );
	}
	
	public int daysOfMonth(){
		return this.daysOfMonth(this.month);
	}
	
	private int daysOfMonth(int month){
		int number = 0;
		switch (month){
		case 1:
		case 3:
		case 5:
		case 7: 
		case 8: 
		case 10:
		case 12:
			number = 31;
			break;
		case 4:
		case 6:
		case 9:
		case 11: 
			number = 30;
			break;
		case 2:
			number = 28;
			break;
		default:
			number = -1;
		}
		return number;
	}

	public String getSeasonName(){
		String name = null;
		switch (this.month){
		case 1: 
		case 2: 
		case 3: 
			name = "Invierno";
			break;
		case 4: 
		case 5: 
		case 6:
			name = "Primavera";
			break;
		case 7: 
		case 8: 
		case 9:
			name = "Verano";
			break;
		case 10:
		case 11:
		case 12:
			name = "Otoño";
			break;
		}
		return name;
	}
	
