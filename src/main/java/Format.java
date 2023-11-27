
public class Format {
    public String format(double sum) {
        if (sum % 10 == 1) {
            return String.format("%.2f рубль", sum);
        } else {
            sum = Math.floor(sum);
            return String.format("%.2f рубля", sum);
        }
    }
}