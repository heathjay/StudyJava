package com.jay.java.Pattern.Builder;

import com.jay.java.Pattern.Builder.Modules.Engine;
import com.jay.java.Pattern.Builder.Modules.Escape;
import com.jay.java.Pattern.Builder.Modules.OribtalModule;

public interface AirshipBuilder {
	Engine builderEngine();
	OribtalModule builderOrbitalModule();
	Escape builderEscape();
}
