
public class Temperature {
	
	private double temperature;
	private char scale;
	
	public Temperature() {
		this.temperature = 0.0;
		this.scale = 'C';
	}
	
	public Temperature(double temp, char scale1) {
		setTemperature(temp,scale);
	}
	
	public double getTempInCelsius() {
		if(scale == 'C') {
			return temperature;
		} else {
			return (double) 5/9 * (temperature - 32);
		}
	}
	
	public void setTemperature(double temp, char scale) {
		this.temperature = temp;
		if(scale == 'F') {
			this.scale = scale;
		} else {
			this.scale = 'C';
		}
	}
	
	public boolean isHotter(Temperature temp) {
		return this.getTempInCelsius() > temp.getTempInCelsius();
	}
	
	public double add(Temperature temp) {
		return this.getTempInCelsius() + temp.getTempInCelsius();
	}
	
	@Override
	public String toString() {
		return String.format("Temperature [temperature: %f", temperature + ", scale: %s", scale + "]");
	}
	
	
}
