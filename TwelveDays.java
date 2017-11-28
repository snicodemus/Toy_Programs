public class TwelveDays {
    public static void main(String[] args) {
        String[] days = {"first", "second", "third", "fourth", "fifth", "sixth", "seventh",
                     "eighth", "ninth", "tenth", "eleventh", "twelfth"};
        for (int day = 1; day <= 12; day++) {
            System.out.println("On the " + days[day-1] +
                      " day of Christmas, my true love gave to me");
            switch(day) {
                case 12: System.out.println("Twelve drummers drumming");
                case 11: System.out.println("Eleven pipers piping");
                case 10: System.out.println("Ten lords a leaping");
                case 9:  System.out.println("Nine ladies dancing");
                case 8:  System.out.println("Eight maids a milking");
                case 7:  System.out.println("Seven swans a swimming");
                case 6:  System.out.println("Six geese a laying");
                case 5:  System.out.println("Five gold rings");
                case 4:  System.out.println("Four calling birds");
                case 3:  System.out.println("Three French hens");
                case 2:  System.out.println("Two turtle doves");
                case 1:  System.out.println(((day==1) ? "A" : "And a") +
                      " partridge in a pear tree\n");
            }
        }
    }
}