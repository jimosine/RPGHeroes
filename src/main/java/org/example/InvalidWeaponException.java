package org.example;

public class InvalidWeaponException extends Exception{

        private String code;

        public InvalidWeaponException(String message) {
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

