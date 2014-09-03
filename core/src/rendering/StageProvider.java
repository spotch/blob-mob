package rendering;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.Singleton;

@Singleton
public class StageProvider implements Provider<Stage> {

	private Stage _stage;

	@Inject
	public StageProvider(Viewport viewport) {
		_stage = new Stage(viewport);
	}

	@Override
	public Stage get() {
		return _stage;
	}

}
