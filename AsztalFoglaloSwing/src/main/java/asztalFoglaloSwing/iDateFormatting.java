package asztalFoglaloSwing;

import java.time.format.DateTimeFormatter;

public interface iDateFormatting {
    final DateTimeFormatter FULLDATETIME=DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    final  DateTimeFormatter ONLYDATE=DateTimeFormatter.ofPattern("yyyy-MM-dd");
    final DateTimeFormatter ONLYTIME=DateTimeFormatter.ofPattern("HH:mm");
}
