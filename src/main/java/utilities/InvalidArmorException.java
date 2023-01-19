package utilities;

public class InvalidArmorException extends Exception{

    private String code;

    public InvalidArmorException(String message) {
        super(message);
    }

//        public InvalidWeaponException(String code, String message, Throwable cause) {
//            super(message, cause);
//            this.setCode(code);
//        }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}

