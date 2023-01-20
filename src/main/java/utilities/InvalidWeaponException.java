package utilities;

/* In this class, we extend the Exception class to create our own custom exception. These exceptions occur whenever
 * a hero tries to equip a weapon that does not belong their specific hero class our when its level is too low
 *  */
public class InvalidWeaponException extends Exception{

        public InvalidWeaponException(String message) {
            super(message);
        }

    }

