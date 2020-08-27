import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

public class Temp {

    private static final int MC_BITS = 10;
    private static final int MAX_MC_BIT_PREFIX_LEN = 3;
    private static final long INDEX_MESSAGE_STEM = 0xAA;
    private static final int LTE_SITE_SHIFT = 9;
    private static final long MAX_LTE_SEQNO = 0x3FF; // 11 11111111
    private static final int UPDATE_FLAG_BIT = 0x10000;
    private static int serialNumber = 0;
    private static final int LTE_GS_SHIFT = 14;
    private static final int MAX_LTE_MC = 0x3FF;
    private static final int LTE_MC_SHIFT = 4;
    private static final int GS_SHIFT = 14;
    private static final int GEOSCOPE_BITS = 0x3;
    private static final int GS_CLEAR_MASK = 0x73FFF;
    private static final int GS_FLAG_BIT = 0x40000;

    public static void main(String[] args) {

        String bitPrefix = "1"; // Taken from Sitedata MOCN_SERIAL_NUMBER_PREFIX
        boolean prefixAferSiteBit = true; // set true if prefix is to be added right after Site Bit
        long code;
        System.out.println("Sree Sree INDEX_MESSAGE_STEM = " + INDEX_MESSAGE_STEM);
        do {
            /*code = useLteSeq ? bmcDbAccess.getNextLteSerialNumber(alert)
            : bmcDbAccess.getNextIncrementNumber(bucket);*/
            code = 128; // Number from IncNum table;

            setGeoscope(1);
            if (bitPrefix != null && !bitPrefix.isEmpty() && bitPrefix.length() <= MAX_MC_BIT_PREFIX_LEN) { // Ignore prefixes that are too long
                int shift = MC_BITS - (prefixAferSiteBit ? 1 : 0);
                System.out.println("Sree Sree shift= " + shift);
                for (int i = 0; i < bitPrefix.length(); i++) {
                    shift--;
                    if (bitPrefix.charAt(i) == '1') {    // every char different than '1' is '0'
                        // (hope OWUI checked that...)
                        code |= (long) 1 << shift;        // set i-th (from left) bit
                    } else {
                        code &= ~((long) 1 << shift);    // zero i-th (from left) bit
                    }
                }
            }
        } while (code == INDEX_MESSAGE_STEM);

        System.out.println("Sree Sree = " + code);

        long gs = (serialNumber >> GS_SHIFT) & GEOSCOPE_BITS;
        System.out.println("Sree Sree gs = " + getGeoscope());
        int site = 0;
        long sn = code;
        int prefixLen = 0;
        //long update = ((serialNumber & UPDATE_FLAG_BIT) != 0) ? sn.getUpdateNumber() : 0;
        long update = ((serialNumber & UPDATE_FLAG_BIT) != 0) ? 1 : 0;

        int shift = LTE_SITE_SHIFT - prefixLen;
        long mask = MAX_LTE_SEQNO - (1 << shift);

        System.out.println("Sree Sree shift= " + shift);
        System.out.println("Sree Sree mask= " + mask);
        long result = get3gppSerialNumber(gs, (site << shift) | (sn & mask), update);
        System.out.println("Sree Sree = " + result);// result will be serial number

    }

    public static long get3gppSerialNumber(long gs, long mc, long update) {
        return (gs << LTE_GS_SHIFT)
                | ((mc & MAX_LTE_MC) << LTE_MC_SHIFT)
                | update;
    }

    /**
     * @param geoscope to be set in serial number
     */
    public static void setGeoscope(int geoscope) {
        serialNumber &= GS_CLEAR_MASK;
        serialNumber += ((geoscope & GEOSCOPE_BITS) << GS_SHIFT);
        serialNumber |= GS_FLAG_BIT;
    }

    /**
     * @return the geoscope subfield
     */
    public static int getGeoscope() {
        return (serialNumber >> GS_SHIFT) & GEOSCOPE_BITS;
    }
}
