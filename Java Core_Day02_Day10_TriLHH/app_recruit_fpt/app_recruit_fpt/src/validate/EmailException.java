package validate;

import java.util.regex.Pattern;

public class EmailException {
    public static final String REGEX_EMAIL = "^(?:^|\\s)[\\w!#$%&'*+/=?^`{|}~-](\\.?[\\w!#$%&'*+/=?^`{|}~-]+)*@\\w+[.-]?\\w*\\.[a-zA-Z]{2,3}\\b$";

    public static boolean validate(String email) {
        Pattern pattern2 = Pattern.compile(REGEX_EMAIL);
        if (!pattern2.matcher(email).matches()) {
            System.out.print(" Co loi sai dinh dang Email ");
            return false;
        }
        return true;
    }

}
