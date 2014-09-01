package main;

import blast_it.Background;
import blast_it.Cannon;
import blast_it.CannonFactory;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.google.inject.Inject;

public class Main implements IMain {

	private Stage _stage;
	private Background _background;
	private CannonFactory _cannonFactory;

	@Inject
	public Main(Stage stage,
			Background background,
			CannonFactory cannonFactory) {
		_stage = stage;
		_background = background;
		_cannonFactory = cannonFactory;
	}

	@Override
	public void create() {
		Gdx.input.setInputProcessor(_stage);
		_stage.addActor(_background);
		Cannon cannon = _cannonFactory.create();
		cannon.setCenterPosition(1280/2, 256/2);
		_stage.addActor(cannon);
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
