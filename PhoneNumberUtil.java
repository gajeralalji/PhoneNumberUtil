
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author : Lalji Gajera
 * @version : 1.0
 * This Class used to format any string of alphanumeric to desired phone number format specified by parameter
 * Developed By : Lalji Gajera
 */
public class PhoneNumberUtil {
    public PhoneNumberUtil() {
        super();
    }

    /**
     * @param number is String containing any characters whatever to be formated  ex: 1234567890
     * @param format : format must specify with capital X , Ex:  XXX-XXX-XXXX
     * @param maxLength : allowed max length of number ex: 10
     * @return return well formated phone number ex: 123-456-7890
     */
    public static String formateToPhoneNumber(String number, String format,int maxLength){
        String onlyDidgits = number.replaceAll("\\D+","");
        if(onlyDidgits.length()>maxLength){
            //now we have only digit that is max 10 length
            onlyDidgits=onlyDidgits.substring(0,maxLength);
        }
        
        char[] arr = new char[format.length()];
        int i = 0;
        for (int j = 0; j < format.length(); j++) {
            if(i>=onlyDidgits.length())
                break;
            if (format.charAt(j) == 'X')
                arr[j] = onlyDidgits.charAt(i++);
            else
                arr[j] = format.charAt(j);
        }
        String formatedNo=  new String(arr);
        
        Pattern p = Pattern.compile("[0-9]");
        Matcher m = p.matcher(""+(formatedNo.charAt(formatedNo.length()-1)));
        
        //remove non digit char from last if length is <10
        if(!m.matches()){
            //trim last char
           formatedNo= new StringBuilder(formatedNo).deleteCharAt(formatedNo.length()-1).toString(); 
        }
      
        return formatedNo;
    }
    
    
}
