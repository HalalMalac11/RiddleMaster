package asztalFoglaloSwing;

import java.time.format.DateTimeFormatter;

public interface iDateFormatting {
    DateTimeFormatter fullDateTime=DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    DateTimeFormatter onlyDate=DateTimeFormatter.ofPattern("yyyy-MM-dd");
}
