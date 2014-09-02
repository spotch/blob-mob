package blast_it;

import com.google.inject.Inject;
import com.google.inject.name.Named;

public class CannonRotationBounder implements ICannonRotationBounder {

	private float _minCannonRotation, _maxCannonRotation;

	@Inject
	public CannonRotationBounder(@Named("MinCannonRotation") float minCannonRotation,
			@Named("MaxCannonRotation") float maxCannonRotation) {
		_minCannonRotation = minCannonRotation;
		_maxCannonRotation = maxCannonRotation;
	}

	@Override
	public float bound(float unboundRotation) {
		float boundRotation = unboundRotation;

		if (boundRotation > _maxCannonRotation) {
			boundRotation = _maxCannonRotation;
		}

		if (boundRotation < _minCannonRotation) {
			boundRotation = _minCannonRotation;
		}

		return boundRotation;
	}
}
