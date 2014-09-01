package blast_it;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.google.inject.AbstractModule;
import com.google.inject.assistedinject.FactoryModuleBuilder;
import com.google.inject.name.Names;

public class BlastItModule extends AbstractModule {

	@Override
	protected void configure() {
		Texture cannonTexture = new Texture(Gdx.files.internal("images/cannon.png"));
		bind(Texture.class).annotatedWith(Names.named("CannonTexture")).toInstance(cannonTexture);

		Texture backgroundTexture = new Texture(Gdx.files.internal("images/background.png"));
		bind(Texture.class).annotatedWith(Names.named("BackgroundTexture")).toInstance(backgroundTexture);

		install(new FactoryModuleBuilder().implement(Cannon.class, Cannon.class).build(CannonFactory.class));

		bind(Float.class).annotatedWith(Names.named("CannonWidth")).toInstance(new Float(128.0f));
		bind(Float.class).annotatedWith(Names.named("CannonHeight")).toInstance(new Float(128.0f));
	}

}
