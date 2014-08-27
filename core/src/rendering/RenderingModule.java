package rendering;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;
import com.google.inject.AbstractModule;
import com.google.inject.name.Names;

public class RenderingModule extends AbstractModule {

	@Override
	protected void configure() {
		bindConstant().annotatedWith(Names.named("vertexShaderPath")).to("shaders/vertex.shader");
		bindConstant().annotatedWith(Names.named("fragmentShaderPath")).to("shaders/fragment.shader");
		bindConstant().annotatedWith(Names.named("shaderPedantic")).to(false);

		bind(ShaderProgram.class).toProvider(ShaderProvider.class);
		bind(OrthographicCamera.class).toProvider(CameraProvider.class);
	}

}
