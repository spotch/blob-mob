package blast_it;

import com.google.inject.assistedinject.Assisted;

public interface ICannonInputFactory {
	public CannonInput create(@Assisted Cannon cannon);
}
