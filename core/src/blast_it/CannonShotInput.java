package blast_it;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.google.inject.Inject;
import com.google.inject.assistedinject.Assisted;
import com.google.inject.name.Named;

public class CannonShotInput implements ICannonShotInput {

	private float _currentCooldown;
	private float _cooldownTime;

	private IMissileLauncher _missileLauncher;

	private Cannon _cannon;

	@Inject
	public CannonShotInput(@Named("CannonShotCooldownTime") float cooldownTime,
			IMissileLauncher missileLauncher,
			@Assisted Cannon cannon) {
		_cooldownTime = cooldownTime;
		_currentCooldown = 0;
		_missileLauncher = missileLauncher;
		_cannon = cannon;
	}

	@Override
	public void update(float delta) {
		_currentCooldown -= delta;

		if (_currentCooldown < 0) {
			_currentCooldown = 0;
		}

		if (Gdx.input.isKeyPressed(Input.Keys.SPACE)) {
			if (_currentCooldown <= 0.0f) {
				_missileLauncher.launch(_cannon.getX(), _cannon.getY(), _cannon.getRotation());
				_currentCooldown = _cooldownTime;
			}
		}
	}

}
