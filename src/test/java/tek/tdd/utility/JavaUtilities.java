package tek.tdd.utility;

import com.github.javafaker.Faker;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Random;

public class JavaUtilities {
    private static final Faker faker = new Faker();
    private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    private static final Random random = new Random();

    public static String getFirstName() {
        return faker.name().firstName();
    }

    public static String getLastName() {
        return faker.name().lastName();
    }

    public static String getPrefix() {
        String[] prefix = {"Mr.", "Mrs.", "Ms."};
        return prefix[faker.random().nextInt(prefix.length)];
    }

    public static String getGender() {
        String[] gender = {"Male", "Female", "Other"};
        return gender[faker.random().nextInt(gender.length)];
    }

    public static String getMaritalStatus() {
        String[] statuses = {"Single", "Married", "Widow", "Widower", "Divorced"};
        return statuses[faker.random().nextInt(statuses.length)];
    }

    public static String getEmploymentStatus() {
        return faker.job().title();
    }


    public static String getDOB() {
        Date dob = faker.date().birthday(20, 60);
        return sdf.format(dob);
    }

    public static String getAddressType() {
        String[] addressTypes = {"Apartments", "House"};
        return addressTypes[random.nextInt(addressTypes.length)];

    }

    public static String getAddressLine() {
        return faker.address().streetAddress();
    }

    public static String getCity() {
        return faker.address().city();
    }

    public static String getState() {
        return faker.address().state();
    }

    public static String getPostalCode() {
        return faker.address().zipCode();

    }

    public static String getPhoneType() {
        String[] phoneType = {"Mobile", "Home", "Work"};
        return phoneType[random.nextInt(phoneType.length)];
    }

    public static String getRandomPhoneNumber() {
        StringBuilder randomPhone = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            int random = (int) (Math.random() * 10);
            randomPhone.append(String.valueOf(random));
        }
        return randomPhone.toString();
    }

    public static String getExtension() {
        return faker.phoneNumber().extension();
    }

    public static String getPhoneTime() {
        String[] phoneTime = {"Anytime", "Morning", "Afternoon", "Evening"};
        return phoneTime[random.nextInt(phoneTime.length)];
    }

    public static String getMake() {
        String[] carMakes = {"Toyota", "Honda", "Ford", "Chevrolet", "BMW", "Dodge"};
        return carMakes[random.nextInt(carMakes.length)];
    }

    public static String getModel() {
        String[] carModels = {"Corolla", "Civic", "F-150", "Malibu", "X5", "Challenger"};
        return carModels[random.nextInt(carModels.length)];
    }

    public static String getCarYear() {
        int currentYear = LocalDate.now().getYear();
        int minYear = 2010; // Minimum year for cars
        return String.valueOf(minYear + random.nextInt(currentYear - minYear + 1));
    }

    public static String getLicensePlate() {
        return faker.bothify("???-####").toUpperCase();
    }

    public static String phoneNumberFormatter(String phoneNumber) {
        if (phoneNumber.length() != 10) {
            throw new IllegalArgumentException("Invalid phone number, phone number should be 10 digits");
        }
        return String.format("(%s) %s-%s", phoneNumber.substring(0, 3), phoneNumber.substring(3, 6), phoneNumber.substring(6));
    }

    public static void main(String[] args) {
        System.out.println("FirstName: " + getFirstName());
        System.out.println("Last name:" + getLastName());
        System.out.println("Prefix: " + getPrefix());
        System.out.println(getGender());
        System.out.println("Marital Status: " + getMaritalStatus());
        System.out.println(getEmploymentStatus());
        System.out.println(getDOB());
        System.out.println(getAddressType());
        System.out.println(getAddressLine());
        System.out.println("City: " + getCity());
        System.out.println("State: " + getState());
        System.out.println("Zip Code: " + getPostalCode());
        System.out.println("Phone Type: " + getPhoneType());
        System.out.println("Phone Random Number: " + getRandomPhoneNumber());
        System.out.println("Extension: " + getExtension());
        System.out.println("phone Time: " + getPhoneTime());
        System.out.println("Make: " + getMake());
        System.out.println("Model: " + getModel());
        System.out.println("Car Year: " + getCarYear());
        System.out.println("License Plate: " + getLicensePlate());

    }

    public static String getRandomEmail(String name) {
        int randomNumber = (int) (Math.random() * 10000);
        return name + +randomNumber + "@happy.ca";
    }

    public static LocalDate getTodayDate(int plusDays) {
        return LocalDate.now().plusDays(plusDays);
    }

    public static DateTimeFormatter dateFormatter(String pattern) {
        return DateTimeFormatter.ofPattern(pattern);
    }
}
