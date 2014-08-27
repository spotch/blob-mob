package rendering;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.Singleton;

@Singleton
public class CameraProvider implements Provider<OrthographicCamera> {

	private OrthographicCamera _camera;

	@Inject
	public CameraProvider() {
		_camera = new OrthographicCamera();
	}

	@Override
	public OrthographicCamera get() {
		return _camera;
	}

}
