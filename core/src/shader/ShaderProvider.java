package shader;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.Singleton;
import com.google.inject.name.Named;

@Singleton
public class ShaderProvider implements Provider<ShaderProgram> {

	private ShaderProgram _shader;

	@Inject
	public ShaderProvider(@Named("vertexShaderPath") String vertexShaderPath,
			@Named("fragmentShaderPath") String fragmentShaderPath,
			@Named("shaderPedantic") boolean shaderPedantic) {

		FileHandle vertexShader = Gdx.files.internal(vertexShaderPath);
		FileHandle fragmentShader = Gdx.files.internal(fragmentShaderPath);

		ShaderProgram.pedantic = shaderPedantic;

		_shader = new ShaderProgram(vertexShader.readString(), fragmentShader.readString());

		String log = _shader.getLog();
		if (!_shader.isCompiled()) {
			throw new GdxRuntimeException(log);
		}
		if (log != null && log.length() != 0) {
			System.out.println("Shader Log: " + log);
		}
	}

	@Override
	public ShaderProgram get() {
		return _shader;
	}

}
