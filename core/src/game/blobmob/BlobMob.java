package game.blobmob;

import main.IMain;
import main.ModuleList;

import com.badlogic.gdx.ApplicationAdapter;
import com.google.inject.Guice;
import com.google.inject.Injector;

public class BlobMob extends ApplicationAdapter {

	private IMain _main;

	@Override
	public void create() {
		ModuleList moduleList = new ModuleList();
		Injector injector = Guice.createInjector(moduleList.getModules());
		_main = injector.getInstance(IMain.class);
		_main.create();
	}

	@Override
	public void resize(int width, int height) {
		_main.resize(width, height);
	}

	@Override
	public void render() {
		_main.render();
	}

	@Override
	public void pause() {
		_main.pause();
	}

	@Override
	public void resume() {
		_main.resume();
	}

	@Override
	public void dispose() {
		_main.dispose();
	}
}
