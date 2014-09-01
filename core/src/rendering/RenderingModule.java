package rendering;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.google.inject.AbstractModule;
import com.google.inject.name.Names;

public class RenderingModule extends AbstractModule {

	@Override
	protected void configure() {
		bindConstant().annotatedWith(Names.named("vertexShaderPath")).to("shaders/vertex.shader");
		bindConstant().annotatedWith(Names.named("fragmentShaderPath")).to("shaders/fragment.shader");
		bindConstant().annotatedWith(Names.named("shaderPedantic")).to(false);

		bind(Float.class).annotatedWith(Names.named("ScreenWidth")).toInstance(new Float(1280.0f));
		bind(Float.class).annotatedWith(Names.named("ScreenHeight")).toInstance(new Float(1024.0f));

		bind(ShaderProgram.class).toProvider(ShaderProvider.class);
		bind(OrthographicCamera.class).toProvider(CameraProvider.class);
		bind(Viewport.class).toProvider(ViewportProvider.class);
	}

}
