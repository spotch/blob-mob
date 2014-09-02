package blast_it;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.google.inject.Inject;
import com.google.inject.assistedinject.Assisted;
import com.google.inject.name.Named;

public class CannonInput implements ICannonInput {

	private Cannon _cannon;
	private float _currentRotation;
	private float _rotationAmount;
	private ICannonRotationBounder _cannonRotationBounder;

	@Inject
	public CannonInput(@Assisted Cannon cannon,
			@Named("CannonRotationAmount") float rotationAmount,
			ICannonRotationBounder cannonRotationBounder) {
		_cannon = cannon;
		_rotationAmount = rotationAmount;
		_currentRotation = 0;
		_cannonRotationBounder = cannonRotationBounder;
	}

	public void update(float delta) {
		float rotationThisFrame = delta * _rotationAmount;

		if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
			_currentRotation += rotationThisFrame;
		} else if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
			_currentRotation -= rotationThisFrame;
		}

		_currentRotation = _cannonRotationBounder.bound(_currentRotation);

		_cannon.setRotation(_currentRotation);
	}

}
