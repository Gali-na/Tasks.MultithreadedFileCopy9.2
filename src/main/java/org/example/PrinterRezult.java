package org.example;

import java.io.File;
import java.math.BigDecimal;

import static java.math.BigDecimal.ROUND_CEILING;

public class PrinterRezult {
    private BigDecimal stepForPrint;
    private File fileForCopy;

    private BigDecimal percentPrinting;

    public PrinterRezult(File fileForCopy) {
        this.fileForCopy = fileForCopy;
        stepForPrint = initCount();
        percentPrinting = initCount();
    }

    public BigDecimal initCount() {
        long sizeFile = fileForCopy.length();
        float numbeкСopySteps = sizeFile / 1024f;
        float temp = 100f / numbeкСopySteps;
        BigDecimal count = new BigDecimal(String.valueOf(temp));
        count.setScale(1, ROUND_CEILING);
        return count;
    }

    public String showRezult() {
        String rezult = "";
        long sizeFile = this.fileForCopy.length();
        long numbeкСopySteps = sizeFile / 1024;
        stepForPrint.setScale(1, ROUND_CEILING);
        if (numbeкСopySteps <= 1) {
            return "100%";

        }
        if ((percentPrinting).compareTo(new BigDecimal(100)) >= 0) {
            return "100%";
        } else {
            rezult = String.valueOf(percentPrinting) + "%";
            percentPrinting = percentPrinting.add(stepForPrint);
            return rezult;
        }
    }
}
