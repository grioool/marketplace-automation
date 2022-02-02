package by.sam_solutions.grigorieva.olga.backend.domain.localization;

import java.util.Locale;
import java.util.ResourceBundle;

public class Messages {

    public static String getMessageForLocale(String messageKey, Locale locale) {
        ResourceBundle resourceBundle = ResourceBundle.getBundle("messages", locale);
        if (resourceBundle.containsKey(messageKey)) return resourceBundle.getString(messageKey);
        return "Unknown key";
    }
}
