
public class Format {
    public String format(double sum) {
        int rubles = (int) Math.floor(sum);

        int lastDigit = rubles % 10;
        int tensDigit = (rubles / 10) % 10;

        if (tensDigit == 1) {
            return String.format("%.2f рублей", sum);
        } else {
            if (lastDigit == 1) {
                return String.format("%.2f рубль", sum);
            } else if (lastDigit >= 2 && lastDigit <= 4) {
                return String.format("%.2f рубля", sum);
            } else {
                return String.format("%.2f рублей", sum);
            }
        }
    }
}