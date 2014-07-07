import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Calendar;
import java.util.Random;


public class CreatePassword
{


	
	
	public String generateRandomCode(int length){
	int i = 1;

	char[] chars = "abcdefghijklmnopqrstuvwxyz2131994".toCharArray();
	StringBuilder stringbuilder = new StringBuilder();
	Random random = new Random();

	while(i<=length){
	    char c = chars[random.nextInt(chars.length)];
	    stringbuilder.append(c);
		i = i+1;
	}
	
	
	
	String code = stringbuilder.toString();
	
	// for the txt-file output
	//date
	Calendar cal = Calendar.getInstance();
    int day = cal.get(Calendar.DATE);
    int month = cal.get(Calendar.MONTH) + 1;
    int year = cal.get(Calendar.YEAR);
    int dow = cal.get(Calendar.DAY_OF_WEEK);
    int dom = cal.get(Calendar.DAY_OF_MONTH);
    int doy = cal.get(Calendar.DAY_OF_YEAR);
    int hod = cal.get(Calendar.HOUR_OF_DAY);
    int min = cal.get(Calendar.MINUTE);
    String date = (+day+"."+month+"."+year+" # "+hod+":"+min); 
	//save
         BufferedWriter out;
		try {
			out = new BufferedWriter(new FileWriter("pw.txt",true));
	        out.write(date+"  ||  password: "+code+"  ||\r");
	        out.close();
	       
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       
         
	
	return code;

}


}