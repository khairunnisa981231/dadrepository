package translation;

import java.io.Serializable;

public class Translation implements Serializable
{
	private String translatedText;
	
	public String getTranslation()
	{
		return translatedText;
	}
	
	public void setTranslation(String translatedText)
	{
		this.translatedText = translatedText;
	}
}
