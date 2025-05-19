

package com.eBanking.ui.engine;

import java.util.UUID;

public class Common {
	
	public static String random()
	{
		return UUID.randomUUID().toString().substring(0, 6);
	}

}
