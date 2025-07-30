package myjavademos;
/* 27.Create an enum of the six types of paper currency. Loop through the values( ) and print each value. Write a switch statement for the enum.  For each
   case, output a description of that particular currency.
 */

//Define an enum with six paper currencies
enum Currency {
 TEN, TWENTY, FIFTY, HUNDRED, TWOHUNDRED, FIVEHUNDRED
}

public class Exercise27 {
 public static void main(String[] args) {
     // Loop through enum values and print them
     System.out.println("Paper Currencies:");
     for (Currency c : Currency.values()) {
         System.out.println("- " + c);
     }

     System.out.println("\nCurrency Descriptions:");

     // Switch statement with enum
     for (Currency currency : Currency.values()) {
         switch (currency) {
             case TEN:
                 System.out.println("TEN: Smallest paper currency denomination.");
                 break;
             case TWENTY:
                 System.out.println("TWENTY: Commonly used, often given as change.");
                 break;
             case FIFTY:
                 System.out.println("FIFTY: Handy for daily transactions.");
                 break;
             case HUNDRED:
                 System.out.println("HUNDRED: Popular for moderate purchases.");
                 break;
             case TWOHUNDRED:
                 System.out.println("TWOHUNDRED: Useful for larger shopping or fuel.");
                 break;
             case FIVEHUNDRED:
                 System.out.println("FIVEHUNDRED: High value note, used for major purchases.");
                 break;
             default:
                 System.out.println("Unknown currency.");
         }
     }
 }
}
/*
Paper Currencies:
- TEN
- TWENTY
- FIFTY
- HUNDRED
- TWOHUNDRED
- FIVEHUNDRED

Currency Descriptions:
TEN: Smallest paper currency denomination.
TWENTY: Commonly used, often given as change.
FIFTY: Handy for daily transactions.
HUNDRED: Popular for moderate purchases.
TWOHUNDRED: Useful for larger shopping or fuel.
FIVEHUNDRED: High value note, used for major purchases.
*/