package org.project.util;

import java.util.Map;

public class UtilityController {

    public enum ResponseState {
        NOCHANGE(0, "No action taken"),
        SUCCESS(1, "No errors found"),
        FAILURE(2, "An error has been found");

        private final int code;
        private final String description;

        private ResponseState(int code, String description) {
            this.code = code;
            this.description = description;
        }

        public String getDescription() {
            return description;
        }

        public int getCode() {
            return code;
        }

        @Override
        public String toString() {
            return code + ": " + description;
        }
    }
}
