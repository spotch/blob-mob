package main;

import blast_it.Background;
import blast_it.ICannonFactory;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.google.inject.Inject;

public class Main implements IMain {

	private Stage _stage;
	private Background _background;
	private ICannonFactory _cannonFactory;

	@Inject
	public Main(Stage stage,
			Background background,
			ICannonFactory cannonFactory) {
		_stage = stage;
		_background = background;
		_cannonFactory = cannonFactory;
	}

	@Override
	public void create() {
		Gdx.input.setInputProcessor(_stage);
		_stage.addActor(_background);
		_stage.addActor(_cannonFactory.create());
	}

	@Override
	public void resize(int width, int height) {
		_stage.getViewport().update(width, height);
	}

	@Override
	public void render() {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		_stage.act();
		_stage.draw();
	}

	@Override
	public void pause() {

	}

	@Override
	public void resume() {
	}

	@Override
	public void dispose() {
		_stage.dispose();
	}
}
