package main;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.google.inject.Inject;
import com.google.inject.name.Named;

public class Main implements IMain {

	private FitViewport _viewport;
	private SpriteBatch _spriteBatch;
	private Texture _cannon;
	private Texture _background;

	float _screenWidth, _screenHeight;
	float _cannonWidth, _cannonHeight;

	@Inject
	public Main(SpriteBatch spriteBatch,
			@Named("ScreenWidth") float screenWidth,
			@Named("ScreenHeight") float screenHeight,
			@Named("CannonWidth") float cannonWidth,
			@Named("CannonHeight") float cannonHeight) {
		_spriteBatch = spriteBatch;

		_screenWidth = screenWidth;
		_screenHeight = screenHeight;

		_cannonWidth = cannonWidth;
		_cannonHeight = cannonHeight;
	}

	@Override
	public void create() {
		_viewport = new FitViewport(1280, 1024);
		_background = new Texture(Gdx.files.internal("images/background.png"));
		_cannon = new Texture(Gdx.files.internal("images/cannon.png"));
	}

	@Override
	public void resize(int width, int height) {
		_viewport.update(width, height);
	}

	@Override
	public void render() {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		_spriteBatch.begin();
		_spriteBatch.draw(_background, 0, 0, 1280, 1024);
		_spriteBatch.draw(_cannon, 10, 10, 128, 128);
		_spriteBatch.end();
	}

	@Override
	public void pause() {

	}

	@Override
	public void resume() {
	}

	@Override
	public void dispose() {
	}
}
