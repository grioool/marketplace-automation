package by.sam_solutions.grigorieva.olga.backend.exception;

import by.sam_solutions.grigorieva.olga.backend.domain.localization.Messages;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.Locale;

@NoArgsConstructor
@AllArgsConstructor
public class BusinessException extends RuntimeException {

    private String messageKey;

    private Locale locale;

    public BusinessException(String messageKey) {
        this.messageKey = messageKey;
        locale = Locale.getDefault();
    }

    public String getLocalizedMessage() {
        return Messages.getMessageForLocale(messageKey, locale);
    }
}
