package rendering;

import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.Singleton;
import com.google.inject.name.Named;

@Singleton
public class ViewportProvider implements Provider<Viewport> {

	private Viewport _viewport;

	@Inject
	public ViewportProvider(@Named("ScreenWidth") float screenWidth,
			@Named("ScreenHeight") float screenHeight) {
		_viewport = new FitViewport(screenWidth, screenHeight);
	}

	@Override
	public Viewport get() {
		return _viewport;
	}

}
