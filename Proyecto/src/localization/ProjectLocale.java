package localization;

import java.util.ResourceBundle;

public class ProjectLocale
{
	public static String english = "localization.LabelsBundle_en";
	public static String español = "localization.LabelsBundle_es";
	
	public static ResourceBundle rb = ResourceBundle.getBundle(english);
	
	public static void setBundleEng()
	{
		 rb = ResourceBundle.getBundle(english);
	}
	
	public static void setBundleEsp()
	{
		 rb = ResourceBundle.getBundle(español);
	}
}