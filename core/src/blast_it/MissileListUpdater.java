package blast_it;

import java.util.List;

import com.google.inject.Inject;
import com.google.inject.name.Named;

public class MissileListUpdater implements IMissileListUpdater {

	List<Missile> _missileList;

	@Inject
	public MissileListUpdater(@Named("MissileList") List<Missile> missileList) {
		_missileList = missileList;
	}

	@Override
	public void update(float delta) {
		for (Missile missile : _missileList) {
			missile.update(delta);
		}
	}

}
