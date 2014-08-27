package main;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Mesh;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.VertexAttribute;
import com.badlogic.gdx.graphics.VertexAttributes.Usage;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;
import com.google.inject.Inject;

public class Main implements IMain {

	private ShaderProgram _shader;
	private OrthographicCamera _camera;

	private float[] _verts;
	private Mesh _mesh;

	@Inject
	public Main(ShaderProgram shader,
			OrthographicCamera camera) {
		_shader = shader;
		_camera = camera;
	}

	@Override
	public void create() {
		_verts = new float[] { 0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f, 1.0f, 0.0f, 1.0f, 0.0f, 1.0f, 1.0f, 1.0f, 1.0f,
				1.0f, 1.0f, 0.0f, 1.0f };
		_mesh = new Mesh(true, 3, 0, new VertexAttribute(Usage.Position, 2, "a_position"), new VertexAttribute(
				Usage.Color, 4, "a_color"));
		_mesh.setVertices(_verts);
	}

	@Override
	public void resize(int width, int height) {

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
	public void pause() {

	}

	@Override
	public void resume() {

	}

	@Override
	public void dispose() {
		_mesh.dispose();
		_shader.dispose();
	}
}
