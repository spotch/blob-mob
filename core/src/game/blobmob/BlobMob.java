package game.blobmob;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Mesh;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.VertexAttribute;
import com.badlogic.gdx.graphics.VertexAttributes.Usage;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.google.inject.Guice;
import com.google.inject.Injector;

public class BlobMob extends ApplicationAdapter {
	private float[] _verts;
	private Mesh _mesh;
	private ShaderProgram _shader;
	private OrthographicCamera _camera;

	private ShaderProgram createShader() {
		String vertShader = "attribute vec2 a_position;\n"
				+ "attribute vec4 a_color;\n"
				+ "uniform mat4 u_projTrans;\n"
				+ "varying vec4 vColor;\n"
				+ "void main() {\n"
				+ "	vColor = a_color;\n"
				+ "	gl_Position =  u_projTrans * vec4(a_position.xy, 0.0, 1.0);\n"
				+ "}";
		String fragShader = "#ifdef GL_ES\n" + "precision mediump float;\n"
				+ "#endif\n" + "varying vec4 vColor;\n" + "void main() {\n"
				+ "	gl_FragColor = vColor;\n" + "}";
		ShaderProgram.pedantic = false;
		ShaderProgram shader = new ShaderProgram(vertShader, fragShader);
		String log = shader.getLog();
		if (!shader.isCompiled())
			throw new GdxRuntimeException(log);
		if (log != null && log.length() != 0)
			System.out.println("Shader Log: " + log);
		return shader;
	}

	@Override
	public void create() {
		Injector injector = Guice.createInjector(new BlobMobModule());
		_verts = new float[] {
			0.0f, 0.0f, 1.0f, 1.0f, 1.0f, 1.0f,
			1.0f, 0.0f, 1.0f, 1.0f, 1.0f, 1.0f,
			1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f
		};
		_mesh = new Mesh(true, 3, 0, new VertexAttribute(Usage.Position, 2,
				"a_position"), new VertexAttribute(Usage.Color, 4, "a_color"));
		_mesh.setVertices(_verts);

		_shader = createShader();

		_camera = new OrthographicCamera();
	}

	@Override
	public void render() {
		Gdx.gl.glClearColor(0.1f, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		Gdx.gl.glDepthMask(false);
		Gdx.gl.glEnable(GL20.GL_BLEND);
		Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
		_camera.setToOrtho(false, 1.0f, 1.0f);
		_shader.begin();
		_shader.setUniformMatrix("u_projTrans", _camera.combined);
		_mesh.render(_shader, GL20.GL_TRIANGLES, 0, 3);
		_shader.end();
		Gdx.gl.glDepthMask(true);
	}

	@Override
	public void dispose() {
		_mesh.dispose();
		_shader.dispose();
	}
}
