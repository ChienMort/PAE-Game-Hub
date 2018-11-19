package localization;

import java.util.Locale;
import java.util.ResourceBundle;

public class ProjectLocale {
	
	public static Locale english = new Locale("localization.LabelsBundle_en");
	public static Locale espanol = new Locale("localization.LabelsBundle_es");
	
	public static ResourceBundle rb = ResourceBundle.getBundle(english.getDisplayName());
	
	
	public static void setLanguage(int i){
		switch(i){
		default:
			rb.getBundle(english.getDisplayName());
			break;
			
		case 1:
			rb.getBundle(espanol.getDisplayName());
			break;
		}
		
	}
	
	
}
