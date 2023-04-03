package validate;

import exception.UserException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BirthDayException {
    public static boolean checkYear(String birthAsString) {
        Date date = new Date();
        int year = Integer.parseInt(birthAsString.substring(0, 4));
        int yearNow = Integer.parseInt(new SimpleDateFormat("yyyy").format(date));
        return yearNow > year && year > 1900;
    }

    public static Date validate(String birthAsString) throws exception.UserException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        format.setLenient(false);
        Date birthDay = null;
        try {
            birthDay = format.parse(birthAsString);
            return birthDay;
        } catch (ParseException e) {
            throw new UserException(Message.DATE_FORMAT);
        } catch (Exception e) {
            throw new UserException(Message.ERROR);
        }
    }
}
