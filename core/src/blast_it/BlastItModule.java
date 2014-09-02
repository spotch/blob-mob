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

		bind(Float.class).annotatedWith(Names.named("CannonRotationAmount")).toInstance(new Float(100.0f));

		install(new FactoryModuleBuilder().implement(ICannonInput.class, CannonInput.class).build(ICannonInputFactory.class));

		bind(Float.class).annotatedWith(Names.named("MinCannonRotation")).toInstance(new Float(-50.0f));
		bind(Float.class).annotatedWith(Names.named("MaxCannonRotation")).toInstance(new Float(50.0f));

		bind(ICannonRotationBounder.class).to(CannonRotationBounder.class);
	}

}
