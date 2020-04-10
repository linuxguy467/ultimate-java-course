package functionalinterface;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class _Predicate {
    public static void main(String[] args) {
        System.out.println("Without Predicate");
        System.out.println(isPhoneNumValid("07000000000"));
        System.out.println(isPhoneNumValid("0700000000"));
        System.out.println(isPhoneNumValid("09009877300"));

        System.out.println("With Predicate");
        System.out.println(isPhoneNumValidPredicate.test("07000000000"));
        System.out.println(isPhoneNumValidPredicate.test("0700000000"));
        System.out.println(isPhoneNumValidPredicate.test("09009877300"));

        System.out.println(
                "Is phone number valid and contains number 3 = " +
                isPhoneNumValidPredicate.and(containsNumber3).test("09009877300")
        );

        System.out.println(
                "Is phone number valid and contains number 3 = " +
                 isPhoneNumValidPredicate.or(containsNumber3).test("07000000000")
        );

        byte digit = 4;
        System.out.println(
                "Is phone number valid and contains number " + digit + " = " +
                isPhoneNumValidAndContainsDigit.test("07000000004", digit)
        );
    }

    static boolean isPhoneNumValid(String phoneNum) {
        return phoneNum.startsWith("07") && phoneNum.length() == 11;
    }

    static Predicate<String> isPhoneNumValidPredicate = phoneNum ->
            phoneNum.startsWith("07") && phoneNum.length() == 11;

    static Predicate<String> containsNumber3 = phoneNum -> phoneNum.contains("3");

    static BiPredicate<String, Byte> isPhoneNumValidAndContainsDigit = (phoneNum, digit) ->
            phoneNum.length() == 11 && phoneNum.contains(digit.toString());
}
