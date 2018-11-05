package localization;

import java.util.Locale;
import java.util.ResourceBundle;

public class ProjectLocale {
	
	private static Locale english = new Locale("localization.LabelsBundle_en");
	private static Locale espa�ol = new Locale("localization.LabelsBundle_es");
	
	public static ResourceBundle rb = ResourceBundle.getBundle(espa�ol.getDisplayName());
	
	public static void setLanguage(int i){
		
		switch(i){
		default:
			rb.getBundle(english.getDisplayName());
			break;
			
		case 1:
			rb.getBundle(espa�ol.getDisplayName());
		}
		
	}
	
	
}
