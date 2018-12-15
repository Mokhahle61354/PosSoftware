
package MainInterface;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TimeManagement
{
	String StartOfDutyTime;
	String EndOfDutyTime;
	
	public String getCurrentTime()
	{
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		return dateFormat.format(date);
	}
        
        
        public Date toDate(String yyyyMMdd)
        {
            Date date = null;
            try {
                date = new SimpleDateFormat("yyyy/MM/dd").parse(yyyyMMdd);
                return date;
            } catch (ParseException ex) {
                Logger.getLogger(TimeManagement.class.getName()).log(Level.SEVERE, null, ex);
            }
            finally
            {
                return date;
            }
            
        }
        
        public String getCurrentDate()
	{
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		Date date = new Date();
		return dateFormat.format(date);
	}
	
	public void setStartOfDutyTime()
	{
		StartOfDutyTime = getCurrentTime();
	}

	public void setEndOfDutyTime()
	{
		EndOfDutyTime = getCurrentTime();
	}
	
	
	public long GetLogedInTime() throws ParseException
	{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	    Date firstDate = sdf.parse(StartOfDutyTime);
	    Date secondDate = sdf.parse(EndOfDutyTime);
	    
	    long diffInMillies = Math.abs(secondDate.getTime() - firstDate.getTime());
	    long diff = TimeUnit.HOURS.convert(diffInMillies, TimeUnit.MILLISECONDS);
	    
		return diff;
	}
	
	

}
