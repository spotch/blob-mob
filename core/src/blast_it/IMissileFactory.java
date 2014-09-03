package blast_it;

import com.google.inject.assistedinject.Assisted;

public interface IMissileFactory {
	public Missile create(@Assisted("x") float x, @Assisted("y") float y, @Assisted("rotation") float rotation);
}
