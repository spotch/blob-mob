package blast_it;

import java.util.List;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.google.inject.Inject;
import com.google.inject.name.Named;

public class MissileLauncher implements IMissileLauncher {

	private IMissileFactory _missileFactory;
	private List<Missile> _missileList;
	private Stage _stage;

	@Inject
	public MissileLauncher(@Named("MissileList") List<Missile> missileList,
			IMissileFactory missileFactory,
			Stage stage) {
		_missileList = missileList;
		_missileFactory = missileFactory;
		_stage = stage;
	}

	@Override
	public void launch(float x, float y, float rotation) {
		Missile missile = _missileFactory.create(x, y, rotation);
		_missileList.add(missile);
		_stage.addActor(missile);
	}

}
