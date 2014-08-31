package main;

import com.google.inject.AbstractModule;
import com.google.inject.name.Names;

public class MainModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(IMain.class).to(Main.class);

		bind(Float.class).annotatedWith(Names.named("ScreenWidth")).toInstance(new Float(1280.0f));
		bind(Float.class).annotatedWith(Names.named("ScreenHeight")).toInstance(new Float(1024.0f));
		bind(Float.class).annotatedWith(Names.named("CannonWidth")).toInstance(new Float(128.0f));
		bind(Float.class).annotatedWith(Names.named("CannonHeight")).toInstance(new Float(128.0f));
	}

}
