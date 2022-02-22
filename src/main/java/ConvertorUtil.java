public class ConvertorUtil {
    public float convertFahrenheitToCelsius(float fahrenheit){
        return((fahrenheit - 32) * 5 / 9);
    }

    public float convertCelsiusToFahrenheit(float celsius){
        return((celsius * 9 / 5) + 32);
    }
}
