package main;

import blast_it.Background;
import blast_it.Cannon;
import blast_it.CannonFactory;
import blast_it.ICannonInput;
import blast_it.ICannonInputFactory;
import blast_it.ICannonShotInput;
import blast_it.ICannonShotInputFactory;
import blast_it.IMissileLauncher;
import blast_it.IMissileListUpdater;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.google.inject.Inject;

public class Main implements IMain {

	private Stage _stage;
	private Background _background;
	private CannonFactory _cannonFactory;
	private ICannonInputFactory _cannonInputFactory;
	private ICannonInput _cannonInput;
	private ICannonShotInput _cannonShotInput;
	private IMissileListUpdater _missileListUpdater;
	private ICannonShotInputFactory _cannonShotFactory;

	@Inject
	public Main(Stage stage,
			Background background,
			CannonFactory cannonFactory,
			ICannonInputFactory cannonInputFactory,
			IMissileLauncher missileLauncher,
			IMissileListUpdater missileListUpdater,
			ICannonShotInputFactory cannonShotFactory) {
		_stage = stage;
		_background = background;
		_cannonFactory = cannonFactory;
		_cannonInputFactory = cannonInputFactory;
		_missileListUpdater = missileListUpdater;
		_cannonShotFactory = cannonShotFactory;
	}

	@Override
	public void create() {
		Gdx.input.setInputProcessor(_stage);
		_stage.addActor(_background);
		Cannon cannon = _cannonFactory.create();
		_cannonInput = _cannonInputFactory.create(cannon);
		cannon.setCenterPosition(1280 / 2, 256 / 2);
		_stage.addActor(cannon);
		_stage.setKeyboardFocus(cannon);
		_cannonShotInput = _cannonShotFactory.create(cannon);
	}

	@Override
	public void resize(int width, int height) {
		_stage.getViewport().update(width, height);
	}

	@Override
	public void render() {
		float delta = Gdx.graphics.getDeltaTime();
		_cannonInput.update(delta);
		_cannonShotInput.update(delta);
		_missileListUpdater.update(delta);

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
